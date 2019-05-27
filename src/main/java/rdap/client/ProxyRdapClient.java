package rdap.client;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rdap.client.data.Error;
import rdap.client.data.*;
import rdap.client.util.JsonUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author dzh
 * @date 2019-04-16 09:51
 */
public abstract class ProxyRdapClient implements RdapClient {

    static final Logger LOG = LoggerFactory.getLogger(ProxyRdapClient.class);

    protected ProxySelector selector;

    protected Properties properties;

    protected ErrorHandler handler;

    public static final Gson GSON = JsonUtil.GSON;

    protected void init(ProxySelector selector, Properties properties, ErrorHandler handler) {
        this.selector = selector;
        this.properties = properties == null ? new Properties() : properties;
        this.handler = handler == null ? defaultErrorHandler() : handler;
    }

    protected ErrorHandler defaultErrorHandler() {
        return (url, code, error) -> {
            LOG.error("{} {} {}", url, code, error);
        };
    }

    public ProxySelector getSelector() {
        return selector;
    }

    protected String property(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

    protected String property(String key) {
        return properties.getProperty(key);
    }

    private HttpURLConnection newConnection(URL url) throws IOException {
        Proxy proxy = null;
        try {
            proxy = selectProxy(url);
        } catch (URISyntaxException e) {
            LOG.error(e.getMessage(), e);
        }

        HttpURLConnection conn = (HttpURLConnection) (proxy == null ? url.openConnection() : url.openConnection(proxy));
        conn.setReadTimeout(Integer.parseInt(property(RdapConst.P_HTTP_READ_TIMEOUT, String.valueOf(RdapConst.DEFAULT_HTTP_READ_TIMEOUT))));
        conn.setConnectTimeout(Integer.parseInt(property(RdapConst.P_HTTP_CONN_TIMEOUT, String.valueOf(RdapConst.DEFAULT_HTTP_CONN_TIMEOUT))));
        conn.setInstanceFollowRedirects(true);
        conn.connect();

        return conn;
    }

    protected RdapRes request(URL url) throws IOException {
        long st = System.currentTimeMillis();

        HttpURLConnection conn = newConnection(url);
        int resCode = conn.getResponseCode();

        if (resCode / 100 == 3) { //redirect
            String newUrl = conn.getHeaderField("Location");
            conn = newConnection(new URL(newUrl));
            resCode = conn.getResponseCode();
            LOG.info("redirect {} {}", url, newUrl);
        }

        try (InputStream in = (resCode / 100 == 2) ? conn.getInputStream() : conn.getErrorStream()) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024]; //TODO config
            int len = -1;
            while ((len = in.read(buf)) != -1) {
                baos.write(buf, 0, len);
            }
            RdapRes res = RdapRes.create(resCode, new String(baos.toByteArray(), RdapConst.UTF8));
            if (LOG.isDebugEnabled()) {
                LOG.debug("{} {}", url, res.getRes());
            }
            if (res.isFail()) {
                error(url, resCode, res.isError() ? GSON.fromJson(res.getRes(), Error.class) : res.getRes());
            }
            return res;
        } finally {
            conn.disconnect();
            LOG.info("{} {} {} {} {}", url, resCode, conn.getContentLength(), conn.getResponseMessage(), System.currentTimeMillis() - st);
        }
    }

    protected Proxy selectProxy(URL url) throws URISyntaxException {
        if (url == null) return null;

        if (selector != null) {
            List<Proxy> list = selector.select(url.toURI());
            int size = list.size();
            if (size > 0) {
                String policy = property(RdapConst.P_HTTP_PROXY_SELECTOR_POLICY, RdapConst.PROXY_SELECTOR_POLICY_ASC);
                switch (policy) {
                    case RdapConst.PROXY_SELECTOR_POLICY_ASC:
                        return list.get(0);
                    case RdapConst.PROXY_SELECTOR_POLICY_DESC:
                        return list.get(size - 1);
                    case RdapConst.PROXY_SELECTOR_POLICY_RANDOM:
                        return list.get(ThreadLocalRandom.current().nextInt(size));
                }
                return list.get(0);//asc
            }
        }

        return null;
    }

    @Override
    public Network ip(String ip, Integer prefix) throws IOException {
        URL reqUrl = new URL(host(), pathIp(ip, prefix));
        RdapRes res = request(reqUrl);
        if (res.isFail()) {
            return null;
        }
        return res.fromJson(Network.class);
    }

    protected String pathIp(String ip, Integer prefix) {
        String path = pathPrefix() + "ip/" + ip;
        if (prefix != null) path += "/" + prefix.toString();
        return path;
    }

    abstract protected URL host() throws MalformedURLException;

    @Override
    public Entity entity(String handle) throws IOException {
        URL reqUrl = new URL(host(), pathEntity(handle));
        RdapRes res = request(reqUrl);
        if (res.isFail()) {
            return null;
        }
        return res.fromJson(Entity.class);
    }

    protected String pathEntity(String handle) {
        return String.join("/", pathPrefix() + "entity", handle);
    }

    @Override
    public Autnum autnum(long asn) throws IOException {
        URL reqUrl = new URL(host(), pathAutnum(asn));
        RdapRes res = request(reqUrl);
        if (res.isFail()) {
            return null;
        }
        return res.fromJson(Autnum.class);
    }

    protected String pathAutnum(long asn) {
        return String.join("/", pathPrefix() + "autnum", String.valueOf(asn));
    }

    @Override
    public Domain domain(String rDNS) throws IOException {
        URL reqUrl = new URL(host(), pathDomain(rDNS));
        RdapRes res = request(reqUrl);
        if (res.isFail()) {
            return null;
        }
        return res.fromJson(Domain.class);
    }

    protected String pathDomain(String rDNS) {
        return String.join("/", pathPrefix() + "domain", rDNS);
    }

    @Override
    public Nameserver nameserver(String host) throws IOException {
        URL reqUrl = new URL(host(), pathNameserver(host));
        RdapRes res = request(reqUrl);
        if (res.isFail()) {
            return null;
        }
        return res.fromJson(Nameserver.class);
    }

    protected String pathNameserver(String host) {
        return String.join("/", pathPrefix() + "nameserver", host);
    }

    @Override
    public Help help() throws IOException {
        URL reqUrl = new URL(host(), pathHelp());
        RdapRes res = request(reqUrl);
        if (res.isFail()) {
            return null;
        }
        return res.fromJson(Help.class);
    }

    protected String pathHelp() {
        return String.join("/", pathPrefix() + "help");
    }

    protected void error(URL url, int code, Object error) {
        if (handler != null) {
            handler.handle(url, code, error);
        }
    }

    protected String pathPrefix() {
        return "";
    }

    private static class RdapRes {

        private int status;
        private String res;//response

        static final RdapRes create(int status, String res) {
            RdapRes r = new RdapRes();
            r.status = status;
            // todo
            // fix Invalid escape sequence at line 42 column 25 path $.vcardArray[1][3][3][3]
            // e.g. "Tolima\Ibagué", -> "Tolima Ibagué",
            r.res = res == null ? res : res.replaceAll("\\\\", " ");

            return r;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getRes() {
            return res;
        }

        public void setRes(String res) {
            this.res = res;
        }

        public boolean isFail() {
            return status >= 300 || status < 200;
        }

        public boolean isError() { //todo
            //return status / 100 == 4;
            return isFail() && res != null && res.charAt(0) == '{';
        }

        public <T> T fromJson(Class<T> clazz) {
            try {
                return GSON.fromJson(res, clazz);
            } catch (IllegalStateException e) {
                LOG.error("{} fromJson {}", clazz.getSimpleName(), res);
                throw e;
            }
        }
    }

}

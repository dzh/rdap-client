package rdap.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rdap.client.data.Error;
import rdap.client.data.*;

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

    protected ErrorHandler errorHandler;

    protected DataHandler dataHandler;

    protected void init(ProxySelector selector, Properties properties, ErrorHandler errorhandler, DataHandler dataHandler) {
        this.selector = selector;
        this.properties = properties == null ? new Properties() : properties;
        this.errorHandler = errorhandler == null ? defaultErrorHandler() : errorhandler;
        this.dataHandler = dataHandler == null ? defaultDataHandler() : dataHandler;
    }

    protected ErrorHandler defaultErrorHandler() {
        return (url, code, error) -> {
            LOG.error("{} {} {}", url, code, error);
        };
    }

    protected DataHandler defaultDataHandler() {
        return new DataHandler.JsonDataHandler();
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

        RdapRes res = null;
        try (InputStream in = (resCode / 100 == 2) ? conn.getInputStream() : conn.getErrorStream()) {
            if (in == null) {
                res = RdapRes.create(resCode, null);
                LOG.error("InputStream null {} {}", url, resCode);
            } else {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buf = new byte[1024]; //TODO config
                int len = -1;
                while ((len = in.read(buf)) != -1) {
                    baos.write(buf, 0, len);
                }
                res = RdapRes.create(resCode, new String(baos.toByteArray(), RdapConst.UTF8));
            }
        } finally {
            conn.disconnect();
            LOG.info("{} {} {} {} {}", url, resCode, conn.getContentLength(), conn.getResponseMessage(), System.currentTimeMillis() - st);
        }

        if (LOG.isDebugEnabled()) {
            LOG.debug("{} {} {}", url, resCode, res.getRes());
        }
        if (res.isFail()) {
            error(url, resCode, res.isError() ? dataHandler.decode(res.getRes(), Error.class) : res.getRes());
        }
        return res;
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
        return dataHandler.decode(res.getRes(), Network.class);
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
        return dataHandler.decode(res.getRes(), Entity.class);
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
        return dataHandler.decode(res.getRes(), Autnum.class);
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
        return dataHandler.decode(res.getRes(), Domain.class);
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
        return dataHandler.decode(res.getRes(), Nameserver.class);
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
        return dataHandler.decode(res.getRes(), Help.class);
    }

    protected String pathHelp() {
        return String.join("/", pathPrefix() + "help");
    }

    protected void error(URL url, int code, Object error) {
        if (errorHandler != null) {
            errorHandler.handle(url, code, error);
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
            r.res = clearRes(res);

            return r;
        }

        /**
         * // todo filter illegal character
         * // fix Invalid escape sequence at line 42 column 25 path $.vcardArray[1][3][3][3]
         * // e.g. "Tolima\Ibagué", -> "Tolima Ibagué",
         *
         * @param res
         * @return
         */
        private static final String clearRes(String res) {
            return res;
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
            this.res = clearRes(res);
        }

        public boolean isFail() {
            return status >= 300 || status < 200 || res == null;
        }

        public boolean isError() { //todo
            //return status / 100 == 4;
            return isFail() && res != null && res.charAt(0) == '{';
        }
    }

}

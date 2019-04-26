package rdap.client;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rdap.client.data.Network;

import java.io.IOException;
import java.net.*;
import java.util.List;
import java.util.Properties;

/**
 * @author dzh
 * @date 2019-04-17 14:16
 */
public class TestRdapClient {

    static Logger LOG = LoggerFactory.getLogger(TestRdapClient.class);

    TestProxySelector selector = new TestProxySelector();

    @Test
    public void ipTest() throws IOException {
        RdapClient client = RdapProvider.create(RdapConst.SOURCE_APNIC).build();
        Properties properties = new Properties();

        String ip = "1.2.4.0";
        Network network = client.ip(ip, 24);
        LOG.info("{} {}", ip, network);

        ip = "27.0.0.0";
        network = client.ip(ip, 8);
        LOG.info("{} {}", ip, network);

        // properties.setProperty(RdapConst.P_HTTP_SSL, "false");
//        client = RdapProvider.create(RdapConst.SOURCE_RIPE).selector(selector).properties(properties).build();
//        ip = "5.0.0.1";
//        network = client.ip(ip, null);
//        LOG.info("{} {}", ip, network);
    }

    @Test
    public void urlTest() throws MalformedURLException {
        URL url = new URL("http", RdapConst.RDAP_ARIN_HOST, "/registry");
        LOG.info("url {}", url);
        url = new URL(url, "ip/13.123.12.3");
        LOG.info("url {}", url);
    }

    static class TestProxySelector extends ProxySelector {

        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("60.54.78.45", 8080));

        @Override
        public List<Proxy> select(URI uri) {
            return List.of(proxy);
        }

        @Override
        public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {
            LOG.error("{} {} {} {}", uri, sa, ioe.getMessage(), ioe);
        }
    }

}
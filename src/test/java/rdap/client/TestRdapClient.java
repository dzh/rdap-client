package rdap.client;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rdap.client.data.Autnum;
import rdap.client.data.Entity;
import rdap.client.data.Network;
import rdap.client.util.EntityUtil;
import rdap.client.whois.Role;

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
        Properties properties = new Properties();
        properties.setProperty(RdapConst.P_HTTP_SSL, "false");
        // apnic
        RdapClient client = RdapProvider.create(RdapConst.SOURCE_APNIC).build();

        String ip = "203.113.0.0.1";
        Network network = client.ip(ip, 19);
        LOG.info("{} {}", ip, network);

        if (network != null) {
            List<Entity> entities = network.getEntities();
            for (Entity en : entities) {
                Role r = EntityUtil.getRole(en);
                if (r != null)
                    LOG.info("role {} {}", r.geteMail(), EntityUtil.readEmailDomain(r.geteMail()));

                if (EntityUtil.isAdmin(en)) {
                    LOG.info("admin-c {}", en.getHandle());
                }
                if (EntityUtil.isRegistrant(en)) {
                    LOG.info("mnt_by Registrant {}", en.getHandle());
                }
                if (EntityUtil.isAbuse(en)) {
                    LOG.info("mnt_by Abuse{}", en.getHandle());
                }
            }
        }

//        ip = "103.100.201.0";
//        network = client.ip(ip, 24);
//        LOG.info("{} {}", ip, network);

        // properties.setProperty(RdapConst.P_HTTP_SSL, "false");
//        client = RdapProvider.create(RdapConst.SOURCE_RIPE).selector(selector).properties(properties).build();
//        ip = "5.0.0.1";
//        network = client.ip(ip, null);
//        LOG.info("{} {}", ip, network);

        // ripe
//        client = RdapProvider.create(RdapConst.SOURCE_RIPE).selector(selector).properties(properties).build();
//        ip = "194.206.161.47";
//        network = client.ip(ip, null);
//        LOG.info("{} {}", ip, network);

        // afrinic
//        client = RdapProvider.create(RdapConst.SOURCE_AFRINIC).selector(selector).properties(properties).build();
//        ip = "196.192.116.0";
//        network = client.ip(ip, null);
//        LOG.info("{} {}", ip, network);

        // arin
//        client = RdapProvider.create(RdapConst.SOURCE_ARIN).selector(selector).properties(properties).build();
//        ip = "216.254.222.0";
//        network = client.ip(ip, null);
//        LOG.info("{} {}", ip, network);

        //lacnic
//        client = RdapProvider.create(RdapConst.SOURCE_LACNIC).selector(selector).properties(properties).build();
//        ip = "207.249.128.0";
//        network = client.ip(ip, null);
//        LOG.info("{} {}", ip, network);

        //lacnic br
//        client = RdapProvider.create(RdapConst.SOURCE_LACNIC).cc("BR").selector(selector).properties(properties).build();
//        ip = "45.4.228.0";
//        network = client.ip(ip, null);
//        LOG.info("{} {}", ip, network);
    }

    @Test
    public void autnumTest() throws IOException {
        RdapClient client = RdapProvider.create(RdapConst.SOURCE_APNIC).build();

        long asn = 2925;
        Autnum autnum = client.autnum(asn);
        LOG.info("{} {}", autnum.getHandle(), autnum.getCountry());
    }

    @Test
    public void urlTest() throws MalformedURLException {
        URL url = new URL("http", RdapConst.RDAP_ARIN_HOST, "/registry");
        LOG.info("url {}", url);
        url = new URL(url, "ip/13.123.12.3");
        LOG.info("url {}", url);
    }

    static class TestProxySelector extends ProxySelector {

        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("110.168.85.155", 8080));

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

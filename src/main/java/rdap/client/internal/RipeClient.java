package rdap.client.internal;

import rdap.client.ProxyRdapClient;
import rdap.client.RdapConst;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * https://rdap.db.ripe.net/entity/AA1000-AP
 * https://rdap.db.ripe.net/autnum/6831
 *
 * @author dzh
 * @date 2019-03-21 11:10
 */
public class RipeClient extends ProxyRdapClient {

    @Override
    protected URL host() throws MalformedURLException {
        boolean ssl = Boolean.parseBoolean(property(RdapConst.P_HTTP_SSL, "true"));
        return new URL(ssl ? "https" : "http", RdapConst.RDAP_RIPE_HOST, "");
    }

}

package rdap.client.internal;

import rdap.client.ProxyRdapClient;
import rdap.client.RdapConst;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * https://rdap.apnic.net/ip/1.2.4.0/24
 * https://rdap.apnic.net/entity/AA100-AP
 * https://rdap.apnic.net/autnum/173
 *
 * @author dzh
 * @date 2019-03-21 11:09
 */
public class ApnicClient extends ProxyRdapClient {

    @Override
    protected URL host() throws MalformedURLException {
        boolean ssl = Boolean.parseBoolean(property(RdapConst.P_HTTP_SSL, "true"));
        return new URL(ssl ? "https" : "http", RdapConst.RDAP_APNIC_HOST, "");
    }
}

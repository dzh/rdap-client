package rdap.client.internal;

import rdap.client.ProxyRdapClient;
import rdap.client.RdapConst;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * https://rdap.lacnic.net/rdap/ip/148.201.0.0/16
 * https://rdap.lacnic.net/rdap/autnum/1251
 *
 * @author dzh
 * @date 2019-03-21 11:14
 */
public class LacnicClient extends ProxyRdapClient {

    @Override
    protected URL host() throws MalformedURLException {
        boolean ssl = Boolean.parseBoolean(property(RdapConst.P_HTTP_SSL, "true"));
        return new URL(ssl ? "https" : "http", RdapConst.RDAP_LACNIC_HOST, "");
    }

    @Override
    protected String pathPrefix() {
        return "rdap/";
    }
}

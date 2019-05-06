package rdap.client.internal;

import rdap.client.ProxyRdapClient;
import rdap.client.RdapConst;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author dzh
 * @date 2019-03-21 11:12
 */
public class AfrinicClient extends ProxyRdapClient {

    @Override
    protected URL host() throws MalformedURLException {
        boolean ssl = Boolean.parseBoolean(property(RdapConst.P_HTTP_SSL, "true"));
        return new URL(ssl ? "https" : "http", RdapConst.RDAP_AFRINIC_HOST, "");
    }

    @Override
    protected String pathPrefix() {
        return "rdap/";
    }
}

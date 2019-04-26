package rdap.client.internal;

import rdap.client.ProxyRdapClient;
import rdap.client.RdapConst;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * https://rdap.arin.net/registry/ip/4.0.0.1
 * https://rdap.arin.net/registry/entity/LPL-141
 *
 * @author dzh
 * @date 2019-03-21 11:11
 */
public class ArinClient extends ProxyRdapClient {

    @Override
    protected URL host() throws MalformedURLException {
        boolean ssl = Boolean.parseBoolean(property(RdapConst.P_HTTP_SSL, "true"));
        return new URL(ssl ? "https" : "http", RdapConst.RDAP_ARIN_HOST, "");
    }

    @Override
    protected String pathPrefix() {
        return "registry/";
    }
}

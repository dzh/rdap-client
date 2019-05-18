package rdap.client.internal;

import rdap.client.ProxyRdapClient;
import rdap.client.RdapConst;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * https://rdap.registro.br/ip/160.19.44.0/22
 * https://rdap.registro.br/entity/JRRLI18
 * <p>
 * <p>
 * https://rdap.registro.br/domain/45.19.160.in-addr.arpa
 *
 * @author dzh
 * @date 2019-03-21 11:17
 */
public class RegistroBrClient extends ProxyRdapClient {

    @Override
    protected URL host() throws MalformedURLException {
        boolean ssl = Boolean.parseBoolean(property(RdapConst.P_HTTP_SSL, "true"));
        return new URL(ssl ? "https" : "http", RdapConst.RDAP_REGISTRO_BR_HOST, "");
    }
}

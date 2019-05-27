package rdap.client;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author dzh
 * @date 2019-02-26 14:03
 */
public interface RdapConst extends RdapValue {

    String P_HTTP_READ_TIMEOUT = "http.read.timeout"; //ms
    String P_HTTP_CONN_TIMEOUT = "http.conn.timeout"; //ms
    String P_HTTP_SSL = "http.ssl"; //https=true http=false
    //asc-list.get(0) desc-list.get(size-1) random-list.get([0-size))
    String P_HTTP_PROXY_SELECTOR_POLICY = "http.proxy.selector.policy";

    Charset UTF8 = StandardCharsets.UTF_8;
    int DEFAULT_HTTP_READ_TIMEOUT = 30 * 1000;
    int DEFAULT_HTTP_CONN_TIMEOUT = 30 * 1000;
    String PROXY_SELECTOR_POLICY_ASC = "asc";
    String PROXY_SELECTOR_POLICY_DESC = "desc";
    String PROXY_SELECTOR_POLICY_RANDOM = "random";

    String SOURCE_IANA = "IANA";
    String SOURCE_APNIC = "APNIC";
    String SOURCE_ARIN = "ARIN";
    String SOURCE_AFRINIC = "AFRINIC";
    String SOURCE_LACNIC = "LACNIC";
    String SOURCE_RIPE = "RIPE";

    String ADDRESS_STATUS_UNALLOCATED = "UNALLOCATED";
    String ADDRESS_STATUS_ALLOCATED = "ALLOCATED";
    String ADDRESS_STATUS_RESERVED = "RESERVED";
    String ADDRESS_STATUS_LEGACY = "LEGACY";

    String RDAP_APNIC_HOST = "rdap.apnic.net";
    String RDAP_RIPE_HOST = "rdap.db.ripe.net";
    String RDAP_ARIN_HOST = "rdap.arin.net";
    String RDAP_LACNIC_HOST = "rdap.lacnic.net";
    String RDAP_AFRINIC_HOST = "rdap.afrinic.net";
    String RDAP_REGISTRO_BR_HOST = "rdap.registro.br";

    String WHOIS_APNIC_HOST = "whois.apnic.net";
    String WHOIS_RIPE_HOST = "whois.ripe.net";
    String WHOIS_ARIN_HOST = "whois.arin.net";
    String WHOIS_LACNIC_HOST = "whois.lacnic.net";
    String WHOIS_AFRINIC_HOST = "whois.afrinic.net";


}

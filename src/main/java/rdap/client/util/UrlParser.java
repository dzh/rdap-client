package rdap.client.util;

import rdap.client.RdapConst;

import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author dzh
 * @date 2019-05-10 12:38
 */
public class UrlParser {

    //ip entity autnum domain nameserver help
    public static final Pattern P_RDAP_URL = Pattern.compile("(?<scheme>http|https)\\://(?<host>.+?)/(?<pathPrefix>.+/)?(?<api>ip|entity|autnum|domain|nameserver)/(?<param>.*)");

    private String scheme;
    private String host;
    private String path;

    private String source; //
    private String api; // const: ip entity autnum domain nameserver help
    private String param; // e.g. 24.232.53.4[/30]

    private UrlParser() {
    }

    /**
     * @param url e.g. https://rdap.lacnic.net/rdap/ip/24.232.53.4
     * @return
     */
    public static final UrlParser parse(URL url) {
        UrlParser parser = new UrlParser();

        Matcher m = P_RDAP_URL.matcher(url.toExternalForm());
        if (m.matches()) {
            parser.scheme = m.group("scheme");
            parser.host = m.group("host");

            String pathPrefix = m.group("pathPrefix");
            parser.api = m.group("api");
            parser.param = m.group("param");

            parser.path = pathPrefix == null ? parser.api + "/" + parser.param : pathPrefix + parser.api + "/" + parser.param;

            parser.source = readSouceFromHost(parser.host);
        }

        return parser;
    }

    public static final String readSouceFromHost(String host) {
        if (host == null) return RdapConst.SOURCE_IANA; //error

        switch (host) {
            case RdapConst.RDAP_APNIC_HOST:
                return RdapConst.SOURCE_APNIC;
            case RdapConst.RDAP_RIPE_HOST:
                return RdapConst.SOURCE_RIPE;
            case RdapConst.RDAP_ARIN_HOST:
                return RdapConst.SOURCE_ARIN;
            case RdapConst.RDAP_AFRINIC_HOST:
                return RdapConst.SOURCE_AFRINIC;

            case RdapConst.RDAP_REGISTRO_BR_HOST:
            case RdapConst.RDAP_LACNIC_HOST:
                return RdapConst.SOURCE_LACNIC;
        }
        return RdapConst.SOURCE_IANA; //error
    }

    public String getScheme() {
        return scheme;
    }

    public String getHost() {
        return host;
    }

    public String getPath() {
        return path;
    }

    public String getSource() {
        return source;
    }

    public String getApi() {
        return api;
    }

    public String getParam() {
        return param;
    }

    @Override
    public String toString() {
        return String.join("/", scheme + ":/", host, path);
    }

}

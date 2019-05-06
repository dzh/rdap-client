package rdap.client.util;

/**
 * @author dzh
 * @date 2019-05-06 16:19
 */
public class NetworkUtil {

    /**
     * remove suffix
     * <p>
     * arin "startAddress" : "4.0.0.0",
     * lacnic "startAddress" : "194.206.161.47/32",
     *
     * @param ip ip[/prefix]
     * @return ip
     */
    public static final String cleanAddress(String ip) {
        if (ip == null) return ip;

        int loc = ip.indexOf("/");
        return loc > 0 ? ip.substring(0, loc) : ip;
    }

}

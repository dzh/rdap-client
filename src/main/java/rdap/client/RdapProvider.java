package rdap.client;

import rdap.client.internal.*;

import java.net.ProxySelector;
import java.util.Properties;

/**
 * @author dzh
 * @date 2019-03-26 20:35
 */
public class RdapProvider {

    private String source;
    private String cc;
    private ProxySelector selector;
    private Properties properties;
    private ErrorHandler errorHandler;
    private DataHandler dataHandler;

    private RdapProvider() {
    }

    public static final RdapProvider create(String source) {
        RdapProvider p = new RdapProvider();
        p.source = source;
        return p;
    }

    public RdapProvider source(String souce) {
        this.source = source;
        return this;
    }

    public RdapProvider cc(String cc) {
        this.cc = cc;
        return this;
    }

    public RdapProvider selector(ProxySelector selector) {
        this.selector = selector;
        return this;
    }

    public RdapProvider properties(Properties properties) {
        this.properties = properties;
        return this;
    }

    public RdapProvider errorHandler(ErrorHandler handler) {
        this.errorHandler = handler;
        return this;
    }

    public RdapProvider dataHandler(DataHandler handler) {
        this.dataHandler = handler;
        return this;
    }

    public RdapClient build() {
        if (null == source) return null;

        ProxyRdapClient rdap = null;
        switch (source.toUpperCase()) {
            case RdapConst.SOURCE_AFRINIC:
                rdap = new AfrinicClient();
                break;
            case RdapConst.SOURCE_APNIC:
                rdap = new ApnicClient();
                break;
            case RdapConst.SOURCE_ARIN:
                rdap = new ArinClient();
                break;
            case RdapConst.SOURCE_LACNIC: {
                if ("br".equalsIgnoreCase(cc)) {
                    rdap = new RegistroBrClient();
                } else {
                    rdap = new LacnicClient();
                }
                break;
            }
            case RdapConst.SOURCE_RIPE:
                rdap = new RipeClient();
                break;
            default:
                //rdap = new IanaClient();
                throw new IllegalArgumentException("invalid source " + source);
        }

        rdap.init(selector, properties, errorHandler, dataHandler);

        return rdap;
    }
}

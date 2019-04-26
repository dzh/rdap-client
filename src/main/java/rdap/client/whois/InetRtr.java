package rdap.client.whois;

/**
 * https://www.apnic.net/manage-ip/using-whois/guide/inet-rtr/
 * <p>
 * Represents an Internet router within a Routing Registry.
 *
 * @author dzh
 * @date 2019-03-06 18:44
 */
public class InetRtr {

    private String inetRtr;     //  [mandatory]  [single]     [primary/lookup key]
    private String descr;       //  [mandatory]  [multiple]   [ ]
    private String alias;       //  [optional]   [multiple]   [ ]
    private String localAs;     //  [mandatory]  [single]     [inverse key]
    private String ifaddr;      //  [mandatory]  [multiple]   [lookup key]
    private String interface_;  //  [optional]   [multiple]   [lookup key]
    private String peer;        //  [optional]   [multiple]   [ ]
    private String mpPeer;      //  [optional]   [multiple]   [ ]
    private String memberOf;    //  [optional]   [multiple]   [inverse key]
    private String remarks;     //  [optional]   [multiple]   [ ]
    private String adminC;      //  [mandatory]  [multiple]   [inverse key]
    private String techC;       //  [mandatory]  [multiple]   [inverse key]
    private String notify;      //  [optional]   [multiple]   [inverse key]
    private String mntBy;       //  [mandatory]  [multiple]   [inverse key]
    private String lastModified;//  [generated]  [single]     [ ]
    private String source;      //  [mandatory]  [single]     [ ]

    public String getInetRtr() {
        return inetRtr;
    }

    public void setInetRtr(String inetRtr) {
        this.inetRtr = inetRtr;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getLocalAs() {
        return localAs;
    }

    public void setLocalAs(String localAs) {
        this.localAs = localAs;
    }

    public String getIfaddr() {
        return ifaddr;
    }

    public void setIfaddr(String ifaddr) {
        this.ifaddr = ifaddr;
    }

    public String getInterface_() {
        return interface_;
    }

    public void setInterface_(String interface_) {
        this.interface_ = interface_;
    }

    public String getPeer() {
        return peer;
    }

    public void setPeer(String peer) {
        this.peer = peer;
    }

    public String getMpPeer() {
        return mpPeer;
    }

    public void setMpPeer(String mpPeer) {
        this.mpPeer = mpPeer;
    }

    public String getMemberOf() {
        return memberOf;
    }

    public void setMemberOf(String memberOf) {
        this.memberOf = memberOf;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getAdminC() {
        return adminC;
    }

    public void setAdminC(String adminC) {
        this.adminC = adminC;
    }

    public String getTechC() {
        return techC;
    }

    public void setTechC(String techC) {
        this.techC = techC;
    }

    public String getNotify() {
        return notify;
    }

    public void setNotify(String notify) {
        this.notify = notify;
    }

    public String getMntBy() {
        return mntBy;
    }

    public void setMntBy(String mntBy) {
        this.mntBy = mntBy;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}

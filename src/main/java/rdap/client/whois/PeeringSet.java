package rdap.client.whois;

/**
 * https://www.apnic.net/manage-ip/using-whois/guide/peering-set/
 * <p>
 * Defines a set of peerings listed in the object’s peering attribute.
 *
 * @author dzh
 * @date 2019-03-06 19:30
 */
public class PeeringSet {

    private String peeringSet;          //  [mandatory]  [single]     [primary/lookup key]
    private String descr;               //  [mandatory]  [multiple]   [ ]
    private String peering;             //  [optional]   [multiple]   [ ]
    private String mpPeering;           //  [optional]   [multiple]   [ ]
    private String remarks;             //  [optional]   [multiple]   [ ]
    private String techC;               //  [mandatory]  [multiple]   [inverse key]
    private String adminC;              //  [mandatory]  [multiple]   [inverse key]
    private String notify;              //  [optional]   [multiple]   [inverse key]
    private String mntBy;               //  [mandatory]  [multiple]   [inverse key]
    private String mntLower;            //  [optional]   [multiple]   [inverse key]
    private String lastModified;        //  [generated]  [single]     [ ]
    private String source;              //  [mandatory]  [single]     [ ]

    public String getPeeringSet() {
        return peeringSet;
    }

    public void setPeeringSet(String peeringSet) {
        this.peeringSet = peeringSet;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getPeering() {
        return peering;
    }

    public void setPeering(String peering) {
        this.peering = peering;
    }

    public String getMpPeering() {
        return mpPeering;
    }

    public void setMpPeering(String mpPeering) {
        this.mpPeering = mpPeering;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getTechC() {
        return techC;
    }

    public void setTechC(String techC) {
        this.techC = techC;
    }

    public String getAdminC() {
        return adminC;
    }

    public void setAdminC(String adminC) {
        this.adminC = adminC;
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

    public String getMntLower() {
        return mntLower;
    }

    public void setMntLower(String mntLower) {
        this.mntLower = mntLower;
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

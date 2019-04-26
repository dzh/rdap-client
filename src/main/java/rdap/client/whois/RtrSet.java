package rdap.client.whois;

/**
 * https://www.apnic.net/manage-ip/using-whois/guide/rtr-set/
 * <p>
 * A rtr-set object defines a set of routers.
 *
 * @author dzh
 * @date 2019-03-06 20:15
 */
public class RtrSet {

    private String rtrSet;          //  [mandatory]  [single]     [primary/lookup key]
    private String descr;           //  [mandatory]  [multiple]   [ ]
    private String members;         //  [optional]   [multiple]   [ ]
    private String mpMembers;       //  [optional]   [multiple]   [ ]
    private String mbrsByRef;       //  [optional]   [multiple]   [inverse key]
    private String remarks;         //  [optional]   [multiple]   [ ]
    private String techC;           //  [mandatory]  [multiple]   [inverse key]
    private String adminC;          //  [mandatory]  [multiple]   [inverse key]
    private String notify;          //  [optional]   [multiple]   [inverse key]
    private String mntBy;           //  [mandatory]  [multiple]   [inverse key]
    private String mntLower;        //  [optional]   [multiple]   [inverse key]
    private String lastModified;    //  [generated]  [single]     [ ]
    private String source;          //  [mandatory]  [single]     [ ]

    public String getRtrSet() {
        return rtrSet;
    }

    public void setRtrSet(String rtrSet) {
        this.rtrSet = rtrSet;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getMembers() {
        return members;
    }

    public void setMembers(String members) {
        this.members = members;
    }

    public String getMpMembers() {
        return mpMembers;
    }

    public void setMpMembers(String mpMembers) {
        this.mpMembers = mpMembers;
    }

    public String getMbrsByRef() {
        return mbrsByRef;
    }

    public void setMbrsByRef(String mbrsByRef) {
        this.mbrsByRef = mbrsByRef;
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

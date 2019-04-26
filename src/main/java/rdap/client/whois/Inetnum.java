package rdap.client.whois;

/**
 * https://www.apnic.net/manage-ip/using-whois/guide/inetnum/
 * <p>
 * Contains details of an allocation or assignment of IPv4 address space.
 * <p>
 * Example
 * inetnum:        192.168.1.0 - 192.168.1.255
 * netname:        EXAMPLENET-AP
 * descr:          Example net Pty Ltd
 * country:        AP
 * admin-c:        DE345-AP
 * tech-c:         DE345-AP
 * status:         ASSIGNED NON-PORTABLE
 * mnt-by:         MAINT-EXAMPLENET-AP
 * mnt-irt:        IRT-EXAMPLENET-AP
 * last-modified:  2018-08-30T07:50:19Z
 * source:         APNIC
 *
 * @author dzh
 * @date 2019-03-05 21:18
 */
public class Inetnum {

    private String inetnum;         //  [mandatory]  [single]     [primary/lookup key]
    private String netname;         //  [mandatory]  [single]     [lookup key]
    private String descr;           //  [mandatory]  [multiple]   [ ]
    private String country;         //  [mandatory]  [multiple]   [ ]
    private String geoloc;          //  [optional]   [single]     [ ]
    private String language;        //  [optional]   [multiple]   [ ]
    private String adminC;          //  [mandatory]  [multiple]   [inverse key]
    private String techC;           //  [mandatory]  [multiple]   [inverse key]
    private String status;          //  [mandatory]  [single]     [ ]
    private String remarks;         //  [optional]   [multiple]   [ ]
    private String notify;          //  [optional]   [multiple]   [inverse key]
    private String mntBy;           //  [mandatory]  [multiple]   [inverse key]
    private String mntLower;        //  [optional]   [multiple]   [inverse key]
    private String mntRoutes;       //  [optional]   [multiple]   [inverse key]
    private String mntIrt;          //  [mandatory]  [multiple]   [inverse key]
    private String lastModified;    //  [generated]  [single]     [ ]
    private String source;          //  [mandatory]  [single]     [ ]

    public String getInetnum() {
        return inetnum;
    }

    public void setInetnum(String inetnum) {
        this.inetnum = inetnum;
    }

    public String getNetname() {
        return netname;
    }

    public void setNetname(String netname) {
        this.netname = netname;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGeoloc() {
        return geoloc;
    }

    public void setGeoloc(String geoloc) {
        this.geoloc = geoloc;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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

    public String getMntRoutes() {
        return mntRoutes;
    }

    public void setMntRoutes(String mntRoutes) {
        this.mntRoutes = mntRoutes;
    }

    public String getMntIrt() {
        return mntIrt;
    }

    public void setMntIrt(String mntIrt) {
        this.mntIrt = mntIrt;
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

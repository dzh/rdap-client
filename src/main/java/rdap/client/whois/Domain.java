package rdap.client.whois;

/**
 * https://www.apnic.net/manage-ip/using-whois/guide/domain/
 * <p>
 * Contains details of in-addr.arpa (IPv4) and ip6.arpa (IPv6) Reverse DNS Delegations.
 * <p>
 * Example
 * domain:       1.168.192.in-addr.arpa
 * descr:        reverse domain object for 192.168.1.0/24
 * country:      AP
 * admin-c:      DE345-AP
 * tech-c:       DE345-AP
 * zone-c:       DE345-AP
 * nserver:      ns1.example.com
 * nserver:      ns2.example.com
 * mnt-by:       MAINT-EXAMPLENET-AP
 * mnt-lower:    MAINT-EXAMPLENET-AP
 * last-modified:2018-08-30T07:50:19Z
 * source:       APNIC
 *
 * @author dzh
 * @date 2019-03-05 20:54
 */
public class Domain {

    private String domain;          //  [mandatory]  [single]     [primary/lookup key]
    private String descr;           //  [mandatory]  [multiple]   [ ]
    private String country;         //  [optional]   [single]     [ ]
    private String adminC;          //  [mandatory]  [multiple]   [inverse key]
    private String techC;           //  [mandatory]  [multiple]   [inverse key]
    private String zoneC;           //  [mandatory]  [multiple]   [inverse key]
    private String nserver;         //  [optional]   [multiple]   [inverse key]
    private String subDom;          //  [optional]   [multiple]   [inverse key]
    private String domNet;          //  [optional]   [multiple]   [ ]
    private String remarks;         //  [optional]   [multiple]   [ ]
    private String notify;          //  [optional]   [multiple]   [inverse key]
    private String mntBy;           //  [mandatory]  [multiple]   [inverse key]
    private String mntLower;        //  [optional]   [multiple]   [inverse key]
    private String refer;           //  [optional]   [single]     [ ]
    private String lastModified;    //  [generated]  [single]     [ ]
    private String source;          //  [mandatory]  [single]     [ ]

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
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

    public String getZoneC() {
        return zoneC;
    }

    public void setZoneC(String zoneC) {
        this.zoneC = zoneC;
    }

    public String getNserver() {
        return nserver;
    }

    public void setNserver(String nserver) {
        this.nserver = nserver;
    }

    public String getSubDom() {
        return subDom;
    }

    public void setSubDom(String subDom) {
        this.subDom = subDom;
    }

    public String getDomNet() {
        return domNet;
    }

    public void setDomNet(String domNet) {
        this.domNet = domNet;
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

    public String getRefer() {
        return refer;
    }

    public void setRefer(String refer) {
        this.refer = refer;
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

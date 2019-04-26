package rdap.client.whois;

/**
 * https://www.apnic.net/manage-ip/using-whois/guide/route6/
 * <p>
 * Represents a single IPv6 route injected into the Internet routing mesh.
 * <p>
 * Example
 * route6:        2001:0DB8::/32
 * descr:         route object for 2001:0DB8::/32
 * origin:        AS1234
 * mnt-lower:     MAINT-EXAMPLENET-AP
 * mnt-routes:    MAINT-EXAMPLENET-AP
 * mnt-by:        MAINT-EXAMPLENET-AP
 * last-modified: 2018-08-30T07:50:19Z
 * source:        APNIC
 *
 * @author dzh
 * @date 2019-03-06 20:04
 */
public class Route6 {

    private String route6;          //  [mandatory]  [single]     [primary/look-up key]
    private String descr;           //  [mandatory]  [multiple]   [ ]
    private String origin;          //  [mandatory]  [single]     [primary/inverse key]
    private String holes;           //  [optional]   [multiple]   [ ]
    private String org;             //  [optional]   [multiple]   [inverse key]
    private String memberOf;        //  [optional]   [multiple]   [ ]
    private String inject;          //  [optional]   [multiple]   [ ]
    private String aggrMtd;         //  [optional]   [single]     [ ]
    private String aggrBndry;       //  [optional]   [single]     [ ]
    private String exportComps;     //  [optional]   [single]     [ ]
    private String components;      //  [optional]   [single]     [ ]
    private String remarks;         //  [optional]   [multiple]   [ ]
    private String notify;          //  [optional]   [multiple]   [inverse key]
    private String mntLower;        //  [optional]   [multiple]   [inverse key]
    private String mntRoutes;       //  [optional]   [multiple]   [inverse key]
    private String mntBy;           //  [mandatory]  [multiple]   [inverse key]
    private String lastModified;    //  [generated]  [single]     [ ]
    private String source;          //  [mandatory]  [single]     [ ]

    public String getRoute6() {
        return route6;
    }

    public void setRoute6(String route6) {
        this.route6 = route6;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getHoles() {
        return holes;
    }

    public void setHoles(String holes) {
        this.holes = holes;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getMemberOf() {
        return memberOf;
    }

    public void setMemberOf(String memberOf) {
        this.memberOf = memberOf;
    }

    public String getInject() {
        return inject;
    }

    public void setInject(String inject) {
        this.inject = inject;
    }

    public String getAggrMtd() {
        return aggrMtd;
    }

    public void setAggrMtd(String aggrMtd) {
        this.aggrMtd = aggrMtd;
    }

    public String getAggrBndry() {
        return aggrBndry;
    }

    public void setAggrBndry(String aggrBndry) {
        this.aggrBndry = aggrBndry;
    }

    public String getExportComps() {
        return exportComps;
    }

    public void setExportComps(String exportComps) {
        this.exportComps = exportComps;
    }

    public String getComponents() {
        return components;
    }

    public void setComponents(String components) {
        this.components = components;
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

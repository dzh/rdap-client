package rdap.client.whois;

/**
 * https://www.apnic.net/manage-ip/using-whois/guide/route/
 * <p>
 * Represents a single IPv4 route injected into the Internet routing mesh.
 * <p>
 * Example
 * route:          192.168.1.0/24
 * descr:          route object for 192.168.1.0/24
 * country:        AU
 * origin:         AS1234
 * mnt-lower:      MAINT-EXAMPLENET-AP
 * mnt-routes:     MAINT-EXAMPLENET-AP
 * mnt-by:         MAINT-EXAMPLENET-AP
 * last-modified:  2018-08-30T07:50:19Z
 * source:         APNIC
 *
 * @author dzh
 * @date 2019-03-06 19:57
 */
public class Route {

    private String route;           //  [mandatory]  [single]     [primary/lookup key]
    private String descr;           //  [mandatory]  [multiple]   [ ]
    private String country;         //  [optional]   [single]     [ ]
    private String origin;          //  [mandatory]  [single]     [primary/inverse key]
    private String holes;           //  [optional]   [multiple]   [ ]
    private String memberOf;        //  [optional]   [multiple]   [inverse key]
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

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
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

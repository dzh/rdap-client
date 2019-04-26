package rdap.client.whois;

/**
 * https://www.apnic.net/manage-ip/using-whois/guide/filter-set/
 * <p>
 * Defines the policy filter to be applied to a set of routes.
 *
 * @author dzh
 * @date 2019-03-05 21:03
 */
public class FilterSet {

    private String filterSet;       //  [mandatory]  [single]     [primary/lookup key]
    private String descr;           //  [mandatory]  [multiple]   [ ]
    private String filter;          //  [optional]   [single]     [ ]
    private String mpFilter;        //  [optional]   [single]     [ ]
    private String remarks;         //  [optional]   [multiple]   [ ]
    private String techC;           //  [mandatory]  [multiple]   [inverse key]
    private String adminC;          //  [mandatory]  [multiple]   [inverse key]
    private String notify;          //  [optional]   [multiple]   [inverse key]
    private String mntBy;           //  [mandatory]  [multiple]   [inverse key]
    private String mntLower;        //  [optional]   [multiple]   [inverse key]
    private String lastModified;    //  [generated]  [single]     [ ]
    private String source;          //  [mandatory]  [single]     []

    public String getFilterSet() {
        return filterSet;
    }

    public void setFilterSet(String filterSet) {
        this.filterSet = filterSet;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getMpFilter() {
        return mpFilter;
    }

    public void setMpFilter(String mpFilter) {
        this.mpFilter = mpFilter;
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

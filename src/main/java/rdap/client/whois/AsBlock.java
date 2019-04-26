package rdap.client.whois;

/**
 * https://www.apnic.net/manage-ip/using-whois/guide/as-block/
 * <p>
 * Shows the range of AS numbers delegated to Regional and National Internet Registries (NIRs).
 * Used to stop unauthorized creation of ‘aut-num‘ objects.
 *
 * @author dzh
 * @date 2019-03-05 19:52
 */
public class AsBlock {

    private String asBlock;     //  [mandatory]  [single]     [primary/lookup key]
    private String descr;       //  [optional]   [multiple]   [ ]
    private String country;     //  [optional]   [single]     [ ]
    private String remarks;     //  [optional]   [multiple]   [ ]
    private String techC;       //  [mandatory]  [multiple]   [inverse key]
    private String adminC;      //  [mandatory]  [multiple]   [inverse key]
    private String notify;      //  [optional]   [multiple]   [inverse key]
    private String mntLower;    //  [optional]   [multiple]   [inverse key]
    private String mntBy;       //  [mandatory]  [multiple]   [inverse key]
    private String lastModified;//  [generated]  [single]     [ ]                   // 2018-08-30T07:50:19Z
    private String source;      //  [mandatory]  [single]     [ ]

    public String getAsBlock() {
        return asBlock;
    }

    public void setAsBlock(String asBlock) {
        this.asBlock = asBlock;
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

    public String getMntLower() {
        return mntLower;
    }

    public void setMntLower(String mntLower) {
        this.mntLower = mntLower;
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

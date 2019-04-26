package rdap.client.whois;

/**
 * https://www.apnic.net/manage-ip/using-whois/guide/aut-num/
 * <p>
 * Contains details of the registered holder of an Autonomous System number (AS number) and their routing policy for that AS.
 * <p>
 * aut-num:        AS64496
 * as-name:        AS-EXAMPLENET
 * descr:          ASN for Example Net Pty Ltd
 * country:        AU
 * org:            ORG-EXAMPLENET-AP
 * import:         AS64500
 * export:         AS64494
 * admin-c:        DE345-AP
 * tech-c:         DE345-AP
 * notify:         noc@example.com
 * mnt-lower:      MAINT-EXAMPLENET-AP
 * mnt-routes:     MAINT-EXAMPLENET-AP
 * mnt-by:         MAINT-EXAMPLENET-AP
 * mnt-irt:        IRT-EXAMPLENET-AP
 * last-modified:  2018-08-30T07:50:19Z
 * source:         APNIC
 * <p>
 * role:           D EXAMPLENETADMIN
 * address:        123 Example st.
 * address:        20097 Exampletown
 * country:        AU
 * phone:          +12 34 567890 000
 * fax-no:         +12 34 567890 010
 * e-mail:         noc@examplenet.com
 * admin-c:        ABC123-AP
 * tech-c:         ABC123-AP
 * nic-hdl:        DE345-AP
 * remarks:        http://www.examplenet.com.au
 * notify:         hostmaster@examplenet.com.au
 * mnt-by:         MAINT-EXAMPLENET-AP
 * last-modified:  2018-08-30T07:50:19Z
 * source:         APNIC
 *
 * @author dzh
 * @date 2019-03-05 20:27
 */
public class AutNum {

    private String autNum;      //  [mandatory]     [single]     [primary/look-up key]
    private String asName;      //  [mandatory]  	[single]     [ ]
    private String descr;       //  [mandatory]  	[multiple]   [ ]
    private String country;     //  [mandatory]  	[single]     [ ]
    private String memberOf;    //  [optional]   	[multiple]   [inverse key]
    private String importVia;   //  [optional]   	[multiple]   [ ]
    //import: from <peering-1> [action <action-1>] accept <filter>  // http://www.ietf.org/rfc/rfc2622.txt
    private String import_;     //  [optional]   	[multiple]   [ ]  //'_' added to avoid Java keyword
    private String mpImport;    //  [optional]   	[multiple]   [ ]
    private String exportVia;   //  [optional]   	[multiple]   [ ]
    private String export;      //  [optional]   	[multiple]   [ ]
    private String mpExport;    //  [optional]   	[multiple]   [ ]
    private String default_;    //  [optional]   	[multiple]   [ ]
    private String mpDefault;   //  [optional]   	[multiple]   [ ]
    private String remarks;     //  [optional]   	[multiple]   [ ]
    private String org;         //  [mandatory]  	[single]     [inverse key]
    private String adminC;      //  [mandatory]  	[multiple]   [inverse key]
    private String techC;       //  [mandatory]  	[multiple]   [inverse key]
    private String notify;      //  [optional]   	[multiple]   [inverse key]
    private String mntLower;    //  [optional]   	[multiple]   [inverse key]
    private String mntRoutes;   //  [optional]   	[multiple]   [inverse key]
    private String mntBy;       //  [mandatory]  	[multiple]   [inverse key]
    private String mntIrt;      //  [mandatory]  	[multiple]   [inverse key]
    private String lastModified;//  [generated]  	[single]     [ ]
    private String source;      //  [mandatory]  	[single]     [ ]

    public String getAutNum() {
        return autNum;
    }

    public void setAutNum(String autNum) {
        this.autNum = autNum;
    }

    public String getAsName() {
        return asName;
    }

    public void setAsName(String asName) {
        this.asName = asName;
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

    public String getMemberOf() {
        return memberOf;
    }

    public void setMemberOf(String memberOf) {
        this.memberOf = memberOf;
    }

    public String getImportVia() {
        return importVia;
    }

    public void setImportVia(String importVia) {
        this.importVia = importVia;
    }

    public String getImport_() {
        return import_;
    }

    public void setImport_(String import_) {
        this.import_ = import_;
    }

    public String getMpImport() {
        return mpImport;
    }

    public void setMpImport(String mpImport) {
        this.mpImport = mpImport;
    }

    public String getExportVia() {
        return exportVia;
    }

    public void setExportVia(String exportVia) {
        this.exportVia = exportVia;
    }

    public String getExport() {
        return export;
    }

    public void setExport(String export) {
        this.export = export;
    }

    public String getMpExport() {
        return mpExport;
    }

    public void setMpExport(String mpExport) {
        this.mpExport = mpExport;
    }

    public String getDefault_() {
        return default_;
    }

    public void setDefault_(String default_) {
        this.default_ = default_;
    }

    public String getMpDefault() {
        return mpDefault;
    }

    public void setMpDefault(String mpDefault) {
        this.mpDefault = mpDefault;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
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

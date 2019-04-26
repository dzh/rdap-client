package rdap.client.whois;

/**
 * https://www.apnic.net/manage-ip/using-whois/guide/organization/
 * <p>
 * Contains only business information about an organization.
 * <p>
 * Example
 * organization:     ORG-APNIC1-AP
 * org-name:         Asia Pacific Network Information Centre
 * descr:            Regional Internet Registry for the Asia Pacific region
 * country:          AU
 * address:          6 Cordelia Street, South Brisbane, QLD 4101, Australia
 * phone:            +61 7 3858 3100
 * fax-no:           +61 7 3858 3199
 * e-mail:           helpdesk@apnic.net
 * mnt-ref:          APNIC-HM
 * notify:           helpdesk@apnic.net
 * mnt-by:           APNIC-HM
 * last-modified:    2018-08-30T07:50:19Z
 * source:           APNIC
 *
 * @author dzh
 * @date 2019-03-06 19:24
 */
public class Organization {

    private String organization;        //  [mandatory]  [single]     [primary/lookup key]
    private String orgName;             //  [mandatory]  [single]     [look-up key]
    private String descr;               //  [optional]   [multiple]   [ ]
    private String country;             //  [mandatory]  [single]     [ ]
    private String remarks;             //  [optional]   [multiple]   [ ]
    private String address;             //  [mandatory]  [multiple]   [ ]
    private String phone;               //  [optional]   [multiple]   [ ]
    private String faxNo;               //  [optional]   [multiple]   [ ]
    private String email;               //  [mandatory]  [multiple]   [look-up key]
    private String org;                 //  [optional]   [multiple]   [inverse key]
    private String adminC;              //  [optional]   [multiple]   [inverse key]
    private String techC;               //  [optional]   [multiple]   [inverse key]
    private String refNfy;              //  [optional]   [multiple]   [inverse key]
    private String mntRef;              //  [mandatory]  [multiple]   [inverse key]
    private String notify;              //  [optional]   [multiple]   [inverse key]
    private String mntBy;               //  [mandatory]  [multiple]   [inverse key]
    private String lastModified;        //  [generated]  [single]     [ ]
    private String source;              //  [mandatory]  [single]     [ ]

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFaxNo() {
        return faxNo;
    }

    public void setFaxNo(String faxNo) {
        this.faxNo = faxNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getRefNfy() {
        return refNfy;
    }

    public void setRefNfy(String refNfy) {
        this.refNfy = refNfy;
    }

    public String getMntRef() {
        return mntRef;
    }

    public void setMntRef(String mntRef) {
        this.mntRef = mntRef;
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

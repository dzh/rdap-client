package rdap.client.whois;

/**
 * https://www.apnic.net/manage-ip/using-whois/guide/mntner/
 * <p>
 * Contains details of the authorized agent able to make changes to APNIC Whois Database objects.
 * Also includes details of a process that verifies that the person making the changes is authorized to do so.
 * <p>
 * mntner:       MAINT-NZ-EXAMPLENET
 * descr:        maintainer for Example net Pty Ltd
 * country:      NZ
 * admin-c:      DE345-AP
 * tech-c:       DE345-AP
 * upd-to:       abc@examplenet.com
 * mnt-nfy:      abc@examplenet.com
 * auth:         PGPKEY-83F2A90E
 * notify:       manager@examplenet.com
 * mnt-by:       MAINT-EXAMPLENET-AP
 * referral-by:  APNIC-HM
 * last-modified:2018-08-30T07:50:19Z
 * source:       APNIC
 * <p>
 * role:         D EXAMPLENETADMIN
 * address:      123 Example st.
 * address:      20097 Exampletown
 * country:      AU
 * phone:        +12 34 567890 000
 * fax-no:       +12 34 567890 010
 * e-mail:       noc@examplenet.com
 * admin-c:      ABC123-AP
 * tech-c:       ABC123-AP
 * nic-hdl:      DE345-AP
 * remarks:      http://www.examplenet.com.au
 * notify:       hostmaster@examplenet.com.au
 * mnt-by:       MAINT-EXAMPLENET-AP
 * last-modified:2018-08-30T07:50:19Z
 * source:       APNIC
 *
 * @author dzh
 * @date 2019-03-06 19:18
 */
public class Mntner {

    private String mntner;          //  [mandatory]  [single]     [primary/lookup key]
    private String descr;           //  [mandatory]  [multiple]   [ ]
    private String country;         //  [optional]   [single]     [ ]
    private String adminC;          //  [mandatory]  [multiple]   [inverse key]
    private String techC;           //  [optional]   [multiple]   [inverse key]
    private String updTo;           //  [mandatory]  [multiple]   [inverse key]
    private String mntNfy;          //  [optional]   [multiple]   [inverse key]
    private String auth;            //  [mandatory]  [multiple]   [inverse key]
    private String remarks;         //  [optional]   [multiple]   [ ]
    private String notify;          //  [optional]   [multiple]   [inverse key]
    private String abuseMailbox;    //  [optional]   [multiple]   [inverse key]
    private String mntBy;           //  [mandatory]  [multiple]   [inverse key]
    private String referralBy;      //  [mandatory]  [single]     [inverse key]
    private String lastModified;    //  [generated]  [single]     [ ]
    private String source;          //  [mandatory]  [single]     [ ]

    public String getMntner() {
        return mntner;
    }

    public void setMntner(String mntner) {
        this.mntner = mntner;
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

    public String getUpdTo() {
        return updTo;
    }

    public void setUpdTo(String updTo) {
        this.updTo = updTo;
    }

    public String getMntNfy() {
        return mntNfy;
    }

    public void setMntNfy(String mntNfy) {
        this.mntNfy = mntNfy;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
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

    public String getAbuseMailbox() {
        return abuseMailbox;
    }

    public void setAbuseMailbox(String abuseMailbox) {
        this.abuseMailbox = abuseMailbox;
    }

    public String getMntBy() {
        return mntBy;
    }

    public void setMntBy(String mntBy) {
        this.mntBy = mntBy;
    }

    public String getReferralBy() {
        return referralBy;
    }

    public void setReferralBy(String referralBy) {
        this.referralBy = referralBy;
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

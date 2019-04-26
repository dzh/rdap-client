package rdap.client.whois;

/**
 * https://www.apnic.net/manage-ip/using-whois/guide/irt/
 * <p>
 * The irt object is used to provide information about a Computer Security Incident Response Team (CSIRT).
 * IRTs or CSIRTs specifically respond to computer security incident reports and activity.
 * They are dedicated abuse handling teams, (as distinct from network operational departments)
 * which review and respond to abuse reports.
 * <p>
 * Example
 * inetnum:        192.168.1.0 - 192.168.1.255
 * netname:        EXAMPLENET-AP
 * descr:          Example net Pty Ltd
 * country:        AP
 * admin-c:        DE345-AP
 * tech-c:         DE345-AP
 * status:         ASSIGNED PORTABLE
 * mnt-by:         MAINT-EXAMPLENET-AP
 * mnt-irt:        IRT-EXAMPLENET-AP
 * last-modified:  2018-08-30T07:50:19Z
 * source:         APNIC
 * <p>
 * irt:            IRT-EXAMPLENET-AP
 * address:        123 Example st.
 * address:        20097 Exampletown
 * address:        Australia
 * phone:          +12 34 567890 000
 * fax-no:         +12 34 567890 010
 * abuse-mailbox:  abuse@examplenet.com
 * admin-c:        DE345-AP
 * tech-c:         DE345-AP
 * auth:           PGPKEY-80FFBF15
 * remarks:        emergency phone number +12 34 567890 333
 * remarks:        timezone GMT+10 (GMT+2 with DST)
 * remarks:        https://www.examplenet.com
 * remarks:        This is a TI accredited CSIRT/CERT
 * irt-nfy:        notify@examplenet.com
 * mnt-by:         MAINT-EXAMPLENET-AP
 * source:         APNIC
 *
 * @author dzh
 * @date 2019-03-06 19:03
 */
public class Irt {

    private String irt;         //  [mandatory]  [single]     [primary/lookup key]
    private String address;     //  [mandatory]  [multiple]   [ ]
    private String phone;       //  [optional]   [multiple]   [ ]
    private String faxNo;       //  [optional]   [multiple]   [ ]
    private String eMail;       //  [mandatory]  [multiple]   [lookup key]
    private String abuseMailbox;//  [mandatory]  [multiple]   [inverse key]
    private String signature;   //  [optional]   [multiple]   [ ]
    private String encryption;  //  [optional]   [multiple]   [ ]
    private String adminC;      //  [mandatory]  [multiple]   [inverse key]
    private String techC;       //  [mandatory]  [multiple]   [inverse key]
    private String auth;        //  [mandatory]  [multiple]   [inverse key]
    private String remarks;     //  [optional]   [multiple]   [ ]
    private String irtNfy;      //  [optional]   [multiple]   [inverse key]
    private String notify;      //  [optional]   [multiple]   [inverse key]
    private String mntBy;       //  [mandatory]  [multiple]   [inverse key]
    private String lastModified;//  [generated]  [single]     [ ]
    private String source;      //  [mandatory]  [single]     [ ]

    public String getIrt() {
        return irt;
    }

    public void setIrt(String irt) {
        this.irt = irt;
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

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getAbuseMailbox() {
        return abuseMailbox;
    }

    public void setAbuseMailbox(String abuseMailbox) {
        this.abuseMailbox = abuseMailbox;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getEncryption() {
        return encryption;
    }

    public void setEncryption(String encryption) {
        this.encryption = encryption;
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

    public String getIrtNfy() {
        return irtNfy;
    }

    public void setIrtNfy(String irtNfy) {
        this.irtNfy = irtNfy;
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

package rdap.client.whois;

/**
 * https://www.apnic.net/manage-ip/using-whois/guide/person/
 * <p>
 * Contains details of technical or administrative contact responsible for the object where it is referenced.
 * <p>
 * Example
 * person:         Albert Brooke Crichton
 * address:        123 Example st.
 * address:        20097 Exampletown
 * country:        AU
 * phone:          +12 34 567890 000
 * fax-no:         +12 34 567890 010
 * e-mail:         abc@examplenet.com
 * nic-hdl:        ABC123-AP
 * notify:         abc@examplenet.com
 * mnt-by:         MAINT-EXAMPLENET-AP
 * last-modified:  2018-08-30T07:50:19Z
 * source:         APNIC
 *
 * @author dzh
 * @date 2019-03-06 19:42
 */
public class Person {

    private String person;          //  [mandatory]  [single]     [lookup key]
    private String address;         //  [mandatory]  [multiple]   [ ]
    private String country;         //  [mandatory]  [single]     [ ]
    private String phone;           //  [mandatory]  [multiple]   [ ]
    private String faxNo;           //  [optional]   [multiple]   [ ]
    private String eMail;           //  [mandatory]  [multiple]   [lookup key]
    private String nicHdl;          //  [mandatory]  [single]     [primary/look-up key]
    private String remarks;         //  [optional]   [multiple]   [ ]
    private String notify;          //  [optional]   [multiple]   [inverse key]
    private String abuseMailbox;    //  [optional]   [multiple]   [inverse key]
    private String mntBy;           //  [mandatory]  [multiple]   [inverse key]
    private String lastModified;    //  [generated]  [single]     [ ]
    private String source;          //  [mandatory]  [single]     [ ]

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public String getNicHdl() {
        return nicHdl;
    }

    public void setNicHdl(String nicHdl) {
        this.nicHdl = nicHdl;
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

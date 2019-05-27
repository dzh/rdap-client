package rdap.client.data;

import rdap.client.util.JsonUtil;

import java.util.List;

/**
 * https://tools.ietf.org/html/rfc7095 jcard
 *
 * @author dzh
 * @date 2019-03-26 19:18
 */
public abstract class CommonData {

    private List<String> rdapConformance;

    private List<Link> links;

    private List<Notice> notices;

    /**
     *
     */
    private List<Remark> remarks;

    /**
     * https://tools.ietf.org/html/rfc5646
     * <p>
     * "lang" : "mn-Cyrl-MN"
     */
    private String lang;

    private List<Event> events;

    private List<String> status;

    /**
     * the fully qualified host name or IP address of the WHOIS [RFC3912] server
     */
    private String port43;

    private List<PublicId> publicIds;

    private String objectClassName; // e.g. entity

    private String handle;

    public List<String> getRdapConformance() {
        return rdapConformance;
    }

    public void setRdapConformance(List<String> rdapConformance) {
        this.rdapConformance = rdapConformance;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public List<Notice> getNotices() {
        return notices;
    }

    public void setNotices(List<Notice> notices) {
        this.notices = notices;
    }

    public List<Remark> getRemarks() {
        return remarks;
    }

    public void setRemarks(List<Remark> remarks) {
        this.remarks = remarks;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<String> getStatus() {
        return status;
    }

    public void setStatus(List<String> status) {
        this.status = status;
    }

    public String getPort43() {
        return port43;
    }

    public void setPort43(String port43) {
        this.port43 = port43;
    }

    public List<PublicId> getPublicIds() {
        return publicIds;
    }

    public void setPublicIds(List<PublicId> publicIds) {
        this.publicIds = publicIds;
    }

    public String getObjectClassName() {
        return objectClassName;
    }

    public void setObjectClassName(String objectClassName) {
        this.objectClassName = objectClassName;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    @Override
    public String toString() {
        return JsonUtil.GSON.toJson(this);
    }
}

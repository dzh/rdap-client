package rdap.client.data;

import java.util.List;

/**
 * @author dzh
 * @date 2019-03-28 13:37
 */
public class DsData {

    private Integer keyTag;
    private Integer algorithm;
    private String digest;
    private Integer digestType;
    private List<Event> events;
    private List<Link> links;


    public Integer getKeyTag() {
        return keyTag;
    }

    public void setKeyTag(Integer keyTag) {
        this.keyTag = keyTag;
    }

    public Integer getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(Integer algorithm) {
        this.algorithm = algorithm;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public Integer getDigestType() {
        return digestType;
    }

    public void setDigestType(Integer digestType) {
        this.digestType = digestType;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }
}

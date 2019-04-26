package rdap.client.data;

import java.util.List;

/**
 * @author dzh
 * @date 2019-03-28 13:43
 */
public class KeyData {

    private Integer flags;
    private Integer protocol;
    private String publicKey;
    private Integer algorithm;
    private List<Event> events;
    private List<Link> links;

    public Integer getFlags() {
        return flags;
    }

    public void setFlags(Integer flags) {
        this.flags = flags;
    }

    public Integer getProtocol() {
        return protocol;
    }

    public void setProtocol(Integer protocol) {
        this.protocol = protocol;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public Integer getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(Integer algorithm) {
        this.algorithm = algorithm;
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

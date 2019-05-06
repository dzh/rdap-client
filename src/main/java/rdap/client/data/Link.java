package rdap.client.data;

import java.util.List;

/**
 * The "href" JSON value MUST be specified.  All other JSON values are OPTIONAL.
 * <p>
 * {
 * "value" : "http://example.com/context_uri",
 * "rel" : "self",
 * "href" : "http://example.com/target_uri",
 * "hreflang" : [ "en", "ch" ],
 * "title" : "title",
 * "media" : "screen",
 * "type" : "application/json"
 * }
 * <p>
 * https://tools.ietf.org/html/rfc5988 Web Linking
 *
 * @author dzh
 * @date 2019-03-26 19:29
 */
public class Link {

    private String value;
    private String rel;
    private String href;  //must
    private List<String> hreflang; // [ "en" ]
    private String title;
    private String media;
    private String type;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public List<String> getHreflang() {
        return hreflang;
    }

    public void setHreflang(List<String> hreflang) {
        this.hreflang = hreflang;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

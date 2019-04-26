package rdap.client.data;

import java.util.List;

/**
 * @author dzh
 * @date 2019-03-26 19:35
 */
public class Notice {

    private String title;
    private List<String> description;
    private List<Link> links;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getDescription() {
        return description;
    }

    public void setDescription(List<String> description) {
        this.description = description;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }
}

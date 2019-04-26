package rdap.client.data;

import java.util.List;

/**
 * for /entities searches, the array is "entitySearchResults"
 *
 * @author dzh
 * @date 2019-03-29 10:26
 */
public class Entities extends CommonData {

    private List<Entity> entitySearchResults;

    public List<Entity> getEntitySearchResults() {
        return entitySearchResults;
    }

    public void setEntitySearchResults(List<Entity> entitySearchResults) {
        this.entitySearchResults = entitySearchResults;
    }
}

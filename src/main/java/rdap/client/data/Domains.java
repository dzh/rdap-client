package rdap.client.data;

import java.util.List;

/**
 * for /domains searches, the array is "domainSearchResults"
 *
 * @author dzh
 * @date 2019-03-29 10:23
 */
public class Domains extends CommonData {

    private List<Domain> domainSearchResults;

    public List<Domain> getDomainSearchResults() {
        return domainSearchResults;
    }

    public void setDomainSearchResults(List<Domain> domainSearchResults) {
        this.domainSearchResults = domainSearchResults;
    }
}

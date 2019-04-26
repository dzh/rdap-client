package rdap.client.data;

import java.util.List;

/**
 * for /nameservers searches, the array is "nameserverSearchResults"
 *
 * @author dzh
 * @date 2019-03-29 10:24
 */
public class Nameservers extends CommonData {

    private List<Nameserver> nameserverSearchResults;

    public List<Nameserver> getNameserverSearchResults() {
        return nameserverSearchResults;
    }

    public void setNameserverSearchResults(List<Nameserver> nameserverSearchResults) {
        this.nameserverSearchResults = nameserverSearchResults;
    }
}

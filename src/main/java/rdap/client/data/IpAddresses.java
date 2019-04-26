package rdap.client.data;

import java.util.List;

/**
 * @author dzh
 * @date 2019-03-28 11:01
 */
public class IpAddresses {

    private List<String> v4;
    private List<String> v6;

    public List<String> getV4() {
        return v4;
    }

    public void setV4(List<String> v4) {
        this.v4 = v4;
    }

    public List<String> getV6() {
        return v6;
    }

    public void setV6(List<String> v6) {
        this.v6 = v6;
    }
}

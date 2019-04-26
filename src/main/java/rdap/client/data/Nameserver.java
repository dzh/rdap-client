package rdap.client.data;

import java.util.List;

/**
 * The nameserver object class represents information regarding DNS
 * nameservers used in both forward and reverse DNS.
 *
 * <pre>
 *    The nameserver object class can contain the following members:
 *
 *    o  objectClassName -- the string "nameserver"
 *
 *    o  handle -- a string representing a registry unique identifier of
 *       the nameserver
 *
 *    o  ldhName -- a string containing the LDH name of the nameserver (see
 *       Section 3)
 *
 *    o  unicodeName -- a string containing a DNS Unicode name of the
 *       nameserver (see Section 3)
 *
 *    o  ipAddresses -- an object containing the following members:
 *
 *       *  v6 -- an array of strings containing IPv6 addresses of the
 *          nameserver
 *
 *       *  v4 -- an array of strings containing IPv4 addresses of the
 *          nameserver
 *
 *    o  entities -- an array of entity objects as defined by Section 5.1
 *
 *    o  status -- see Section 4.6
 *
 *    o  remarks -- see Section 4.3
 *
 *    o  links -- see Section 4.2
 *
 *    o  port43 -- see Section 4.7
 *
 *    o  events -- see Section 4.5
 * </pre>
 *
 * @author dzh
 * @date 2019-03-27 20:18
 */
public class Nameserver extends CommonData {

    private String ldhName; //"ldhName" : "ns1.example.com"

    private String unicodeName;

    private String ipAddresses;

    private List<Entity> entities;

    public List<Entity> getEntities() {
        return entities;
    }

    public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }

    public String getLdhName() {
        return ldhName;
    }

    public void setLdhName(String ldhName) {
        this.ldhName = ldhName;
    }

    public String getUnicodeName() {
        return unicodeName;
    }

    public void setUnicodeName(String unicodeName) {
        this.unicodeName = unicodeName;
    }

    public String getIpAddresses() {
        return ipAddresses;
    }

    public void setIpAddresses(String ipAddresses) {
        this.ipAddresses = ipAddresses;
    }
}

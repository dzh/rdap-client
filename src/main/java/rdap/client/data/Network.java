package rdap.client.data;

import java.util.List;

/**
 * <pre>
 *    The IP network object class can contain the following members:
 *
 *    o  objectClassName -- the string "ip network"
 *
 *    o  handle -- a string representing an RIR-unique identifier of the
 *       network registration
 *
 *    o  startAddress -- the starting IP address of the network, either
 *       IPv4 or IPv6
 *
 *    o  endAddress -- the ending IP address of the network, either IPv4 or
 *       IPv6
 *
 *    o  ipVersion -- a string signifying the IP protocol version of the
 *       network: "v4" signifies an IPv4 network, and "v6" signifies an
 *       IPv6 network
 *
 *    o  name -- an identifier assigned to the network registration by the
 *       registration holder
 *
 *    o  type -- a string containing an RIR-specific classification of the
 *       network
 *
 *    o  country -- a string containing the two-character country code of
 *       the network
 *
 *    o  parentHandle -- a string containing an RIR-unique identifier of
 *       the parent network of this network registration
 *
 *    o  status -- an array of strings indicating the state of the IP
 *       network
 *
 *    o  entities -- an array of entity objects as defined by Section 5.1
 *
 *    o  remarks -- see Section 4.3
 *
 *    o  links -- see Section 4.2
 *
 *    o  port43 -- see Section 4.7
 *
 *    o  events -- see Section 4.5
 *
 *
 * </pre>
 *
 * @author dzh
 * @date 2019-03-28 14:01
 */
public class Network extends CommonData {

    private String startAddress;
    private String endAddress;
    private String ipVersion; //v4 or v6
    private String name;
    /**
     * a string containing an RIR-specific classification of the
     * network
     */
    private String type;
    private String country;
    private String parentHandle;

    private List<Entity> entities;

    public List<Entity> getEntities() {
        return entities;
    }

    public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }

    public String getStartAddress() {
        return startAddress;
    }

    public void setStartAddress(String startAddress) {
        this.startAddress = startAddress;
    }

    public String getEndAddress() {
        return endAddress;
    }

    public void setEndAddress(String endAddress) {
        this.endAddress = endAddress;
    }

    public String getIpVersion() {
        return ipVersion;
    }

    public void setIpVersion(String ipVersion) {
        this.ipVersion = ipVersion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getParentHandle() {
        return parentHandle;
    }

    public void setParentHandle(String parentHandle) {
        this.parentHandle = parentHandle;
    }

}

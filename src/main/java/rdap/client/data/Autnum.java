package rdap.client.data;

import java.util.List;

/**
 * The Autonomous System number (autnum) object class models Autonomous
 * System number registrations found in RIRs and represents the expected
 * response to an "/autnum" query as defined by [RFC7482].
 *
 * <pre>
 *   The Autonomous System number object class can contain the following
 *    members:
 *
 *    o  objectClassName -- the string "autnum"
 *
 *    o  handle -- a string representing an RIR-unique identifier of the
 *       autnum registration
 *
 *    o  startAutnum -- a number representing the starting number [RFC5396]
 *       in the block of Autonomous System numbers
 *
 *    o  endAutnum -- a number representing the ending number [RFC5396] in
 *       the block of Autonomous System numbers
 *
 *    o  name -- an identifier assigned to the autnum registration by the
 *       registration holder
 *
 *    o  type -- a string containing an RIR-specific classification of the
 *       autnum
 *
 *    o  status -- an array of strings indicating the state of the autnum
 *
 *    o  country -- a string containing the name of the two-character
 *       country code of the autnum
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
 * </pre>
 *
 * @author dzh
 * @date 2019-03-27 20:02
 */
public class Autnum extends CommonData {

    private Integer startAutnum;
    private Integer endAutnum;
    private String name;
    private String type;
    private String country;
    private List<Entity> entities;

    public Integer getStartAutnum() {
        return startAutnum;
    }

    public void setStartAutnum(Integer startAutnum) {
        this.startAutnum = startAutnum;
    }

    public Integer getEndAutnum() {
        return endAutnum;
    }

    public void setEndAutnum(Integer endAutnum) {
        this.endAutnum = endAutnum;
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

    public List<Entity> getEntities() {
        return entities;
    }

    public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }
}

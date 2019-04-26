package rdap.client.data;

import java.util.List;

/**
 * The domain object class represents a DNS name and point of
 * delegation. For RIRs, these delegation points are in the reverse DNS
 * tree, whereas for DNRs, these delegation points are in the forward
 * DNS tree.
 *
 * <pre>
 *    The domain object class can contain the following members:
 *
 *    o  objectClassName -- the string "domain"
 *
 *    o  handle -- a string representing a registry unique identifier of
 *       the domain object instance
 *
 *    o  ldhName -- a string describing a domain name in LDH form as
 *       described in Section 3
 *
 *    o  unicodeName -- a string containing a domain name with U-labels as
 *       described in Section 3
 *
 *    o  variants -- an array of objects, each containing the following
 *       values:
 *
 *       *  relation -- an array of strings, with each string denoting the
 *          relationship between the variants and the containing domain
 *          object (see Section 10.2.5 for a list of suggested variant
 *          relations).
 *
 *       *  idnTable -- the name of the Internationalized Domain Name (IDN)
 *          table of codepoints, such as one listed with the IANA (see IDN
 *          tables [IANA_IDNTABLES]).
 *
 *       *  variantNames -- an array of objects, with each object
 *          containing an "ldhName" member and a "unicodeName" member (see
 *          Section 3).
 *
 *    o  nameservers -- an array of nameserver objects as defined by
 *       Section 5.2
 *
 *    o  secureDNS -- an object with the following members:
 *
 *       *  zoneSigned -- true if the zone has been signed, false
 *          otherwise.
 *
 *       *  delegationSigned -- boolean true if there are DS records in the
 *          parent, false otherwise.
 *
 *       *  maxSigLife -- an integer representing the signature lifetime in
 *          seconds to be used when creating the RRSIG DS record in the
 *          parent zone [RFC5910].
 *
 *       *  dsData -- an array of objects, each with the following members:
 *
 *          +  keyTag -- an integer as specified by the key tag field of a
 *             DNS DS record as specified by [RFC4034] in presentation
 *             format
 *
 *          +  algorithm -- an integer as specified by the algorithm field
 *             of a DNS DS record as described by RFC 4034 in presentation
 *             format
 *
 *          +  digest -- a string as specified by the digest field of a DNS
 *             DS record as specified by RFC 4034 in presentation format
 *
 *          +  digestType -- an integer as specified by the digest type
 *             field of a DNS DS record as specified by RFC 4034 in
 *             presentation format
 *        +  events -- see Section 4.5
 *
 *          +  links -- see Section 4.2
 *
 *       *  keyData -- an array of objects, each with the following
 *          members:
 *
 *          +  flags -- an integer representing the flags field value in
 *             the DNSKEY record [RFC4034] in presentation format
 *
 *          +  protocol -- an integer representation of the protocol field
 *             value of the DNSKEY record [RFC4034] in presentation format
 *
 *          +  publicKey -- a string representation of the public key in
 *             the DNSKEY record [RFC4034] in presentation format
 *
 *          +  algorithm -- an integer as specified by the algorithm field
 *             of a DNSKEY record as specified by [RFC4034] in presentation
 *             format
 *
 *          +  events -- see Section 4.5
 *
 *          +  links -- see Section 4.2
 *
 *    o  entities -- an array of entity objects as defined by Section 5.1
 *
 *    o  status -- see Section 4.6
 *
 *    o  publicIds -- see Section 4.8
 *
 *    o  remarks -- see Section 4.3
 *
 *    o  links -- see Section 4.2
 *
 *    o  port43 -- see Section 4.7
 *
 *    o  events -- see Section 4.5
 *
 *    o  network -- represents the IP network for which a reverse DNS
 *       domain is referenced.  See Section 5.4
 *
 *
 * </pre>
 *
 * @author dzh
 * @date 2019-03-27 20:18
 */
public class Domain extends CommonData {

    private String ldhName;
    private String unicodeName;
    private List<Variant> variants;
    private List<Nameserver> nameservers;
    private List<Entity> entities;
    private Network network;

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

    public List<Variant> getVariants() {
        return variants;
    }

    public void setVariants(List<Variant> variants) {
        this.variants = variants;
    }

    public List<Nameserver> getNameservers() {
        return nameservers;
    }

    public void setNameservers(List<Nameserver> nameservers) {
        this.nameservers = nameservers;
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }

    public Network getNetwork() {
        return network;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }
}

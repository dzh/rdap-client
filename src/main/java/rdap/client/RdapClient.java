package rdap.client;

import rdap.client.data.Error;
import rdap.client.data.*;

import java.io.IOException;
import java.net.URL;

/**
 * https://tools.ietf.org/html/rfc7480 HTTP Usage in the Registration Data Access Protocol
 * https://tools.ietf.org/html/rfc7482 Registration Data Access Protocol (RDAP) Query Format
 * https://tools.ietf.org/html/rfc7483 JSON Responses for the Registration Data Access Protocol
 * https://tools.ietf.org/html/rfc1466 Guidelines for Management of IP Address Space
 * https://tools.ietf.org/html/rfc2650 Using RPSL in Practice
 * https://tools.ietf.org/html/rfc2622 Routing Policy Specification Language (RPSL)
 * <p>
 * This specification registers the "application/rdap+json" media type.
 *
 * @author dzh
 * @date 2019-03-23 14:47
 */
public interface RdapClient {

    /**
     * 'ip': Used to identify IP networks and associated data referenced
     * using either an IPv4 or IPv6 address.
     * <p>
     * Syntax: ip/<IP address> or ip/<CIDR prefix>/<CIDR length>
     *
     * @param ip
     * @param prefix
     * @return
     */
    Network ip(String ip, Integer prefix) throws IOException;

    /**
     * 'entity': Used to identify an entity information query using a
     * string identifier.
     * <p>
     * Syntax: entity/<handle>
     * <p>
     * https://example.com/rdap/entity/XXXX
     *
     * @param handle
     * @return
     */
    Entity entity(String handle) throws IOException;

    /**
     * 'autnum': Used to identify Autonomous System number registrations
     * and associated data referenced using an asplain Autonomous System
     * number.
     * <p>
     * Syntax: autnum/<autonomous system number>
     *
     * @param asn
     * @return
     */
    Autnum autnum(long asn) throws IOException;

    /**
     * 'domain': Used to identify reverse DNS (RIR) or domain name (DNR)
     * information and associated data referenced using a fully qualified
     * domain name.
     * <p>
     * Syntax: domain/<domain name>
     * <p>
     * https://example.com/rdap/domain/2.0.192.in-addr.arpa
     * https://example.com/rdap/domain/blah.example.com
     * https://example.com/rdap/domain/xn--fo-5ja.example
     */
    Domain domain(String rDNS) throws IOException;

    /**
     * 'nameserver': Used to identify a nameserver information query
     * using a host name.
     * <p>
     * Syntax: nameserver/<nameserver name>
     * <p>
     * https://example.com/rdap/nameserver/ns1.example.com
     */
    Nameserver nameserver(String host) throws IOException;

    /**
     * Syntax: help
     * <p>
     * https://example.com/rdap/help
     */
    Help help() throws IOException;

    // TODO
    //Domains domains(String query);
    //Nameservers nameservers(String query);
    //Entityies entities(String query);

    /**
     * @param error response error
     * @param url   request url
     */
    void error(Error error, URL url);
}

package rdap.client.util;

import ezvcard.VCard;
import ezvcard.io.json.JCardReader;
import ezvcard.parameter.TelephoneType;
import ezvcard.property.Address;
import ezvcard.property.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rdap.client.ProxyRdapClient;
import rdap.client.RdapConst;
import rdap.client.data.Entity;
import rdap.client.data.Event;
import rdap.client.data.Link;
import rdap.client.data.Remark;
import rdap.client.whois.Role;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * @author dzh
 * @date 2019-03-27 20:36
 */
public class EntityUtil {

    static final Logger LOG = LoggerFactory.getLogger(EntityUtil.class);

    public static boolean isRegistrant(Entity e) {
        List<String> roles = e.getRoles();
        if (roles == null) return false;

        for (String role : roles) {
            if ("registrant".equalsIgnoreCase(role)) {
                return true;
            }
        }
        return false;
    }


    public static boolean isAdmin(Entity e) {
        List<String> roles = e.getRoles();
        if (roles == null) return false;

        for (String role : roles) {
            if ("administrative".equalsIgnoreCase(role)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isTech(Entity e) {
        List<String> roles = e.getRoles();
        if (roles == null) return false;

        for (String role : roles) {
            if ("technical".equalsIgnoreCase(role)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isAbuse(Entity e) {
        List<String> roles = e.getRoles();
        if (roles == null) return false;

        for (String role : roles) {
            if ("abuse".equalsIgnoreCase(role)) {
                return true;
            }
        }
        return false;
    }

    public static Date getLastChangedDate(Entity e) throws ParseException {
//        List<Event> events = e.getEvents();
//        if (events != null) {
//            for (Event event : events) {
//                if ("last changed".equals(event.getEventAction())) {
//                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
//                    sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
//                    return sdf.parse(event.getEventDate());
//                }
//            }
//        }
        String date = getLastChanged(e);
        if (date != null) {
            date = formatUTC(date);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
            return sdf.parse(date);
        }
        return null;
    }

    /**
     * @param e
     * @return 2017-01-28T08:32:29-05:00 or 2017-01-28T08:32:29Z
     */
    public static String getLastChanged(Entity e) {
        List<Event> events = e.getEvents();
        if (events != null) {
            for (Event event : events) {
                if ("last changed".equals(event.getEventAction())) {
                    return event.getEventDate();
                }
            }
        }
        return null;
    }

    public static String formatUTC(String date) {
        if (date == null) return null;

        if (date.length() > 20) {
            return date.substring(0, 19) + 'Z';
        }
        return date;
    }

    /**
     * jCard: The JSON Format for vCard https://tools.ietf.org/html/rfc7095
     * <p>
     * https://github.com/mangstadt/ez-vcard
     * https://github.com/mangstadt/ez-vcard/wiki/jCard
     *
     * @param en
     * @return
     */
    public static Role getRole(Entity en) throws IOException {
        Role role = new Role();
        role.setNicHdl(en.getHandle()); //handle
        role.setLastModified(EntityUtil.getLastChanged(en)); //events

        String[] remarks = compactRemarks(en.getRemarks());
        if (remarks != null && remarks.length > 0) {
            role.setRemarks(remarks[0]);
        }

        // vcardArray
        List<Object> vcardArray = en.getVcardArray();
        if (vcardArray == null) return null;
        try (JCardReader reader = new JCardReader(ProxyRdapClient.GSON.toJson(vcardArray))) {
            VCard vcard;
            while ((vcard = reader.readNext()) != null) {
                role.setRole(vcard.getFormattedName().getValue());//fn
//                role.setAbuseMailbox(); todo

                List<Address> addresses = vcard.getAddresses();
                if (addresses != null && addresses.size() > 0) {
                    Address adr = vcard.getAddresses().get(0);
                    role.setAddress(formatAddress(adr));
                }

                List<Email> emails = vcard.getEmails();
                if (emails != null && emails.size() > 0)
                    role.seteMail(emails.get(0).getValue());

                vcard.getTelephoneNumbers().forEach(tel -> {
                    for (TelephoneType type : tel.getTypes()) {
                        if (TelephoneType.VOICE.equals(type)) {
                            role.setPhone(tel.getText());
                        } else if (TelephoneType.FAX.equals(type)) {
                            role.setFaxNo(tel.getText());
                        }
                    }
                });
            }
        }

        //entities admin_c tech_c
        List<Entity> entities = en.getEntities();
        if (entities != null) { //todo https://rdap.apnic.net/ip/203.113.0.0
            for (Entity e : entities) {
                if (isAdmin(e)) {
                    role.setAdminC(e.getHandle());
                }
                if (isTech(e)) {
                    role.setTechC(e.getHandle());
                }
                if (isRegistrant(e)) {
                    role.setMntBy(e.getHandle());
                }
                if (isAbuse(e)) {
                    if (role.getMntBy() == null) { //todo
                        role.setMntBy(e.getHandle());
                    }
                }
            }
        }

        //links source
        String url = readRdapUrl(en.getLinks());
        if (null != url) {
            UrlParser urlParser = UrlParser.parse(new URL(url));
            String host = urlParser.getHost();
            role.setSource(UrlParser.readSouceFromHost(host));
            if (RdapConst.RDAP_REGISTRO_BR_HOST.equals(host)) {
                role.setCountry("BR");
            }
        }

        return role; // An Entity to A Role
    }

    private static String formatAddress(Address adr) {
        String label = adr.getLabel();
        if (null != label && !label.isEmpty()) {
            return label;
        }

        StringBuilder buf = new StringBuilder();
        String param = adr.getStreetAddress();
        if (param != null && !param.isEmpty()) {
            buf.append(param);
            buf.append(",");
        }
        param = adr.getLocality();
        if (param != null && !param.isEmpty()) {
            buf.append(param);
            buf.append(",");
        }
        param = adr.getRegion();
        if (param != null && !param.isEmpty()) {
            buf.append(param);
            buf.append(",");
        }
        param = adr.getCountry();
        if (param != null && !param.isEmpty()) {
            buf.append(param);
            buf.append(",");
        }
        param = adr.getPostalCode();
        if (param != null && !param.isEmpty()) {
            buf.append(param);
        }

        label = buf.toString();
        if (label.length() > 0 && label.charAt(label.length() - 1) == ',') {
            label = label.substring(0, label.length() - 1);
        }
        return label;
//        return String.join(",", adr.getStreetAddress(), adr.getLocality(), adr.getRegion(), adr.getCountry(), adr.getPostalCode());
    }

    public static String readEmailDomain(String email) {
        if (email == null) return null;

        int loc = email.indexOf("@");
        if (loc < 0) return null;

        return email.substring(loc + 1);
    }

    public static String readRdapUrl(List<Link> links) {
        if (links == null) return null;

        for (Link link : links) {
            if ("application/rdap+json".equals(link.getType())) {
                return link.getValue();
            }
        }
        return null;
    }


    /**
     * @param remarkList
     * @return [remarks, descr]
     */
    public static String[] compactRemarks(List<Remark> remarkList) {
        if (remarkList == null) return null;

        String remarks = "";
        String descr = "";
        for (Remark r : remarkList) {
            String title = r.getTitle();
            if (title == null) continue;
            switch (title) {
                case "remarks":
                    remarks += "\n" + String.join("\n", r.getDescription());
                    break;
                case "description":
                    descr += "\n" + String.join("\n", r.getDescription());
                    break;
            }
        }

        return new String[]{remarks, descr};
    }

}

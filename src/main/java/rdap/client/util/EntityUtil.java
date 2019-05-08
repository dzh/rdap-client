package rdap.client.util;

import ezvcard.VCard;
import ezvcard.io.json.JCardReader;
import ezvcard.parameter.TelephoneType;
import ezvcard.property.Address;
import ezvcard.property.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rdap.client.ProxyRdapClient;
import rdap.client.data.Entity;
import rdap.client.data.Event;
import rdap.client.data.Remark;
import rdap.client.whois.Role;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.TimeZone;

/**
 * @author dzh
 * @date 2019-03-27 20:36
 */
public class EntityUtil {

    static final Logger LOG = LoggerFactory.getLogger(EntityUtil.class);

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
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
            return sdf.parse(date);
        }
        return null;
    }

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
        List<Object> vcardArray = en.getVcardArray();
        if (vcardArray == null) return null;

        List<Role> roles = new LinkedList<>();
        try (JCardReader reader = new JCardReader(ProxyRdapClient.GSON.toJson(vcardArray))) {
            VCard vcard;
            while ((vcard = reader.readNext()) != null) {
                Role role = new Role();
                role.setNicHdl(en.getHandle());
                role.setLastModified(EntityUtil.getLastChanged(en));
                role.setRole(vcard.getFormattedName().getValue());//fn

                List<Address> addresses = vcard.getAddresses();
                if (addresses != null && addresses.size() > 0)
                    role.setAddress(vcard.getAddresses().get(0).getLabel());

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

                String[] remarks = compactRemarks(en.getRemarks());
                if (remarks.length > 0) {
                    role.setRemarks(remarks[0]);
                }
                //admin_c tech_c
                List<Entity> entities = en.getEntities();
                if (entities != null) {
                    for (Entity e : entities) {
                        if (isAdmin(e)) {
                            role.setAdminC(e.getHandle());
                        }
                        if (isTech(e)) {
                            role.setTechC(e.getHandle());
                        }
                    }
                }
                roles.add(role);
            }
        }

        if (roles.size() > 1) {
            LOG.error("too many roles {} {}", roles.size(), ProxyRdapClient.GSON.toJson(roles));
        }
        return roles.get(0); // An Entity to A Role
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

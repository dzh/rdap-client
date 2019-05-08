package rdap.client.util;

import ezvcard.VCard;
import ezvcard.io.json.JCardReader;
import ezvcard.parameter.TelephoneType;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author dzh
 * @date 2019-04-25 20:06
 */
public class TestEntityUtil {
    static Logger LOG = LoggerFactory.getLogger(TestEntityUtil.class);

    @Test
    public void vcardTest() {
        String a = "[\"vcard\",[[\"version\",{},\"text\",\"4.0\"],[\"fn\",{},\"text\",\"IRT-CNNIC-CN\"],[\"kind\",{},\"text\",\"group\"],[\"adr\",{\"label\":\"Beijing, China\"},\"text\",[\"\",\"\",\"\",\"\",\"\",\"\",\"\"]],[\"email\",{},\"text\",\"ipas@cnnic.cn\"],[\"email\",{\"pref\":\"1\"},\"text\",\"ipas@cnnic.cn\"]]] ";

        a = "[\"vcard\",[[\"version\",{},\"text\",\"4.0\"],[\"fn\",{},\"text\",\"APNIC Network Operations\"],[\"kind\",{},\"text\",\"individual\"],[\"adr\",{\"label\":\"6 Cordelia Street\\nSouth Brisbane\\nQLD 4101\"},\"text\",[\"\",\"\",\"\",\"\",\"\",\"\",\"\"]],[\"tel\",{\"type\":\"voice\"},\"text\",\"+61 7 3858 3100\"],[\"tel\",{\"type\":\"fax\"},\"text\",\"+61 7 3858 3199\"],[\"email\",{},\"text\",\"netops@apnic.net\"]]]";

//        List<Object> list = ProxyRdapClient.GSON.fromJson(a, List.class);
//        a = ProxyRdapClient.GSON.toJson(list);
        try (JCardReader reader = new JCardReader(a)) {
            VCard vcard;
            while ((vcard = reader.readNext()) != null) {
                LOG.info("version {}", vcard.getVersion().getVersion());
                LOG.info("kind {}", vcard.getKind().getValue());
                LOG.info("adr {}", vcard.getAddresses().get(0).getLabel().trim());
                LOG.info("email {}", vcard.getEmails().get(0).getValue());
                LOG.info("fn {}", vcard.getFormattedName().getValue());
                vcard.getTelephoneNumbers().forEach(tel -> {
                    for (TelephoneType type : tel.getTypes()) {
                        LOG.info("tel {} {}", type.getValue(), tel.getText());
                    }
                });
            }
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    @Test
    public void eventDateTest() throws ParseException {
        String eventDate = "2011-09-22T03:53:02Z";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date date = sdf.parse(eventDate);
        LOG.info("utc {}", date.getTime());

        sdf.setTimeZone(TimeZone.getDefault());
        LOG.info("utc+8 {}", sdf.format(date));

        String st = "2017-01-28T08:32:29-05:00";
        LOG.info("{}", EntityUtil.formatUTC(st));
        st = "2017-01-28T08:32:29Z";
        LOG.info("{}", EntityUtil.formatUTC(st));
    }

}

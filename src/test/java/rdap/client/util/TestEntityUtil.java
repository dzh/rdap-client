package rdap.client.util;

import com.google.gson.Gson;
import ezvcard.VCard;
import ezvcard.io.json.JCardReader;
import ezvcard.parameter.TelephoneType;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rdap.client.data.Entity;
import rdap.client.whois.Role;

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

    @Test
    public void getRoleTest() throws IOException {
        String entity = "{\n" +
                "   \"objectClassName\":\"entity\",\n" +
                "   \"handle\":\"CO-CSME1-LACNIC\",\n" +
                "   \"legalRepresentative\":\"Sr. SAMUEL VELASCO\",\n" +
                "   \"vcardArray\":[\n" +
                "      \"vcard\",\n" +
                "      [\n" +
                "         [\n" +
                "            \"version\",\n" +
                "            {\n" +
                "\n" +
                "            },\n" +
                "            \"text\",\n" +
                "            \"4.0\"\n" +
                "         ],\n" +
                "         [\n" +
                "            \"fn\",\n" +
                "            {\n" +
                "\n" +
                "            },\n" +
                "            \"text\",\n" +
                "            \"CONSORCIO SISTEM MECM\"\n" +
                "         ],\n" +
                "         [\n" +
                "            \"kind\",\n" +
                "            {\n" +
                "\n" +
                "            },\n" +
                "            \"text\",\n" +
                "            \"individual\"\n" +
                "         ],\n" +
                "         [\n" +
                "            \"adr\",\n" +
                "            {\n" +
                "\n" +
                "            },\n" +
                "            \"text\",\n" +
                "            [\n" +
                "               \"\",\n" +
                "               \"0\",\n" +
                "               \"KR 76 # 57 R 92 SUR 0\",\n" +
                "               \"Bogotá D.C.\\Bogotá D.C.\",\n" +
                "               \"1\",\n" +
                "               \"1\",\n" +
                "               \"CO\"\n" +
                "            ]\n" +
                "         ],\n" +
                "         [\n" +
                "            \"tel\",\n" +
                "            {\n" +
                "               \"type\":\"voice\"\n" +
                "            },\n" +
                "            \"text\",\n" +
                "            \"57  7565688/0\"\n" +
                "         ]\n" +
                "      ]\n" +
                "   ],\n" +
                "   \"roles\":[\n" +
                "      \"registrant\"\n" +
                "   ],\n" +
                "   \"networks\":[\n" +
                "      {\n" +
                "   \"objectClassName\":\"ip network\",\n" +
                "   \"handle\":\"190.27.168.56/30\",\n" +
                "   \"startAddress\":\"190.27.168.56\",\n" +
                "   \"endAddress\":\"190.27.168.59\",\n" +
                "   \"ipVersion\":\"v4\",\n" +
                "   \"type\":\"re-allocated\",\n" +
                "   \"events\":[\n" +
                "      {\n" +
                "         \"eventAction\":\"registration\",\n" +
                "         \"eventDate\":\"2019-02-15T19:58:07Z\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"eventAction\":\"last changed\",\n" +
                "         \"eventDate\":\"2019-02-15T19:58:07Z\"\n" +
                "      }\n" +
                "   ],\n" +
                "   \"links\":[\n" +
                "      {\n" +
                "         \"value\":\"https://rdap.lacnic.net/rdap/ip/190.27.168.56/30\",\n" +
                "         \"rel\":\"self\",\n" +
                "         \"type\":\"application/rdap+json\",\n" +
                "         \"href\":\"https://rdap.lacnic.net/rdap/ip/190.27.168.56/30\"\n" +
                "      }\n" +
                "   ]\n" +
                "}\n" +
                "   ],\n" +
                "   \"autnums\":[\n" +
                "      {}\n" +
                "   ],\n" +
                "   \"entities\":[\n" +
                "      {\n" +
                "   \"objectClassName\":\"entity\",\n" +
                "   \"handle\":\"CRE\",\n" +
                "   \"roles\":[\n" +
                "      \"administrative\", \"registrant\"\n" +
                "   ],\n" +
                "   \"links\":[\n" +
                "      {\n" +
                "         \"value\":\"https://rdap.lacnic.net/rdap/entity/CRE\",\n" +
                "         \"rel\":\"self\",\n" +
                "         \"type\":\"application/rdap+json\",\n" +
                "         \"href\":\"https://rdap.lacnic.net/rdap/entity/CRE\"\n" +
                "      }\n" +
                "   ]\n" +
                "}\n" +
                "   ],\n" +
                "   \"events\":[\n" +
                "      {\n" +
                "         \"eventAction\":\"registration\",\n" +
                "         \"eventDate\":\"2019-02-15T19:58:04Z\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"eventAction\":\"last changed\",\n" +
                "         \"eventDate\":\"2019-02-15T19:58:04Z\"\n" +
                "      }\n" +
                "   ],\n" +
                "   \"links\":[\n" +
                "      {\n" +
                "         \"value\":\"https://rdap.lacnic.net/rdap/entity/CO-CSME1-LACNIC\",\n" +
                "         \"rel\":\"self\",\n" +
                "         \"type\":\"application/rdap+json\",\n" +
                "         \"href\":\"https://rdap.lacnic.net/rdap/entity/CO-CSME1-LACNIC\"\n" +
                "      }\n" +
                "   ],\n" +
                "   \"rdapConformance\":[\n" +
                "      \"rdap_level_0\"\n" +
                "   ],\n" +
                "   \"notices\":[\n" +
                "      {\n" +
                "   \"title\":\"RDAP Cache\",\n" +
                "   \"description\":[\n" +
                "      \"This object is stored in a temporary cache.\",\n" +
                "      \"Rdap objects may take up to 4 hours to refresh.\"\n" +
                "   ]\n" +
                "},\n" +
                "{\n" +
                "   \"title\":\"Terms and Conditions\",\n" +
                "   \"description\":[\n" +
                "      \"Terms and Conditions.\"\n" +
                "   ],\n" +
                "   \"links\":[\n" +
                "      {\n" +
                "         \"value\":\"https://www.lacnic.net/rdap-terms-and-conditions\",\n" +
                "         \"href\":\"https://www.lacnic.net/rdap-terms-and-conditions\",\n" +
                "         \"type\":\"text/html\"\n" +
                "      }\n" +
                "   ]\n" +
                "},\n" +
                "{\n" +
                "   \"title\":\"Privacy policy\",\n" +
                "   \"description\":[\n" +
                "      \"Privacy policy.\"\n" +
                "   ],\n" +
                "   \"links\":[\n" +
                "      {\n" +
                "         \"value\":\"https://www.lacnic.net/privacy-policy\",\n" +
                "         \"href\":\"https://www.lacnic.net/privacy-policy\",\n" +
                "         \"type\":\"text/html\"\n" +
                "      }\n" +
                "   ]\n" +
                "}\n" +
                "   ],\n" +
                "   \"port43\":\"whois.lacnic.net\"\n" +
                "}";
        entity = entity.replaceAll("\\\\", " ");
        Gson gson = JsonUtil.GSON;
        Entity en = gson.fromJson(entity, Entity.class);
        Role role = EntityUtil.getRole(en);
        LOG.info("role {}", gson.toJson(role));

//        Entity en = JSON.parseObject(entity, Entity.class);
//        Role role = EntityUtil.getRole(en);
//        LOG.info("role {}", JSON.toJSONString(role));
    }

}

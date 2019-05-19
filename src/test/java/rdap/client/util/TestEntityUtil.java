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
                "            \"objectClassName\":\"entity\",\n" +
                "            \"handle\":\"47686555000100\",\n" +
                "            \"vcardArray\":[\n" +
                "                \"vcard\",\n" +
                "                [\n" +
                "                    [\n" +
                "                        \"version\",\n" +
                "                        {\n" +
                "\n" +
                "                        },\n" +
                "                        \"text\",\n" +
                "                        \"4.0\"\n" +
                "                    ],\n" +
                "                    [\n" +
                "                        \"kind\",\n" +
                "                        {\n" +
                "\n" +
                "                        },\n" +
                "                        \"text\",\n" +
                "                        \"org\"\n" +
                "                    ],\n" +
                "                    [\n" +
                "                        \"fn\",\n" +
                "                        {\n" +
                "\n" +
                "                        },\n" +
                "                        \"text\",\n" +
                "                        \"Momentum Empreendimentos Imobiliários Ltda.\"\n" +
                "                    ]\n" +
                "                ]\n" +
                "            ],\n" +
                "            \"roles\":[\n" +
                "                \"registrant\"\n" +
                "            ],\n" +
                "            \"publicIds\":[\n" +
                "                {\n" +
                "                    \"type\":\"cnpj\",\n" +
                "                    \"identifier\":\"47.686.555/0001-00\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"entities\":[\n" +
                "                {\n" +
                "                    \"objectClassName\":\"entity\",\n" +
                "                    \"handle\":\"FAD135\",\n" +
                "                    \"vcardArray\":[\n" +
                "                        \"vcard\",\n" +
                "                        [\n" +
                "                            [\n" +
                "                                \"version\",\n" +
                "                                {\n" +
                "\n" +
                "                                },\n" +
                "                                \"text\",\n" +
                "                                \"4.0\"\n" +
                "                            ],\n" +
                "                            [\n" +
                "                                \"kind\",\n" +
                "                                {\n" +
                "\n" +
                "                                },\n" +
                "                                \"text\",\n" +
                "                                \"individual\"\n" +
                "                            ],\n" +
                "                            [\n" +
                "                                \"fn\",\n" +
                "                                {\n" +
                "\n" +
                "                                },\n" +
                "                                \"text\",\n" +
                "                                \"Fabio Donizetti\"\n" +
                "                            ],\n" +
                "                            [\n" +
                "                                \"lang\",\n" +
                "                                {\n" +
                "\n" +
                "                                },\n" +
                "                                \"language-tag\",\n" +
                "                                \"pt\"\n" +
                "                            ]\n" +
                "                        ]\n" +
                "                    ],\n" +
                "                    \"roles\":[\n" +
                "                        \"administrative\"\n" +
                "                    ],\n" +
                "                    \"events\":[\n" +
                "                        {\n" +
                "                            \"eventAction\":\"registration\",\n" +
                "                            \"eventDate\":\"2002-08-27T12:00:00Z\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"eventAction\":\"last changed\",\n" +
                "                            \"eventDate\":\"2009-09-22T14:01:38Z\"\n" +
                "                        }\n" +
                "                    ],\n" +
                "                    \"links\":[\n" +
                "                        {\n" +
                "                            \"value\":\"https://rdap.registro.br/entity/FAD135\",\n" +
                "                            \"rel\":\"self\",\n" +
                "                            \"href\":\"https://rdap.registro.br/entity/FAD135\",\n" +
                "                            \"type\":\"application/rdap+json\"\n" +
                "                        }\n" +
                "                    ]\n" +
                "                }\n" +
                "            ],\n" +
                "            \"events\":[\n" +
                "                {\n" +
                "                    \"eventAction\":\"registration\",\n" +
                "                    \"eventDate\":\"1998-02-03T12:00:00Z\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"eventAction\":\"last changed\",\n" +
                "                    \"eventDate\":\"2007-10-16T17:01:59Z\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"links\":[\n" +
                "                {\n" +
                "                    \"value\":\"https://rdap.registro.br/entity/47686555000100\",\n" +
                "                    \"rel\":\"self\",\n" +
                "                    \"href\":\"https://rdap.registro.br/entity/47686555000100\",\n" +
                "                    \"type\":\"application/rdap+json\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"legalRepresentative\":\"Fabio Donizete de Mendonça\"\n" +
                "        }";
        Gson gson = new Gson();
        Entity en = gson.fromJson(entity, Entity.class);
        Role role = EntityUtil.getRole(en);
        LOG.info("role {}", gson.toJson(role));

    }

}

package rdap.client.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author dzh
 * @date 2019-05-10 15:50
 */
public class TestUrlParser {

    static Logger LOG = LoggerFactory.getLogger(TestUrlParser.class);

    static final Gson GSON = new GsonBuilder().create();

    @Test
    public void parseTest() throws MalformedURLException {
        String url = "https://rdap.lacnic.net/rdap/ip/24.232.53.4/11";
        LOG.info("{}", GSON.toJson(UrlParser.parse(new URL(url))));

        url = "http://rdap.lacnic.net/rdap/entity/ANSRA7";
        LOG.info("{}", GSON.toJson(UrlParser.parse(new URL(url))));

        url = "http://rdap.db.ripe.net/autnum/7";
        LOG.info("{}", GSON.toJson(UrlParser.parse(new URL(url))));

        url = "http://rdap.arin.net/registry/ip/23.247.128.0/17";
        LOG.info("{}", UrlParser.parse(new URL(url)).toString());
    }

}

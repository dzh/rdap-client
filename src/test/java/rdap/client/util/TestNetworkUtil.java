package rdap.client.util;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author dzh
 * @date 2019-05-06 16:22
 */
public class TestNetworkUtil {

    static Logger LOG = LoggerFactory.getLogger(TestNetworkUtil.class);

    @Test
    public void cleanAddressTest() {
        String ip = "194.206.161.47/32";
        LOG.info("{}", NetworkUtil.cleanAddress(ip));
    }

}

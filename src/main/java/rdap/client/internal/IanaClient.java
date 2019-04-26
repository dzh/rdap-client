package rdap.client.internal;

import rdap.client.ProxyRdapClient;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * 处理未分配的信息
 *
 * @author dzh
 * @date 2019-03-23 15:14
 */
@Deprecated
class IanaClient extends ProxyRdapClient {

    @Override
    protected URL host() throws MalformedURLException {
        return null;
    }

}

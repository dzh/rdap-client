package rdap.client;

import rdap.client.data.Error;

import java.net.URL;

/**
 * @author dzh
 * @date 2019-04-17 11:04
 */
public interface ErrorHandler {

    void handle(URL url, Error error);

}

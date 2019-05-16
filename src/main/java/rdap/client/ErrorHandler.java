package rdap.client;

import java.net.URL;

/**
 * @author dzh
 * @date 2019-04-17 11:04
 */
public interface ErrorHandler {

    /**
     * @param url   request url
     * @param code  response status code
     * @param error Error object or response string
     */
    void handle(URL url, int code, Object error);

}

package rdap.client;

import rdap.client.util.JsonUtil;

/**
 * @author dzh
 * @date 2019-05-29 13:21
 */
public interface DataHandler {

    <T> T decode(String data, Class<T> clazz);

    final class JsonDataHandler implements DataHandler {
        @Override
        public <T> T decode(String data, Class<T> clazz) {
            return JsonUtil.GSON.fromJson(data, clazz);
        }
    }

}

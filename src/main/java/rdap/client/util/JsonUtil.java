package rdap.client.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author dzh
 * @date 2019-05-27 16:50
 */
public class JsonUtil {

    static final Logger LOG = LoggerFactory.getLogger(JsonUtil.class);

    public static final Gson GSON = new GsonBuilder().setLenient().disableHtmlEscaping().create();

//    private static class EscapeStringDeserializer implements JsonDeserializer<Entity> {
//        @Override
//        public Entity deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
//            return null;
//        }
//    }


}

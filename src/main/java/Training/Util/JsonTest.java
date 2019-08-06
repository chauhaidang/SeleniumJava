package Training.Util;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class JsonTest {
    public static void main(String[] args) {
        String dataType = "[{ \"Event\": \"ODR\", \"Time\": \"11/22/1996 - 03/20/1997\", \"Status\": \"DEVELOPMENT\", \"dang\": { \"sub\": [ {\"child\":\"dangchild\"} ]}}]";
        JsonElement jsonE = jsonParser(dataType);
        String kq;
        kq = getValueByKey(jsonE, "child");
        System.out.println("KET QUA IS: " + kq);
    }

    public static String getValueByKey(JsonElement element, String key) {
        String kq = null;

        if (element.isJsonArray()) {
            for (JsonElement objElement : element.getAsJsonArray()) {
                kq = getValueByKey(objElement, key);
                if (kq != null) break;
            }
        } else if (element.isJsonObject()) {
            Set<Map.Entry<String, JsonElement>> members = element.getAsJsonObject().entrySet();
            for (Map.Entry<String, JsonElement> e : members) {
                if (!e.getKey().equalsIgnoreCase(key)) {
                    kq = getValueByKey(e.getValue(), key);
                } else {
                    kq = e.getValue().isJsonObject() || e.getValue().isJsonArray() ? e.getValue().toString() : e.getValue().getAsString();
                }
                if (kq != null) break;
            }
        }
        return kq;
    }

    public static JsonElement jsonParser(String dataType) {
        JsonParser parser = new JsonParser();
        return parser.parse(dataType);
    }
}

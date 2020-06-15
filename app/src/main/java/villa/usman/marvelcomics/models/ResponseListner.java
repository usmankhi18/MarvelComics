package villa.usman.marvelcomics.models;

import org.json.JSONObject;

public class ResponseListner {
    private static JSONObject object;
    public static JSONObject getObject() {
        return object;
    }

    public static void setObject(JSONObject object) {
        ResponseListner.object = object;
    }
}

package top.wzmyyj.utils.tools;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created on 2019/11/19.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
public final class LogUtil {

    private static final String TAG = LogUtil.class.getSimpleName();

    /**
     * no instances.
     */
    private LogUtil() {
        throw new UnsupportedOperationException(TAG + "you can't instantiate me.");
    }

    /**
     * for DEBUG.
     */
    public static boolean DEBUG = false;


    /**
     * Default Log TAG
     */
    private static final String DEFAULT_TAG = "FEL";

    /**
     * Log TAG
     */
    private static String LOG_TAG = DEFAULT_TAG;


    /**
     * @param tag tag.
     */
    public static void init(@NonNull String tag) {
        init(tag,true);
    }

    /**
     * @param tag tag.
     */
    public static void init(@NonNull String tag, boolean debug) {
        LOG_TAG = checkTag(tag);
        DEBUG = debug;
    }


    /**
     * verbose log.
     *
     * @param msg .
     */
    public static void v(@Nullable String msg) {
        v(LOG_TAG, msg);
    }

    /**
     * verbose log.
     *
     * @param tag .
     * @param msg .
     */
    public static void v(@NonNull String tag, @Nullable String msg) {
        if (DEBUG)
            Log.v(checkTag(tag), checkMsg(msg));
    }

    /**
     * debug log.
     *
     * @param msg .
     */
    public static void d(@Nullable String msg) {
        d(LOG_TAG, msg);
    }

    /**
     * debug log.
     *
     * @param tag .
     * @param msg .
     */
    public static void d(@NonNull String tag, @Nullable String msg) {
        if (DEBUG)
            Log.d(checkTag(tag), checkMsg(msg));
    }

    /**
     * info log.
     *
     * @param msg .
     */
    public static void i(@Nullable String msg) {
        i(LOG_TAG, msg);
    }

    /**
     * info log.
     *
     * @param tag .
     * @param msg .
     */
    public static void i(@NonNull String tag, @Nullable String msg) {
        if (DEBUG)
            Log.i(checkTag(tag), checkMsg(msg));
    }


    /**
     * warn log.
     *
     * @param msg .
     */
    public static void w(@Nullable String msg) {
        w(LOG_TAG, msg);
    }

    /**
     * warn log.
     *
     * @param tag .
     * @param msg .
     */
    public static void w(@NonNull String tag, @Nullable String msg) {
        if (DEBUG)
            Log.w(checkTag(tag), checkMsg(msg));
    }

    /**
     * error log.
     *
     * @param msg .
     */
    public static void e(@Nullable String msg) {
        e(LOG_TAG, msg);
    }

    /**
     * error log.
     *
     * @param tag .
     * @param msg .
     */
    public static void e(@NonNull String tag, @Nullable String msg) {
        if (DEBUG)
            Log.e(checkTag(tag), checkMsg(msg));
    }

    /**
     * json log.
     *
     * @param msg .
     */
    public static void j(@Nullable String msg) {
        d(LOG_TAG, msg);
    }

    /**
     * json log.
     *
     * @param tag  .
     * @param json .
     */
    public static void j(@NonNull String tag, @Nullable String json) {
        if (DEBUG)
            Log.d(checkTag(tag), json != null ? getPrettyJson(json) : "Log : json is null");
    }



    //--------------private method----------------//

    /**
     * check msg if empty
     *
     * @param msg .
     * @return not empty string
     */
    private static String checkMsg(@Nullable String msg) {
        if (msg == null) {
            return "Log : msg is null";
        } else if ("".equals(msg)) {
            return "Log : msg is empty string";
        }
        return msg;
    }

    /**
     * check tag if null
     *
     * @param tag .
     * @return not null string
     */
    private static String checkTag(@NonNull String tag) {
        return "".equals(tag) ? DEFAULT_TAG : tag;
    }

    /**
     * @param json .
     * @return json format .
     */
    private static String getPrettyJson(@NonNull String json) {
        try {
            String jsonStr = json.trim();
            if (jsonStr.startsWith("{")) {
                JSONObject jsonObject = new JSONObject(jsonStr);
                return jsonObject.toString(2);
            }
            if (jsonStr.startsWith("[")) {
                JSONArray jsonArray = new JSONArray(jsonStr);
                return jsonArray.toString(2);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "Invalid Json: " + json;
    }

}

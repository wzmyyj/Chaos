package top.wzmyyj.utils.tools;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created on 2019/11/19.
 * <p>
 * Println various levels Log.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
@SuppressWarnings("unused")
public final class LogUtil {

    private static final String TAG = LogUtil.class.getSimpleName();

    /**
     * No instances.
     */
    private LogUtil() {
        throw new UnsupportedOperationException(TAG + ": You can't instantiate me.");
    }

    /**
     * For DEBUG.
     */
    public static boolean DEBUG = false;

    /**
     * Default Log TAG.
     */
    private static final String DEFAULT_TAG = "WZM";

    /**
     * Log TAG.
     */
    private static String LOG_TAG = DEFAULT_TAG;


    /**
     * @param tag TAG
     */
    public static void init(@NonNull String tag) {
        init(tag, true);
    }

    /**
     * Init Util.
     *
     * @param tag   TAG
     * @param debug isDebug
     */
    public static void init(@NonNull String tag, boolean debug) {
        LOG_TAG = checkTag(tag);
        DEBUG = debug;
    }

    /**
     * Println Verbose Log.
     *
     * @param msg MSG
     */
    public static void v(@Nullable String msg) {
        v(LOG_TAG, msg);
    }

    /**
     * Println Verbose Log.
     *
     * @param tag TAG
     * @param msg MSG
     */
    public static void v(@NonNull String tag, @Nullable String msg) {
        if (DEBUG)
            Log.v(checkTag(tag), checkMsg(msg));
    }

    /**
     * Println Debug Log.
     *
     * @param msg TAG
     */
    public static void d(@Nullable String msg) {
        d(LOG_TAG, msg);
    }

    /**
     * Println Debug Log.
     *
     * @param tag TAG
     * @param msg MSG
     */
    public static void d(@NonNull String tag, @Nullable String msg) {
        if (DEBUG)
            Log.d(checkTag(tag), checkMsg(msg));
    }

    /**
     * Println Info Log.
     *
     * @param msg MSG
     */
    public static void i(@Nullable String msg) {
        i(LOG_TAG, msg);
    }

    /**
     * Println Info Log.
     *
     * @param tag TAG
     * @param msg MSG
     */
    public static void i(@NonNull String tag, @Nullable String msg) {
        if (DEBUG)
            Log.i(checkTag(tag), checkMsg(msg));
    }

    /**
     * Println Warn Log.
     *
     * @param msg MSG
     */
    public static void w(@Nullable String msg) {
        w(LOG_TAG, msg);
    }

    /**
     * Println Warn Log.
     *
     * @param tag TAG
     * @param msg MSG
     */
    public static void w(@NonNull String tag, @Nullable String msg) {
        if (DEBUG)
            Log.w(checkTag(tag), checkMsg(msg));
    }

    /**
     * Println Error Log.
     *
     * @param msg MSG
     */
    public static void e(@Nullable String msg) {
        e(LOG_TAG, msg);
    }

    /**
     * Println Error Log.
     *
     * @param tag TAG
     * @param msg MSG
     */
    public static void e(@NonNull String tag, @Nullable String msg) {
        if (DEBUG)
            Log.e(checkTag(tag), checkMsg(msg));
    }

    /**
     * Println Json Log.
     *
     * @param msg MSG
     */
    public static void j(@Nullable String msg) {
        d(LOG_TAG, msg);
    }

    /**
     * Println Json Log.
     *
     * @param tag  TAG
     * @param json Json MSG
     */
    public static void j(@NonNull String tag, @Nullable String json) {
        if (DEBUG)
            Log.d(checkTag(tag), json != null ? getPrettyJson(json) : "Log : json is null.");
    }

    //--------------private method----------------//

    /**
     * Check msg if empty or null.
     *
     * @param msg MSG
     * @return not empty string
     */
    private static String checkMsg(@Nullable String msg) {
        if (msg == null) {
            return "Log : msg is null.";
        } else if ("".equals(msg)) {
            return "Log : msg is empty string.";
        }
        return msg;
    }

    /**
     * Check tag if empty.
     *
     * @param tag TAG
     * @return TAG or DEFAULT_TAG
     */
    private static String checkTag(@NonNull String tag) {
        return "".equals(tag) ? DEFAULT_TAG : tag;
    }

    /**
     * Format Json Log.
     *
     * @param json Json MSG
     * @return Json Log
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

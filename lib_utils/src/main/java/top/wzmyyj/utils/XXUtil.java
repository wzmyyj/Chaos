package top.wzmyyj.utils;

import android.util.Log;

import androidx.annotation.NonNull;

/**
 * Created on 2019/08/19.
 * Util class Template.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
public final class XXUtil {

    private static final String TAG = XXUtil.class.getSimpleName();

    /**
     * no instances.
     */
    private XXUtil() {
        throw new UnsupportedOperationException(TAG + "you can't instantiate me.");
    }

    /**
     * for DEBUG.
     * you can do: XXUtil.DEBUG=true; to DEBUG.
     */
    public static boolean DEBUG = false;


    /**
     * Desc method funXXX'show Function.
     *
     * @param var1 desc var1.
     * @param var2 desc var1.
     * @return object desc return value.
     */
    @NonNull
    public static Object funXX(@NonNull Object var1, @NonNull Object var2) {
        try {
            // to do something.
            return var1.toString() + var2.toString();
        } catch (Exception e) {
            if (DEBUG) {
                Log.d(TAG, "method funXXX has exception");
                e.printStackTrace();
            }
        }
        return new Object();
    }
}

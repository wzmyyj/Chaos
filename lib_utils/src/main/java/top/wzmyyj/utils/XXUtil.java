package top.wzmyyj.utils;

import android.util.Log;

import androidx.annotation.NonNull;

/**
 * Created on 2019/08/19.
 * Util class Template. This module is written in Java.
 * <p>
 * Desc Util class responsibility or function.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
@SuppressWarnings("unused")
public final class XXUtil {

    private static final String TAG = XXUtil.class.getSimpleName();

    /**
     * No instances.
     */
    private XXUtil() {
        throw new UnsupportedOperationException(TAG + "You can't instantiate me.");
    }

    /**
     * For DEBUG.
     * You can do like:
     *      XXUtil.DEBUG=true;
     * to debug.
     */
    public static boolean DEBUG = false;

    /**
     * Desc method funXX'show Function.
     *
     * @param var1 desc var1.
     * @param var2 desc var2.
     * @return object desc return value.
     */
    @NonNull
    public static Object funXX(@NonNull Object var1, @NonNull Object var2) {
        try {
            // to do something.
            return var1.toString() + var2.toString();
        } catch (Exception e) {
            if (DEBUG) {
                Log.d(TAG, "method funXX has exception!");
                e.printStackTrace();
            }
        }
        return funYY(var1, var2);
    }

    //--------------private method----------------//

    /**
     * Desc method funXX'show Function. (private method can no Desc)
     *
     * @param var1 desc var1.
     * @param var2 desc var2.
     * @return object desc return value.
     */
    @NonNull
    private static Object funYY(@NonNull Object var1, @NonNull Object var2) {
        try {
            // to do something.
            return var1.toString() + var2.toString();
        } catch (Exception e) {
            if (DEBUG) {
                Log.d(TAG, "method funYY has exception!");
                e.printStackTrace();
            }
        }
        return new Object();
    }

}

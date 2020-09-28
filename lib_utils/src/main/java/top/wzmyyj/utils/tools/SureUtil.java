package top.wzmyyj.utils.tools;

import android.os.Looper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Created on 2019/11/19.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
public final class SureUtil {

    private static final String TAG = SureUtil.class.getSimpleName();

    /**
     * no instances.
     */
    private SureUtil() {
        throw new UnsupportedOperationException(TAG + "you can't instantiate me.");
    }

    /**
     * for DEBUG.
     */
    public static boolean DEBUG = false;


    /**
     * @param is  is true.
     * @param msg .
     */
    public static void sure(boolean is, @NonNull String msg) {
        if (!is) {
            throw new RuntimeException(msg);
        }
    }

    /**
     * @param obj .
     * @param msg .
     */
    public static void notNull(@Nullable Object obj, @NonNull String msg) {
        sure(!isNull(obj), msg);
    }

    /**
     * @param str .
     * @param msg .
     */
    public static void strNotEmpty(@Nullable String str, @NonNull String msg) {
        sure(!isStrEmpty(str), msg);
    }


    /**
     * @param msg .
     */
    public static void mainThread(@NonNull String msg) {
        sure(isMainThread(), msg);
    }

    /**
     * @return thread is MainThread?
     */
    public static boolean isMainThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    /**
     * @param obj .
     * @return obj is null?
     */
    public static boolean isNull(@Nullable Object obj) {
        return obj == null;
    }

    /**
     * @param str .
     * @return str is empty?
     */
    public static boolean isStrEmpty(@Nullable String str) {
        return str == null || "".equals(str);
    }

}

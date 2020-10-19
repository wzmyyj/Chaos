package top.wzmyyj.utils.tools;

import android.os.Looper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Created on 2019/11/19.
 * <p>
 * Assertion.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
@SuppressWarnings("unused")
public final class SureUtil {

    private static final String TAG = SureUtil.class.getSimpleName();

    /**
     * No instances.
     */
    private SureUtil() {
        throw new UnsupportedOperationException(TAG + ": You can't instantiate me.");
    }

    /**
     * For DEBUG.
     */
    public static boolean DEBUG = false;

    /**
     * Sure condition is true.
     *
     * @param condition condition
     * @param msg       msg
     */
    public static void sure(boolean condition, @NonNull String msg) {
        if (!condition) {
            throw new RuntimeException(msg);
        }
    }

    /**
     * Sure obj is not null.
     *
     * @param obj any obj
     * @param msg msg
     */
    public static void notNull(@Nullable Object obj, @NonNull String msg) {
        sure(!isNull(obj), msg);
    }

    /**
     * Sure obj is not null or empty.
     *
     * @param str string
     * @param msg msg
     */
    public static void strNotEmpty(@Nullable String str, @NonNull String msg) {
        sure(!isStrEmpty(str), msg);
    }

    /**
     * Sure current thread is mainThread.
     *
     * @param msg msg
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
     * @param obj any obj
     * @return obj is null?
     */
    public static boolean isNull(@Nullable Object obj) {
        return obj == null;
    }

    /**
     * @param str string
     * @return str is empty?
     */
    public static boolean isStrEmpty(@Nullable String str) {
        return str == null || "".equals(str);
    }

}

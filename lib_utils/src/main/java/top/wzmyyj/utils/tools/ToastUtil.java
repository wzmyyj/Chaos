package top.wzmyyj.utils.tools;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Created on 2019/11/19.
 * <p>
 * Show Toast.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
@SuppressWarnings("unused")
public final class ToastUtil {

    private static final String TAG = ToastUtil.class.getSimpleName();

    /**
     * No instances.
     */
    private ToastUtil() {
        throw new UnsupportedOperationException(TAG + ": You can't instantiate me.");
    }

    /**
     * For DEBUG.
     */
    public static boolean DEBUG = false;

    private static Application app;

    public static void init(Application application) {
        app = application;
    }

    /**
     * Show short toast.
     *
     * @param msg msg
     */
    public static void show(@Nullable String msg) {
        show(app, msg);
    }

    /**
     * show short toast.
     *
     * @param context context
     * @param msg     msg
     */
    public static void show(@NonNull Context context, @Nullable String msg) {
        if (msg == null) return;
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * Show long toast.
     *
     * @param msg msg
     */
    public static void longShow(@Nullable String msg) {
        longShow(app, msg);
    }

    /**
     * Show long toast.
     *
     * @param context context
     * @param msg     msg
     */
    public static void longShow(@NonNull Context context, @Nullable String msg) {
        if (msg == null) return;
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }

    /**
     * Show debug toast,just for debug.
     *
     * @param msg msg
     */
    public static void debugShow(@Nullable String msg) {
        debugShow(app, msg);
    }

    /**
     * Show debug toast,just for debug.
     *
     * @param context context
     * @param msg     msg
     */
    public static void debugShow(@NonNull Context context, @Nullable String msg) {
        if (msg == null && !DEBUG) return;
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

}

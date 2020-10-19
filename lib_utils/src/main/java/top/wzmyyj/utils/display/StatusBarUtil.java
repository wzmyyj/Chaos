package top.wzmyyj.utils.display;

import android.app.Activity;
import android.content.res.Resources;
import android.view.WindowManager;

/**
 * Created on 2020/10/19.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
@SuppressWarnings("unused")
public class StatusBarUtil {

    private static final String TAG = StatusBarUtil.class.getSimpleName();

    /**
     * No instances.
     */
    private StatusBarUtil() {
        throw new UnsupportedOperationException(TAG + ": You can't instantiate me.");
    }

    /**
     * For DEBUG.
     */
    public static boolean DEBUG = false;

    /**
     * Get statusBar height.
     *
     * @return height
     */
    public int getStatusBarHeight() {
        int result = 0;
        int resId = Resources.getSystem().getIdentifier("status_bar_height", "dimen", "android");
        if (resId > 0) {
            result = Resources.getSystem().getDimensionPixelOffset(resId);
        }
        return result;
    }

    /**
     * Hide statusBar.
     *
     * @param context context
     */
    public static void hideStatusBar(Activity context) {
        context.getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    /**
     * Show statusBar.
     *
     * @param context context
     */
    public static void showStatusBar(Activity context) {
        context.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

}

package top.wzmyyj.utils.display;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;

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
    public static int getStatusBarHeight() {
        int result = 0;
        int resId = Resources.getSystem().getIdentifier("status_bar_height", "dimen", "android");
        if (resId > 0) {
            result = Resources.getSystem().getDimensionPixelOffset(resId);
        }
        return result;
    }

    /**
     * Set statusBar immersive or not.
     *
     * @param activity  activity
     * @param immersive is immersive?
     */
    public static void immersiveBar(@NonNull Activity activity, Boolean immersive) {
        Window window = activity.getWindow();
        int flag = window.getDecorView().getWindowSystemUiVisibility();
        if (immersive) {
            flag |= View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
        } else {
            flag |= View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
        }
        window.getDecorView().setSystemUiVisibility(flag);
    }

    /**
     * Set text white.
     *
     * @param activity activity
     */
    public static void whiteText(@NonNull Activity activity) {
        Window window = activity.getWindow();
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }

    /**
     * Set text black.
     *
     * @param activity activity
     */
    public static void blackText(@NonNull Activity activity) {
        Window window = activity.getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
    }

    /**
     * Set bg transparent.
     *
     * @param activity activity
     */
    public static void transparentBg(@NonNull Activity activity) {
        Window window = activity.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.TRANSPARENT);
    }

    /**
     * Hide statusBar.
     *
     * @param activity activity
     */
    public static void hideStatusBar(@NonNull Activity activity) {
        activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    /**
     * Show statusBar.
     *
     * @param activity activity
     */
    public static void showStatusBar(@NonNull Activity activity) {
        activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

}

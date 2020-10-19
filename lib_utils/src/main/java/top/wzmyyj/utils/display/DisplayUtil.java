package top.wzmyyj.utils.display;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
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
public class DisplayUtil {

    private static final String TAG = DisplayUtil.class.getSimpleName();

    /**
     * No instances.
     */
    private DisplayUtil() {
        throw new UnsupportedOperationException(TAG + ": You can't instantiate me.");
    }

    /**
     * For DEBUG.
     */
    public static boolean DEBUG = false;

    /**
     * Get screen width.
     *
     * @param context context
     * @return screen width
     */
    public static int getScreenWidth(@NonNull Context context) {
        Point point = new Point();
        Display display = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        display.getSize(point);
        Log.d(TAG,"getScreenWidth return " + point.x);
        return point.x;
    }

    /**
     * Get screen height.
     *
     * @param context context
     * @return screen height
     */
    public static int getScreenHeight(@NonNull Context context) {
        Point point = new Point();
        Display display = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        display.getSize(point);
        Log.d(TAG,"getScreenHeight return " + point.y);
        return point.y;
    }

    /**
     * Get metrics width.
     *
     * @param context context
     * @return metrics width
     */
    public int getMetricsWidth(Activity context) {
        DisplayMetrics dm = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }

    /**
     * Get metrics height.
     *
     * @param context context
     * @return metrics height
     */
    public int getMetricsHeight(Activity context) {
        DisplayMetrics dm = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.heightPixels;
    }

}

package top.wzmyyj.utils.app;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;

/**
 * Created on 2019/11/19.
 * <p>
 * Context Util.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
@SuppressWarnings("unused")
public final class ContextUtil {

    private static final String TAG = ContextUtil.class.getSimpleName();

    /**
     * No instances.
     */
    private ContextUtil() {
        throw new UnsupportedOperationException(TAG + "You can't instantiate me.");
    }

    /**
     * For DEBUG.
     */
    public static boolean DEBUG = false;

    /**
     * Get content from fragment.
     *
     * @param fragment fragment
     * @return content
     */
    @Nullable
    public static Context getContext(@NonNull Fragment fragment) {
        return fragment.getContext();
    }

    /**
     * Get content from lifecycleOwner.
     *
     * @param owner LifecycleOwner
     * @return context
     */
    @Nullable
    public static Context getContext(@NonNull LifecycleOwner owner) {
        if (owner instanceof Context) {
            return (Context) owner;
        } else if (owner instanceof Fragment) {
            return ((Fragment) owner).getContext();
        } else {
            return null;
        }
    }

    /**
     * Get activity from context.
     *
     * @param context context
     * @return activity
     */
    @Nullable
    public static Activity getActivity(@NonNull Context context) {
        return findActivity(context);
    }

    //--------------private method----------------//

    /**
     * Recursive lookup activity.
     *
     * @param context context
     * @return activity
     */
    @Nullable
    private static Activity findActivity(@Nullable Context context) {
        if (context == null) return null;
        if (context instanceof Activity) {
            return (Activity) context;
        } else if (context instanceof ContextWrapper) {
            Context baseContext = ((ContextWrapper) context).getBaseContext();
            return findActivity(baseContext);
        }
        return null;
    }

}

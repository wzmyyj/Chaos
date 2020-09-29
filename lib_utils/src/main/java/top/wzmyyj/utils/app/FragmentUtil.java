package top.wzmyyj.utils.app;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

/**
 * Created on 2019/09/30.
 * <p>
 * Fragment Util.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
@SuppressWarnings("unused")
public final class FragmentUtil {

    private static final String TAG = FragmentUtil.class.getSimpleName();

    /**
     * No instances.
     */
    private FragmentUtil() {
        throw new UnsupportedOperationException(TAG + "You can't instantiate me.");
    }

    /**
     * For DEBUG.
     */
    public static boolean DEBUG = false;

    /**
     * Add a fragment to a container.
     *
     * @param fragmentManager  fragmentManager
     * @param containerId      container view's Id
     * @param fragment         target
     * @param isAddToBackStack whether to add fragment to stack or not.
     * @param tag              TAG
     */
    public static void addFragment(
            @NonNull FragmentManager fragmentManager,
            @IdRes int containerId,
            @NonNull Fragment fragment,
            boolean isAddToBackStack,
            @Nullable String tag) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (isAddToBackStack) {
            transaction.addToBackStack(tag);
        }
        transaction.add(containerId, fragment, tag).commit();
    }

    /**
     * Replace an existing fragment that was added to a container.
     *
     * @param fragmentManager  fragmentManager
     * @param containerId      container view's Id
     * @param fragment         target
     * @param isAddToBackStack whether to add fragment to stack or not.
     * @param tag              TAG
     */
    public static void replaceFragment(
            @NonNull FragmentManager fragmentManager,
            @IdRes int containerId,
            @NonNull Fragment fragment,
            boolean isAddToBackStack,
            @Nullable String tag) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (isAddToBackStack) {
            transaction.addToBackStack(tag);
        }
        transaction.replace(containerId, fragment, tag).commit();
    }

}

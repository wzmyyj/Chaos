package top.wzmyyj.utils.app;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

/**
 * Created on 2019/09/30.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
public final class FragmentUtil {

    private static final String TAG = FragmentUtil.class.getSimpleName();

    /**
     * no instances.
     */
    private FragmentUtil() {
        throw new UnsupportedOperationException(TAG + "you can't instantiate me.");
    }

    /**
     * for DEBUG.
     */
    public static boolean DEBUG = false;


    /**
     * addFragment .
     *
     * @param fragmentManager  .
     * @param containerId      .
     * @param fragment         .
     * @param isAddToBackStack 将要替换的fragment是否要添加到返回栈
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
     * replaceFragment .
     *
     * @param fragmentManager  .
     * @param containerId      .
     * @param fragment         .
     * @param isAddToBackStack 将要替换的fragment是否要添加到返回栈
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

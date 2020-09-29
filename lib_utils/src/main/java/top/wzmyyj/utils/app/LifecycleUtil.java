package top.wzmyyj.utils.app;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2019/11/19.
 * <p>
 * Lifecycle Util.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
@SuppressWarnings("unused")
public final class LifecycleUtil {

    private static final String TAG = LifecycleUtil.class.getSimpleName();

    /**
     * No instances.
     */
    private LifecycleUtil() {
        throw new UnsupportedOperationException(TAG + "You can't instantiate me.");
    }

    /**
     * For DEBUG.
     */
    public static boolean DEBUG = false;

    /**
     * Find lifecycleOwner by view. (used in MainThread)
     * <p>
     * General find the most recent a {@link androidx.fragment.app.Fragment} or
     * {@link androidx.fragment.app.FragmentActivity}
     * <p>
     * If lifecycleOwner is a {@link androidx.fragment.app.Fragment}.
     * Judge whether fragment's view is null. return current fragment or
     * its viewLifecycleOwner.
     *
     * @param v view
     * @return lifecycleOwner
     */
    @MainThread
    @Nullable
    public static LifecycleOwner getOwnerByView(@NonNull View v) {
        Context context = v.getContext();
        Activity activity = findActivity(context);
        LifecycleOwner result = null;
        if (activity instanceof FragmentActivity) {
            FragmentActivity fragmentActivity = (FragmentActivity) activity;
            Fragment fragment = findSupportFragment(fragmentActivity, v);
            if (fragment == null) {
                result = fragmentActivity;
            } else {
                if (fragment.getView() == null) {
                    result = fragment;
                } else {
                    result = fragment.getViewLifecycleOwner();
                }
            }
        }
        return result;
    }

    //--------------private method----------------//

    // map deposit fragments.
    private static final Map<View, Fragment> tempViewToSupportFragment = new HashMap<>();

    /**
     * Find supportFragment with view in the fragment tree of fragmentActivity.
     *
     * @param activity fragmentActivity
     * @param target   view
     * @return fragment
     */
    @Nullable
    private static Fragment findSupportFragment(FragmentActivity activity, View target) {
        tempViewToSupportFragment.clear();
        findAllSupportFragmentsWithViews(
                activity.getSupportFragmentManager().getFragments(), tempViewToSupportFragment);
        View activityRoot = activity.findViewById(android.R.id.content);
        Fragment result = null;
        View current = target;
        while (!current.equals(activityRoot)) {
            result = tempViewToSupportFragment.get(current);
            if (result != null) {
                break;
            }
            if (current.getParent() instanceof View) {
                current = (View) current.getParent();
            } else {
                break;
            }
        }
        tempViewToSupportFragment.clear();
        return result;
    }

    /**
     * Find all supportFragments with views.
     *
     * @param topLevelFragments child fragments
     * @param result            map
     */
    private static void findAllSupportFragmentsWithViews(
            @Nullable Collection<Fragment> topLevelFragments,
            @NonNull Map<View, Fragment> result
    ) {
        if (topLevelFragments == null) return;
        for (Fragment fragment : topLevelFragments) {
            if (fragment == null || fragment.getView() == null) continue;
            result.put(fragment.getView(), fragment);
            findAllSupportFragmentsWithViews(fragment.getChildFragmentManager().getFragments(), result);
        }
    }

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

package top.wzmyyj.utils.app;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.util.ArrayMap;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;

import java.util.Collection;
import java.util.Map;

/**
 * Created on 2019/11/19.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
public final class LifecycleUtil {

    private static final String TAG = LifecycleUtil.class.getSimpleName();

    /**
     * no instances.
     */
    private LifecycleUtil() {
        throw new UnsupportedOperationException(TAG + "you can't instantiate me.");
    }

    /**
     * for DEBUG.
     */
    public static boolean DEBUG = false;


    /**
     * find lifecycleOwner by view.
     *
     * @param v view
     * @return lifecycleOwner
     */
    @Nullable
    public static LifecycleOwner getOwnerByView(@NonNull View v) {
        Context context = v.getContext();
        Activity activity = findActivity(context);
        LifecycleOwner result = null;
        if (activity instanceof FragmentActivity) {
            FragmentActivity fragmentActivity = (FragmentActivity) activity;
            result = findSupportFragment(fragmentActivity, v);
            if (result == null) {
                result = fragmentActivity;
            }
        }
        return result;
    }


    //--------------private method----------------//


    private static final ArrayMap<View, Fragment> tempViewToSupportFragment = new ArrayMap<>();


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

    private static void findAllSupportFragmentsWithViews(
            @Nullable Collection<Fragment> topLevelFragments,
            @NonNull Map<View, Fragment> result
    ) {
        if (topLevelFragments == null) {
            return;
        }
        for (Fragment fragment : topLevelFragments) {
            if (fragment == null || fragment.getView() == null) {
                continue;
            }
            result.put(fragment.getView(), fragment);
            findAllSupportFragmentsWithViews(fragment.getChildFragmentManager().getFragments(), result);
        }
    }

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

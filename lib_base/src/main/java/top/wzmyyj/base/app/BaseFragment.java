package top.wzmyyj.base.app;

import android.graphics.drawable.Drawable;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

/**
 * Created on 2019/09/29.
 * <p>
 * Base Fragment.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
public class BaseFragment extends Fragment {

    /**
     * Returns a drawable object associated with a particular resource ID.
     *
     * @param id drawableRes ID
     * @return drawable
     */
    @Nullable
    public Drawable getDrawable(@DrawableRes int id) {
        return ContextCompat.getDrawable(requireContext(), id);
    }

    /**
     * Returns a color associated with a particular resource ID.
     *
     * @param id colorRes ID
     * @return color
     */
    @ColorInt
    public int getColor(@ColorRes int id) {
        return ContextCompat.getColor(requireContext(), id);
    }

}

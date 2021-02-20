package top.wzmyyj.weight;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Created on 2018/12/28.
 * <p>
 * View that fit statusBar height.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
public class FitView extends View {

    public FitView(Context context) {
        super(context);
    }

    public FitView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FitView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int statusBarHeight = getStatusBarHeight();
        setMeasuredDimension(widthMeasureSpec, statusBarHeight);
    }

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
}

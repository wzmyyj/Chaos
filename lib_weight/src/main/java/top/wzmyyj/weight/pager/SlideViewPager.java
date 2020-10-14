package top.wzmyyj.weight.pager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import top.wzmyyj.weight.R;

/**
 * Created on 2018/12/28.
 * <p>
 * Viewpager that controls whether to slide.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
public class SlideViewPager extends ViewPager {

    public SlideViewPager(@NonNull Context context) {
        this(context, null);
    }

    public SlideViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        // get attributes.
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.SlideViewPager, 0, 0);
        isSlide = a.getBoolean(R.styleable.SlideViewPager_svp_isSlide, true);
        a.recycle();
    }

    /**
     * Controls whether to slide.
     */
    private boolean isSlide;

    /**
     * @return isSlide.
     */
    public boolean isSlide() {
        return isSlide;
    }

    /**
     * @param isSlide isSlide.
     */
    public void setSlide(boolean isSlide) {
        this.isSlide = isSlide;
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return isSlide && super.onTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return isSlide && super.onInterceptTouchEvent(ev);
    }

}

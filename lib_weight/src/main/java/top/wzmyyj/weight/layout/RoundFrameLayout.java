package top.wzmyyj.weight.layout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import androidx.annotation.ColorInt;

import top.wzmyyj.weight.R;

/**
 * Created on 2019/08/15.
 * <p>
 * Support the FrameLayout of any corner, fillet and outer border color.
 * Crop the inner child view.
 * <p>
 * Note: the content is cropped. Set the background for itself,
 * and the background will not have rounded corners.
 *
 * @author feling
 * @version 1.1.0
 * @since 1.0.0
 */
public class RoundFrameLayout extends FrameLayout {

    private final int radiusLeftTop;
    private final int radiusLeftBottom;
    private final int radiusRightTop;
    private final int radiusRightBottom;
    @ColorInt
    private int borderColor;
    private int borderWidth;

    private final Paint paint = new Paint();
    private final Path path = new Path();

    public RoundFrameLayout(Context context) {
        this(context, null);
    }

    public RoundFrameLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RoundFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        // get attributes.
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.RoundFrameLayout, defStyleAttr, 0);
        int radius = a.getDimensionPixelSize(R.styleable.RoundFrameLayout_rfl_radius, 0);
        radiusLeftTop = a.getDimensionPixelSize(R.styleable.RoundFrameLayout_rfl_leftTop_radius, radius);
        radiusLeftBottom = a.getDimensionPixelSize(R.styleable.RoundFrameLayout_rfl_leftBottom_radius, radius);
        radiusRightTop = a.getDimensionPixelSize(R.styleable.RoundFrameLayout_rfl_rightTop_radius, radius);
        radiusRightBottom = a.getDimensionPixelSize(R.styleable.RoundFrameLayout_rfl_rightBottom_radius, radius);
        borderWidth = a.getDimensionPixelSize(R.styleable.RoundFrameLayout_rfl_border_width, 0);
        borderColor = a.getColor(R.styleable.RoundFrameLayout_rfl_border_color, 0);
        a.recycle();
    }

    @ColorInt
    public int getBorderColor() {
        return borderColor;
    }

    public void setBorderColor( @ColorInt int borderColor) {
        if (borderColor == this.borderColor) {
            return;
        }
        this.borderColor = borderColor;
        invalidate();
    }

    public int getBorderWidth() {
        return borderWidth;
    }

    public void setBorderWidth(int borderWidth) {
        if (borderWidth == this.borderWidth) {
            return;
        }

        this.borderWidth = borderWidth;
        invalidate();
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        final int width = getWidth();
        final int height = getHeight();
        if (width >= (radiusLeftTop + radiusRightTop)
                && width >= (radiusLeftBottom + radiusRightBottom)
                && height >= (radiusLeftTop + radiusLeftBottom)
                && height >= (radiusRightTop + radiusRightBottom)) {
            // line four rounded corners.
            path.moveTo(radiusLeftTop, 0);
            path.lineTo(width - radiusRightTop, 0);
            path.quadTo(width, 0, width, radiusRightTop);
            path.lineTo(width, height - radiusRightBottom);
            path.quadTo(width, height, width - radiusRightBottom, height);
            path.lineTo(radiusLeftBottom, height);
            path.quadTo(0, height, 0, height - radiusLeftBottom);
            path.lineTo(0, radiusLeftTop);
            path.quadTo(0, 0, radiusLeftTop, 0);
            canvas.clipPath(path);
            super.dispatchDraw(canvas);
            // draw border.
            if (borderWidth > 0) {
                paint.setStyle(Paint.Style.STROKE);
                paint.setAntiAlias(true);
                paint.setColor(borderColor);
                paint.setStrokeWidth(borderWidth);
                canvas.drawPath(path, paint);
            }
            path.close();
            path.reset();
            paint.reset();
        } else {
            super.dispatchDraw(canvas);
        }
    }
}

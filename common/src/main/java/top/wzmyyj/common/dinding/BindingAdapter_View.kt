package top.wzmyyj.common.dinding

import android.graphics.Outline
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import androidx.databinding.BindingAdapter
import top.wzmyyj.common.utils.pt2px

/**
 * Created on 2020/10/19.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
//------------------------View --------------------------//


@BindingAdapter(value = ["binding_isGone"], requireAll = true)
fun View.bindingIsGone(isGone: Boolean) {
    visibility = if (isGone) View.GONE else View.VISIBLE
}

@BindingAdapter(value = ["binding_isVisible"], requireAll = true)
fun View.bindingIsVisible(show: Boolean) {
    visibility = if (show) View.VISIBLE else View.INVISIBLE
}

@BindingAdapter(value = ["binding_isSelected"], requireAll = true)
fun View.bindingIsSelect(select: Boolean) {
    this.isSelected = select
}

@BindingAdapter(value = ["binding_rect_radius"], requireAll = true)
fun View.bindingRectCornerRadius(radius: Float) {
    val p = object : ViewOutlineProvider() {
        override fun getOutline(v: View?, outline: Outline?) {
            if (v == null || outline == null) return
            outline.setRoundRect(0, 0, v.width, v.height, radius)
        }
    }
    this.outlineProvider = p
    this.clipToOutline = true
}

@BindingAdapter(value = ["binding_rect_oval"], requireAll = true)
fun View.bindingRectOval(oval: Boolean) {
    val p = object : ViewOutlineProvider() {
        override fun getOutline(v: View?, outline: Outline?) {
            if (v == null || outline == null) return
            outline.setOval(0, 0, v.width, v.height)
        }
    }
    this.outlineProvider = p
    this.clipToOutline = true
}

@BindingAdapter(value = ["binding_requestLayout"], requireAll = true)
fun View.bindingRequestLayout(b: Boolean) {
    if (b) this.requestLayout()
}

@BindingAdapter(value = ["binding_width", "binding_height"], requireAll = true)
fun View.bindingWidthAndHeight(width: Float, height: Float) {
    val p = this.layoutParams
    p.width = width.toInt()
    p.height = height.toInt()
    this.requestLayout()
}

@BindingAdapter(value = ["binding_width"], requireAll = true)
fun View.bindingWidth(width: Float) {
    val p = this.layoutParams
    p.width = width.toInt()
    this.requestLayout()
}

@BindingAdapter(value = ["binding_height"], requireAll = true)
fun View.bindingHeight(height: Float) {
    val p = this.layoutParams
    p.height = height.toInt()
    this.requestLayout()
}

@BindingAdapter(value = ["binding_width_pt", "binding_height_pt"], requireAll = true)
fun View.bindingWidthAndHeightPt(width: Float, height: Float) {
    val p = this.layoutParams
    p.width = width.pt2px(context)
    p.height = height.pt2px(context)
    this.requestLayout()
}

@BindingAdapter(value = ["binding_width_pt"], requireAll = true)
fun View.bindingWidthWithPt(ptWidth: Float) {
    val pxWidth = ptWidth.pt2px(this.context).toFloat()
    bindingWidth(pxWidth)
}

@BindingAdapter(value = ["binding_height_pt"], requireAll = true)
fun View.bindingHeightPt(ptHeight: Float) {
    val pxHeight = ptHeight.pt2px(this.context).toFloat()
    bindingHeight(pxHeight)
}

@BindingAdapter(value = ["binding_padding"], requireAll = true)
fun View.bindingPadding(padding: Float) {
    setPadding(padding.toInt(), padding.toInt(), padding.toInt(), padding.toInt())
}

@BindingAdapter(value = ["binding_paddingTop"], requireAll = true)
fun View.bindingPaddingTop(topPadding: Float) {
    setPadding(paddingLeft, topPadding.toInt(), paddingRight, paddingBottom)
}

@BindingAdapter(value = ["binding_paddingBottom"], requireAll = true)
fun View.bindingPaddingBottom(bottomPadding: Float) {
    setPadding(paddingLeft, paddingTop, paddingRight, bottomPadding.toInt())
}

@BindingAdapter(value = ["binding_paddingLeft"], requireAll = true)
fun View.bindingPaddingLeft(leftPadding: Float) {
    setPadding(leftPadding.toInt(), paddingTop, paddingRight, paddingBottom)
}

@BindingAdapter(value = ["binding_paddingRight"], requireAll = true)
fun View.bindingPaddingRight(rightPadding: Float) {
    setPadding(paddingLeft, paddingTop, rightPadding.toInt(), paddingBottom)
}

@BindingAdapter(value = ["binding_paddingStart"], requireAll = true)
fun View.bindingPaddingStart(startPadding: Float) {
    setPaddingRelative(startPadding.toInt(), paddingTop, paddingEnd, paddingBottom)
}

@BindingAdapter(value = ["binding_paddingEnd"], requireAll = true)
fun View.bindingPaddingEnd(endPadding: Float) {
    setPaddingRelative(paddingStart, paddingTop, endPadding.toInt(), paddingBottom)
}

@BindingAdapter(value = ["binding_marginTop"], requireAll = true)
fun View.bindingMarginTop(marginTop: Float) {
    if (this.layoutParams is ViewGroup.MarginLayoutParams) {
        val p = this.layoutParams as ViewGroup.MarginLayoutParams
        p.topMargin = marginTop.toInt()
        this.layoutParams = p
    }
}

@BindingAdapter(value = ["binding_marginBottom"], requireAll = true)
fun View.bindingMarginBottom(marginBottom: Float) {
    if (this.layoutParams is ViewGroup.MarginLayoutParams) {
        val p = this.layoutParams as ViewGroup.MarginLayoutParams
        p.bottomMargin = marginBottom.toInt()
        this.layoutParams = p
    }
}

@BindingAdapter(value = ["binding_marginLeft"], requireAll = true)
fun View.bindingMarginLeft(marginLeft: Float) {
    if (this.layoutParams is ViewGroup.MarginLayoutParams) {
        val p = this.layoutParams as ViewGroup.MarginLayoutParams
        p.leftMargin = marginLeft.toInt()
        this.layoutParams = p
    }
}

@BindingAdapter(value = ["binding_marginRight"], requireAll = true)
fun View.bindingMarginRight(marginRight: Float) {
    if (this.layoutParams is ViewGroup.MarginLayoutParams) {
        val p = this.layoutParams as ViewGroup.MarginLayoutParams
        p.rightMargin = marginRight.toInt()
        this.layoutParams = p
    }
}

@BindingAdapter(value = ["binding_marginStart"], requireAll = true)
fun View.bindingMarginStart(marginStart: Float) {
    if (this.layoutParams is ViewGroup.MarginLayoutParams) {
        val p = this.layoutParams as ViewGroup.MarginLayoutParams
        p.marginStart = marginStart.toInt()
        this.layoutParams = p
    }
}

@BindingAdapter(value = ["binding_marginEnd"], requireAll = true)
fun View.bindingMarginEnd(marginEnd: Float) {
    if (this.layoutParams is ViewGroup.MarginLayoutParams) {
        val p = this.layoutParams as ViewGroup.MarginLayoutParams
        p.marginEnd = marginEnd.toInt()
        this.layoutParams = p
    }
}

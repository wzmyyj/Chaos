package top.wzmyyj.common.utils

import android.content.Context
import top.wzmyyj.common.app.FeApp
import top.wzmyyj.utils.display.DimensionUtil

/**
 * Created on 2020/10/19.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
fun Float.sp2px(context: Context = FeApp.context): Int {
    return DimensionUtil.sp2px(context, this)
}

fun Float.dp2px(context: Context = FeApp.context): Int {
    return DimensionUtil.dp2px(context, this)
}

fun Float.pt2px(context: Context = FeApp.context): Int {
    return DimensionUtil.pt2px(context, this)
}

fun Int.px2sp(context: Context = FeApp.context): Float {
    return DimensionUtil.px2sp(context, this)
}

fun Int.px2dp(context: Context = FeApp.context): Float {
    return DimensionUtil.px2dp(context, this)
}

fun Int.px2pt(context: Context = FeApp.context): Float {
    return DimensionUtil.px2pt(context, this)
}
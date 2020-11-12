package top.wzmyyj.common.utils

import android.view.View

/**
 * Created on 2020/11/12.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
fun View.gone() {
    visibility = View.GONE
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.inVisible() {
    visibility = View.INVISIBLE
}

fun View.maxAlpha() {
    alpha = 1F
}

fun View.minAlpha() {
    alpha = 0F
}
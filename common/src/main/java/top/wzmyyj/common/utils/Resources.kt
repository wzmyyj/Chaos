package top.wzmyyj.common.utils

import android.graphics.drawable.Drawable
import androidx.annotation.ColorInt
import androidx.core.content.ContextCompat
import top.wzmyyj.common.app.FeApp

/**
 * Created on 2020/10/19.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
fun Int.string(): String {
    return FeApp.context.getString(this)
}

fun Int.formatResString(vararg args: Any?): String {
    return String.format(FeApp.context.getString(this), *args)
}

fun Int.drawable(): Drawable {
    return ContextCompat.getDrawable(FeApp.context, this)!!
}

@ColorInt
fun Int.color(): Int {
    return ContextCompat.getColor(FeApp.context, this)
}
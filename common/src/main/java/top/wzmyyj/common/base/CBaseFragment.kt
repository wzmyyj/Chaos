package top.wzmyyj.common.base

import android.graphics.drawable.Drawable
import androidx.annotation.ColorInt
import top.wzmyyj.base.app.BaseFragment

/**
 * Created on 2019/09/30.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
open class CBaseFragment : BaseFragment() {

    fun Int.string(): String = getString(this)

    fun Int.drawable(): Drawable = getDrawable(this)!!

    @ColorInt
    fun Int.color(): Int = getColor(this)
}
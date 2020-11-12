package top.wzmyyj.common.binding

import android.graphics.Typeface
import android.widget.TextView
import androidx.databinding.BindingAdapter

/**
 * Created on 2020/11/05.
 *
 * BindingAdapter of TextView.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 * @see TextView
 */
@BindingAdapter("binding_font_type")
fun TextView.bindingImpactTypeface(path: String) {
    val tf: Typeface = Typeface.createFromAsset(context.assets, path)
    this.typeface = tf
}
package top.wzmyyj.home.common.binding

import androidx.databinding.BindingAdapter
import com.youth.banner.Banner
import com.youth.banner.listener.OnBannerListener

/**
 * Created on 2020/11/04.
 *
 * BindingAdapter of Banner.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 * @see Banner
 */
@BindingAdapter(value = ["binding_banner_images", "binding_banner_titles"], requireAll = true)
fun Banner.bindingBannerData(images: List<*>?, titles: List<String>?) {
    update(images.orEmpty(), titles.orEmpty())
}

@BindingAdapter(value = ["binding_banner_clickListener"], requireAll = true)
fun Banner.bindingBannerListener(listener: OnBannerListener?) {
    setOnBannerListener(listener)
}
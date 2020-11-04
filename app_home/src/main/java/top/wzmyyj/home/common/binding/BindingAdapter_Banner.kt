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
@BindingAdapter(value = ["binding_banner_titles"], requireAll = true)
fun Banner.bindingBannerTitles(titles: List<String>?) {
    setBannerTitles(titles.orEmpty())
}

@BindingAdapter(value = ["binding_banner_images"], requireAll = true)
fun Banner.bindingBannerImages(images: List<*>?) {
    setImages(images.orEmpty())
}

@BindingAdapter(value = ["binding_banner_clickListener"], requireAll = true)
fun Banner.bindingBannerListener(listener: OnBannerListener?) {
    setOnBannerListener(listener)
}
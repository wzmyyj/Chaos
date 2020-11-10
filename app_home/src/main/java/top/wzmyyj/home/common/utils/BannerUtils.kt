package top.wzmyyj.home.common.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.youth.banner.Banner
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import com.youth.banner.loader.ImageLoader
import top.wzmyyj.home.R

/**
 * Created on 2020/11/05.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */

fun Banner.defaultConfig() {
    // 设置自动轮播，默认为true
    isAutoPlay(true)
    // 设置轮播时间
    setDelayTime(5000)
    // 设置图片加载器
    setImageLoader(BannerImageLoader())
    // 设置指示器位置（当banner模式中有指示器时）
    setIndicatorGravity(BannerConfig.RIGHT)
    // 设置banner样式
    setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE)
    // 设置banner动画效果
    setBannerAnimation(Transformer.Default)
}

class BannerImageLoader : ImageLoader() {

    override fun displayImage(context: Context?, path: Any?, imageView: ImageView?) {
        Glide.with(imageView!!)
            .load(path as String?)
            .placeholder(R.color.colorEEEEEE)
            .apply(RequestOptions().fitCenter().error(R.color.colorEEEEEE))
            .into(imageView)
    }
}
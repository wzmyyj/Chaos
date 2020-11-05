package top.wzmyyj.home.major.ui.adapter.vtd

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.youth.banner.Transformer
import top.wzmyyj.adapter.core.ViewTypeDelegate
import top.wzmyyj.home.R
import top.wzmyyj.home.common.utils.defaultConfig
import top.wzmyyj.home.databinding.HomeBannerBinding
import top.wzmyyj.home.major.model.HomeBannerVhModel
import top.wzmyyj.utils.app.LifecycleUtil

/**
 * Created on 2020/11/05.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
class HomeBannerVTD : ViewTypeDelegate<HomeBannerBinding, HomeBannerVhModel> {

    override fun getViewType(): Int = R.layout.home_banner

    override fun onCreateVH(binding: HomeBannerBinding) {
        binding.banner.apply {
            defaultConfig()
            // 设置banner动画效果。彩蛋：特定时间打开可能会不一样的动画。
            when (System.currentTimeMillis() / 6000 % 60) {
                0L -> setBannerAnimation(Transformer.DepthPage)
                30L -> setBannerAnimation(Transformer.Stack)
                else -> setBannerAnimation(Transformer.Accordion)
            }
        }
        // 设置生命周期监听，自动播放和停止播放。
        val owner = LifecycleUtil.getOwnerByView(binding.root) ?: return
        owner.lifecycle.addObserver(object : DefaultLifecycleObserver {
            override fun onResume(owner: LifecycleOwner) {
                //开始轮播
                binding.banner.startAutoPlay()
            }

            override fun onPause(owner: LifecycleOwner) {
                //结束轮播
                binding.banner.stopAutoPlay()
            }
        })
    }

    override fun onBindVH(binding: HomeBannerBinding, m: HomeBannerVhModel) {}
}
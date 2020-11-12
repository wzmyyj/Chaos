package top.wzmyyj.home.major.ui.adapter

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import top.wzmyyj.adapter.core.BindingViewHolder
import top.wzmyyj.adapter.core.ViewTypeDelegateManager
import top.wzmyyj.common.base.adapter.CBaseDiffAdapter
import top.wzmyyj.home.BR
import top.wzmyyj.home.major.model.HomeBannerVhModel
import top.wzmyyj.home.major.model.HomeBlockVhModel
import top.wzmyyj.home.major.model.HomeColumnVhModel
import top.wzmyyj.home.major.model.IHomeVhModelType
import top.wzmyyj.home.major.ui.adapter.vtd.HomeBannerVTD
import top.wzmyyj.home.major.ui.adapter.vtd.HomeBlockVTD
import top.wzmyyj.home.major.ui.adapter.vtd.HomeColumnVTD
import top.wzmyyj.home.major.ui.adapter.vtd.HomeTableVTD
import top.wzmyyj.utils.tools.LogUtil

/**
 * Created on 2020/10/23.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
class HomeAdapter(private val listener: OnAdapterEventListener) :
    CBaseDiffAdapter<IHomeVhModelType>() {

    companion object{
       var i=0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder {
        val t = System.currentTimeMillis()
        val h = super.onCreateViewHolder(parent, viewType)
        val x = System.currentTimeMillis() - t
        LogUtil.w("性能测试", "onCreateViewHolder${i++} 用了:$x ms" )
        return h
    }

    override fun onCreateVHForAll(binding: ViewDataBinding) {
        binding.setVariable(BR.listener, listener)
    }

    override fun onBindVHForAll(binding: ViewDataBinding, m: IHomeVhModelType) {
        binding.setVariable(BR.item, m)
    }

    override fun initManager(manager: ViewTypeDelegateManager<IHomeVhModelType>) {
        manager.add(HomeBannerVTD())
        manager.add(HomeTableVTD(listener))
        manager.add(HomeBlockVTD(listener))
        manager.add(HomeColumnVTD(listener))
    }

    interface OnAdapterEventListener :
        HomeBannerVhModel.OnItemEventListener,
        HomeTableAdapter.OnAdapterEventListener,
        HomeBlockVhModel.OnItemEventListener,
        HomeBlockAdapter.OnAdapterEventListener,
        HomeColumnVhModel.OnItemEventListener,
        HomeColumnAdapter.OnAdapterEventListener

}
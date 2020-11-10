package top.wzmyyj.home.major.ui.adapter

import androidx.databinding.ViewDataBinding
import top.wzmyyj.adapter.core.ViewTypeDelegateManager
import top.wzmyyj.common.base.adapter.CBaseDiffAdapter
import top.wzmyyj.home.BR
import top.wzmyyj.home.major.model.HomeBannerVhModel
import top.wzmyyj.home.major.model.HomeColumnVhModel
import top.wzmyyj.home.major.model.IHomeVhModelType
import top.wzmyyj.home.major.ui.adapter.vtd.HomeBannerVTD
import top.wzmyyj.home.major.ui.adapter.vtd.HomeColumnVTD
import top.wzmyyj.home.major.ui.adapter.vtd.HomeTableVTD

/**
 * Created on 2020/10/23.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
class HomeAdapter(private val listener: OnAdapterEventListener) :
    CBaseDiffAdapter<IHomeVhModelType>() {

    override fun onCreateVHForAll(binding: ViewDataBinding) {
        binding.setVariable(BR.listener, listener)
    }

    override fun onBindVHForAll(binding: ViewDataBinding, m: IHomeVhModelType) {
        binding.setVariable(BR.item, m)
    }

    override fun initManager(manager: ViewTypeDelegateManager<IHomeVhModelType>) {
        manager.add(HomeBannerVTD())
        manager.add(HomeTableVTD(listener))
        manager.add(HomeColumnVTD(listener))
    }

    interface OnAdapterEventListener :
        HomeBannerVhModel.OnItemEventListener,
        HomeTableAdapter.OnAdapterEventListener,
        HomeColumnVhModel.OnItemEventListener,
        HomeColumnAdapter.OnAdapterEventListener

}
package top.wzmyyj.home.major.ui.adapter

import androidx.databinding.ViewDataBinding
import top.wzmyyj.common.base.adapter.CBaseAdapter
import top.wzmyyj.home.BR
import top.wzmyyj.home.major.model.HomeBlockItemVhModel
import top.wzmyyj.home.major.model.IHomeBlockVhModelType

/**
 * Created on 2020/11/09.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
class HomeBlockAdapter(private val listener: OnAdapterEventListener) :
    CBaseAdapter<IHomeBlockVhModelType>() {

    override fun onCreateVHForAll(binding: ViewDataBinding) {
        binding.setVariable(BR.listener, listener)
    }

    override fun onBindVHForAll(binding: ViewDataBinding, m: IHomeBlockVhModelType) {
        binding.setVariable(BR.item, m)
    }

    interface OnAdapterEventListener : HomeBlockItemVhModel.OnItemEventListener
}
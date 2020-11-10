package top.wzmyyj.home.major.ui.adapter

import androidx.databinding.ViewDataBinding
import top.wzmyyj.common.base.adapter.CBaseAdapter
import top.wzmyyj.home.BR
import top.wzmyyj.home.major.model.HomeColumnItemVhModel
import top.wzmyyj.home.major.model.IHomeColumnVhModelType

/**
 * Created on 2020/11/09.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
class HomeColumnAdapter(private val listener: OnAdapterEventListener) :
    CBaseAdapter<IHomeColumnVhModelType>() {

    override fun onCreateVHForAll(binding: ViewDataBinding) {
        binding.setVariable(BR.listener, listener)
    }

    override fun onBindVHForAll(binding: ViewDataBinding, m: IHomeColumnVhModelType) {
        binding.setVariable(BR.item, m)
    }

    interface OnAdapterEventListener : HomeColumnItemVhModel.OnItemEventListener
}
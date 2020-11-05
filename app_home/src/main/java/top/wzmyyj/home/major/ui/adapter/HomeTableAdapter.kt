package top.wzmyyj.home.major.ui.adapter

import androidx.databinding.ViewDataBinding
import top.wzmyyj.common.base.adapter.CBaseAdapter
import top.wzmyyj.home.BR
import top.wzmyyj.home.major.model.HomeTableItemVhModel
import top.wzmyyj.home.major.model.IHomeTableVhModelType

/**
 * Created on 2020/10/23.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
class HomeTableAdapter(private val listener: OnAdapterEventListener) :
    CBaseAdapter<IHomeTableVhModelType>() {

    override fun onCreateVHForAll(binding: ViewDataBinding) {
        binding.setVariable(BR.listener, listener)
    }

    override fun onBindVHForAll(binding: ViewDataBinding, m: IHomeTableVhModelType) {
        binding.setVariable(BR.item, m)
    }

    interface OnAdapterEventListener : HomeTableItemVhModel.OnItemEventListener

}
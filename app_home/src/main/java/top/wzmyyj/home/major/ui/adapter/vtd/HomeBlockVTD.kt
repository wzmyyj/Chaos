package top.wzmyyj.home.major.ui.adapter.vtd

import top.wzmyyj.adapter.core.ViewTypeDelegate
import top.wzmyyj.home.R
import top.wzmyyj.home.databinding.HomeBlockBinding
import top.wzmyyj.home.major.model.HomeBlockVhModel
import top.wzmyyj.home.major.ui.adapter.HomeBlockAdapter

/**
 * Created on 2020/11/09.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
class HomeBlockVTD(private val listener: HomeBlockAdapter.OnAdapterEventListener) :
    ViewTypeDelegate<HomeBlockBinding, HomeBlockVhModel> {

    override fun getViewType(): Int = R.layout.home_block

    override fun onCreateVH(binding: HomeBlockBinding) {
        binding.rvList.adapter = HomeBlockAdapter(listener)
    }

    override fun onBindVH(binding: HomeBlockBinding, m: HomeBlockVhModel) {}
}
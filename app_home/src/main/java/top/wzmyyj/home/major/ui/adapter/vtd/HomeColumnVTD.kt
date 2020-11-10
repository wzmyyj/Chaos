package top.wzmyyj.home.major.ui.adapter.vtd

import top.wzmyyj.adapter.core.ViewTypeDelegate
import top.wzmyyj.home.R
import top.wzmyyj.home.databinding.HomeColumnBinding
import top.wzmyyj.home.major.model.HomeColumnVhModel
import top.wzmyyj.home.major.ui.adapter.HomeColumnAdapter

/**
 * Created on 2020/11/09.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
class HomeColumnVTD(private val listener: HomeColumnAdapter.OnAdapterEventListener) :
    ViewTypeDelegate<HomeColumnBinding, HomeColumnVhModel> {

    override fun getViewType(): Int = R.layout.home_column

    override fun onCreateVH(binding: HomeColumnBinding) {
        binding.rvList.adapter = HomeColumnAdapter(listener)
    }

    override fun onBindVH(binding: HomeColumnBinding, m: HomeColumnVhModel) {}
}
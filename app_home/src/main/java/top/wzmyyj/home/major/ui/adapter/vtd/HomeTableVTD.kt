package top.wzmyyj.home.major.ui.adapter.vtd

import top.wzmyyj.adapter.core.ViewTypeDelegate
import top.wzmyyj.home.R
import top.wzmyyj.home.databinding.HomeTableBinding
import top.wzmyyj.home.major.model.HomeTableVhModel
import top.wzmyyj.home.major.ui.adapter.HomeTableAdapter

/**
 * Created on 2020/11/05.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
class HomeTableVTD(private val listener: HomeTableAdapter.OnAdapterEventListener) :
    ViewTypeDelegate<HomeTableBinding, HomeTableVhModel> {

    override fun getViewType(): Int = R.layout.home_table

    override fun onCreateVH(binding: HomeTableBinding) {
        binding.rv.adapter = HomeTableAdapter(listener)
    }

    override fun onBindVH(binding: HomeTableBinding, m: HomeTableVhModel) {}
}
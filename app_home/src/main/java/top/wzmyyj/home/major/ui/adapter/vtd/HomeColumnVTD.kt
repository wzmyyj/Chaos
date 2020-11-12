package top.wzmyyj.home.major.ui.adapter.vtd

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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

    private val rvPool = RecyclerView.RecycledViewPool().apply {
        setMaxRecycledViews(R.layout.home_column_item, 50)
    }

    override fun onCreateVH(binding: HomeColumnBinding) {
        // 预加载4个。
        (binding.rvList.layoutManager as LinearLayoutManager).initialPrefetchItemCount = 4
        binding.rvList.setRecycledViewPool(rvPool)
        binding.rvList.adapter = HomeColumnAdapter(listener)
    }

    override fun onBindVH(binding: HomeColumnBinding, m: HomeColumnVhModel) {}
}
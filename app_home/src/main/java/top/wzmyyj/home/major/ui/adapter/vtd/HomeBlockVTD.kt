package top.wzmyyj.home.major.ui.adapter.vtd

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
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

    private val rvPool = RecyclerView.RecycledViewPool().apply {
        setMaxRecycledViews(R.layout.home_block_item_1, 8)
        setMaxRecycledViews(R.layout.home_block_item_2, 16)
        setMaxRecycledViews(R.layout.home_block_item_3, 24)
    }

    override fun onCreateVH(binding: HomeBlockBinding) {
        binding.rv.setRecycledViewPool(rvPool)
        binding.rv.setHasFixedSize(true)
        binding.rv.isNestedScrollingEnabled = false
        binding.rv.layoutManager = object : GridLayoutManager(binding.root.context, 6) {
            override fun canScrollVertically(): Boolean = false
        }
        binding.rv.adapter = HomeBlockAdapter(listener)
    }

    override fun onBindVH(binding: HomeBlockBinding, m: HomeBlockVhModel) {}
}
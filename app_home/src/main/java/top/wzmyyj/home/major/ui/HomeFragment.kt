package top.wzmyyj.home.major.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.scwang.smartrefresh.layout.listener.OnRefreshListener
import top.wzmyyj.common.base.CBaseFragment
import top.wzmyyj.common.utils.getViewModel
import top.wzmyyj.common.utils.toast
import top.wzmyyj.home.databinding.HomeFragmentBinding
import top.wzmyyj.home.major.model.*
import top.wzmyyj.home.major.ui.adapter.HomeAdapter
import top.wzmyyj.home.major.vm.HomeViewModel

/**
 * Created on 2020/10/14.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
class HomeFragment : CBaseFragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    interface OnEventListener : OnRefreshListener {
        /**
         * 点击搜索。
         */
        fun onSearchClick()
    }

    private val binding by lazy { HomeFragmentBinding.inflate(layoutInflater) }

    private val vm by lazy { getViewModel(HomeViewModel::class.java) }

    private val rvAdapter by lazy { HomeAdapter(eventListener) }

    override fun rootView(): View? = binding.root

    override fun initData() {
        vm.init()
    }

    override fun initView() {
        binding.lifecycleOwner = viewLifecycleOwner
        binding.vm = vm
        binding.listener = eventListener
        binding.rv.adapter = rvAdapter
//        binding.rv.setHasFixedSize(true)
//        binding.rv.setItemViewCacheSize(20)
    }

    override fun subscribeUI() {

    }

    //--------------event listener-------------//

    private val eventListener = object : OnEventListener, HomeAdapter.OnAdapterEventListener {

        override fun onSearchClick() {
            toast("Search!")
        }

        override fun onRefresh(refreshLayout: RefreshLayout?) {
            TODO("Not yet implemented")
        }

        override fun onBannerClick(item: HomeBannerVhModel, position: Int) {
            toast(item.titleList.getOrNull(position))
        }

        override fun onTableItemClick(item: HomeTableItemVhModel) {
            toast(item.route)
        }

        override fun onBlockMoreClick(item: HomeBlockVhModel) {
            toast(item.route)
        }

        override fun onBlockItemClick(item: HomeBlockItemVhModel) {
            toast(item.route)
        }

        override fun onColumnMoreClick(item: HomeColumnVhModel) {
            toast(item.route)
        }

        override fun onColumnItemClick(item: HomeColumnItemVhModel) {
            toast(item.route)
        }

    }

}
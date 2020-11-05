package top.wzmyyj.home.major.ui

import android.view.View
import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.scwang.smartrefresh.layout.listener.OnRefreshListener
import top.wzmyyj.common.base.CBaseFragment
import top.wzmyyj.common.utils.getViewModel
import top.wzmyyj.common.utils.toast
import top.wzmyyj.home.databinding.HomeFragmentBinding
import top.wzmyyj.home.major.model.HomeBannerVhModel
import top.wzmyyj.home.major.model.HomeTableItemVhModel
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
    }

    override fun subscribeUI() {

    }

    //--------------event listener-------------//

    private val eventListener = object : OnEventListener, HomeAdapter.OnAdapterEventListener {

        override fun onSearchClick() {
            TODO("Not yet implemented")
        }

        override fun onRefresh(refreshLayout: RefreshLayout?) {
            TODO("Not yet implemented")
        }

        override fun onBannerClick(item: HomeBannerVhModel, position: Int) {
            toast(item.titleList.getOrNull(position))
        }

        override fun onTableItemClick(item: HomeTableItemVhModel) {
            toast(item.title)
        }

    }

}
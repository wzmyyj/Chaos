package top.wzmyyj.main.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import top.wzmyyj.common.base.CBaseFragment
import top.wzmyyj.common_service.RouterManager.getService
import top.wzmyyj.common_service.category.ICategoryService
import top.wzmyyj.common_service.home.IHomeService
import top.wzmyyj.common_service.mine.IMineService
import top.wzmyyj.common_service.track.ITrackService
import top.wzmyyj.main.R
import top.wzmyyj.main.ui.helper.PagerTabHelper

/**
 * Created on 2020/10/14.
 *
 * Main pager fragment.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
class MainFragment : CBaseFragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val homeService by lazy { getService(IHomeService::class.java) }

    private val categoryService by lazy { getService(ICategoryService::class.java) }

    private val trackService by lazy { getService(ITrackService::class.java) }

    private val mineService by lazy { getService(IMineService::class.java) }

    private val helper: PagerTabHelper by lazy {
        PagerTabHelper().apply {
            addHome()
            addCategory()
            addTrack()
            addMine()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return helper.getView(inflater, childFragmentManager, container)
    }

    /**
     * Add Home page.
     */
    private fun PagerTabHelper.addHome() {
        val fragment = homeService?.getFragment() ?: return
        add(fragment, R.string.main_home.string(), R.drawable.main_selector_home.drawable())
    }

    /**
     * Add Category page.
     */
    private fun PagerTabHelper.addCategory() {
        val fragment = categoryService?.getFragment() ?: return
        add(fragment, R.string.main_category.string(), R.drawable.main_selector_category.drawable())
    }

    /**
     * Add Track page.
     */
    private fun PagerTabHelper.addTrack() {
        val fragment = trackService?.getFragment() ?: return
        add(fragment, R.string.main_track.string(), R.drawable.main_selector_track.drawable())
    }

    /**
     * Add Mine page.
     */
    private fun PagerTabHelper.addMine() {
        val fragment = mineService?.getFragment() ?: return
        add(fragment, R.string.main_mine.string(), R.drawable.main_selector_mine.drawable())
    }

}

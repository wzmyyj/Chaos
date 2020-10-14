package top.wzmyyj.main.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import top.wzmyyj.common.app.CBaseFragment
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

    private val helper: PagerTabHelper by lazy {
        PagerTabHelper {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return helper.getView(requireContext(), childFragmentManager, container)
    }

}

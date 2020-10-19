package top.wzmyyj.home.major.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import top.wzmyyj.common.base.CBaseFragment
import top.wzmyyj.home.databinding.HomeFragmentBinding

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

    private val binding by lazy { HomeFragmentBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

}
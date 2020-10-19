package top.wzmyyj.track.major.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import top.wzmyyj.common.base.CBaseFragment
import top.wzmyyj.track.databinding.TrackFragmentBinding

/**
 * Created on 2020/10/14.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
class TrackFragment : CBaseFragment() {

    companion object {
        fun newInstance() = TrackFragment()
    }

    private val binding by lazy { TrackFragmentBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

}
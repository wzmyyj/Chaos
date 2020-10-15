package top.wzmyyj.message.major.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import top.wzmyyj.common.app.CBaseFragment
import top.wzmyyj.message.databinding.MessageFragmentBinding

/**
 * Created on 2020/10/14.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
class MessageFragment : CBaseFragment() {

    companion object {
        fun newInstance() = MessageFragment()
    }

    private val binding by lazy { MessageFragmentBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

}
package top.wzmyyj.category.major.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import top.wzmyyj.category.databinding.CategoryFragmentBinding
import top.wzmyyj.common.app.CBaseFragment

/**
 * Created on 2020/10/14.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
class CategoryFragment : CBaseFragment() {

    companion object {
        fun newInstance() = CategoryFragment()
    }

    private val binding by lazy { CategoryFragmentBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

}
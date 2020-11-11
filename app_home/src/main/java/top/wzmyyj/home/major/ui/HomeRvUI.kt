package top.wzmyyj.home.major.ui

import androidx.annotation.MainThread
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import top.wzmyyj.common.base.adapter.CBaseDiffAdapter
import top.wzmyyj.home.databinding.HomeFragmentBinding
import java.util.*

/**
 * Created on 2020/11/11.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
@MainThread
class HomeRvUI private constructor() : DefaultLifecycleObserver {

    companion object {
        private const val MAX_SCROLL_Y: Float = 40F //pt
        private const val SHOW_BUTTON_SCROLL_Y: Float = 400F //pt
        private const val HEADER_HEIGHT: Float = 154F //pt
        private const val MAX_ALPHA: Float = 1F

        // 保证一对一的关系。
        private val map = WeakHashMap<LifecycleOwner, HomeRvUI>()

        fun with(owner: LifecycleOwner): HomeRvUI {
            return map[owner] ?: HomeRvUI().apply {
                map[owner] = this
                owner.lifecycle.addObserver(this)
            }
        }

        fun get(owner: LifecycleOwner): HomeRvUI? = map[owner]
    }

    /**
     * 初始化UI。
     */
    fun init(binding: HomeFragmentBinding, rvAdapter: CBaseDiffAdapter<*>) {

    }

}
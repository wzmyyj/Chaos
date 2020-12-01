package top.wzmyyj.home.major.ui

import androidx.annotation.MainThread
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import top.wzmyyj.common.base.adapter.CBaseDiffAdapter
import top.wzmyyj.common.utils.*
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
        private const val MAX_SCROLL_Y: Float = 100F //pt
        private const val SHOW_BUTTON_SCROLL_Y: Float = 400F //pt

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

    override fun onDestroy(owner: LifecycleOwner) {
        map[owner] = null
    }

    // 记录滑动距离。
    private var rvScrollY: Int = 0

    /**
     * 初始化UI。
     */
    fun init(binding: HomeFragmentBinding, rvAdapter: CBaseDiffAdapter<*>) {
        binding.rv.adapter = rvAdapter
        val maxScrollY = MAX_SCROLL_Y.pt2px()
        val showButtonScrollY = SHOW_BUTTON_SCROLL_Y.pt2px()
        binding.clBar.minAlpha()
        binding.clBar.visible()
        binding.rv.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(v: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(v, dx, dy)
                rvScrollY += dy
                if (rvScrollY < maxScrollY) {
                    val alpha = rvScrollY.toFloat() / maxScrollY
                    binding.clBar.alpha = alpha
                } else {
                    binding.clBar.maxAlpha()
                }
                if (rvScrollY < showButtonScrollY) {
                    binding.ivBackTop.gone()
                } else {
                    binding.ivBackTop.visible()
                }
            }
        })
        binding.ivBackTop.setOnClickListener {
            binding.rv.smoothScrollToPosition(0)
        }
    }

}
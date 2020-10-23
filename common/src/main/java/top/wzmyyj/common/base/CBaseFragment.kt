package top.wzmyyj.common.base

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import top.wzmyyj.base.app.BaseFragment

/**
 * Created on 2019/09/30.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
open class CBaseFragment : BaseFragment() {

    fun Int.string(): String = getString(this)

    fun Int.drawable(): Drawable = getDrawable(this)!!

    @ColorInt
    fun Int.color(): Int = getColor(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return rootView()
    }

    private val initOnce by lazy {
        initData()
        initView()
        subscribeUI()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initOnce
    }

    /**
     * Get root view for onCreateView().
     */
    protected open fun rootView(): View? = null

    /**
     * Init data.
     */
    protected open fun initData() {}

    /**
     * Init view.
     */
    protected open fun initView() {}

    /**
     * Subscribe UI.
     */
    protected open fun subscribeUI() {}

}
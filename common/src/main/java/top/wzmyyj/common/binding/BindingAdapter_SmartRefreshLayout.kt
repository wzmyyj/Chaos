package top.wzmyyj.common.binding

import androidx.annotation.ColorInt
import androidx.databinding.BindingAdapter
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.scwang.smartrefresh.layout.footer.ClassicsFooter
import com.scwang.smartrefresh.layout.header.ClassicsHeader
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
import com.scwang.smartrefresh.layout.listener.OnRefreshListener
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener

/**
 * Created on 2020/10/16.
 *
 * BindingAdapter of SmartRefreshLayout.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 * @see SmartRefreshLayout
 */
@BindingAdapter("binding_srl_onRefreshLoadMoreListener")
fun SmartRefreshLayout.bindingOnRefreshLoadMoreListener(listener: OnRefreshLoadMoreListener) {
    setOnRefreshLoadMoreListener(listener)
}

@BindingAdapter("binding_srl_onRefreshListener")
fun SmartRefreshLayout.bindingOnRefreshListener(listener: OnRefreshListener) {
    setOnRefreshListener(listener)
}

@BindingAdapter("binding_srl_close_animation")
fun SmartRefreshLayout.bindingCloseAnimation(isColse: Boolean) {
    if (isColse) {
        //关闭下拉动画特效，减少延迟感觉
        this.setReboundDuration(0)
        this.finishRefresh(0)
    }
}

@BindingAdapter("binding_srl_onLoadMoreListener")
fun SmartRefreshLayout.bindingOnLoadMoreListener(listener: OnLoadMoreListener) {
    setOnLoadMoreListener(listener)
}

@BindingAdapter("binding_srl_isRefreshFinish")
fun SmartRefreshLayout.bindingIsRefreshFinish(isFinish: Boolean) {
    if (isFinish) {
        finishRefresh()
    }
}

@BindingAdapter("binding_srl_isLoadMoreFinish")
fun SmartRefreshLayout.bindingIsLoadMoreFinish(isFinish: Boolean) {
    if (isFinish) {
        finishLoadMore()
    }
}

@BindingAdapter("binding_srl_isNoMore")
fun SmartRefreshLayout.bindingNoMoreData(noMore: Boolean) {
    setNoMoreData(noMore)
}

@BindingAdapter("binding_srl_isEnableLoadMore")
fun SmartRefreshLayout.bindingIsEnableLoadMore(enable: Boolean) {
    isEnableLoadMore = enable
}

@BindingAdapter("binding_srl_isEnableRefresh")
fun SmartRefreshLayout.bindingIsEnableRefresh(enable: Boolean) {
    isEnableRefresh = enable
}

@BindingAdapter("binding_srl_isHeaderEmpty")
fun SmartRefreshLayout.bindingHeaderEmpty(isEmpty: Boolean) {
    val header = this.refreshHeader
    if (header is ClassicsHeader) {
        for (i in 0 until header.childCount) {
            val child = header.getChildAt(i)
            child.alpha = if (isEmpty) {
                0f
            } else {
                1f
            }
        }
    }
}

@BindingAdapter("binding_srl_isFooterEmpty")
fun SmartRefreshLayout.bindingFooterEmpty(isEmpty: Boolean) {
    val footer = this.refreshFooter
    if (footer is ClassicsFooter) {
        for (i in 0 until footer.childCount) {
            val child = footer.getChildAt(i)
            child.alpha = if (isEmpty) {
                0f
            } else {
                1f
            }
        }
    }
}

@BindingAdapter("binding_srl_headerPrimaryColor")
fun SmartRefreshLayout.bindingHeaderPrimaryColor(@ColorInt color: Int) {
    val header = this.refreshHeader
    if (header == null) {
        this.setRefreshHeader(ClassicsHeader(this.context).apply { setPrimaryColor(color) })
    } else {
        if (header is ClassicsHeader) {
            header.setPrimaryColor(color)
        }
    }
}

@BindingAdapter("binding_srl_footerPrimaryColor")
fun SmartRefreshLayout.bindingFooterPrimaryColor(@ColorInt color: Int) {
    val footer = this.refreshFooter
    if (footer == null) {
        this.setRefreshFooter(ClassicsFooter(this.context).apply { setPrimaryColor(color) })
    } else {
        if (footer is ClassicsFooter) {
            footer.setPrimaryColor(color)
        }
    }
}

@BindingAdapter("binding_srl_headerAccentColor")
fun SmartRefreshLayout.bindingHeaderAccentColor(@ColorInt color: Int) {
    val header = this.refreshHeader
    if (header == null) {
        this.setRefreshHeader(ClassicsHeader(this.context).apply { setAccentColor(color) })
    } else {
        if (header is ClassicsHeader) {
            header.setAccentColor(color)
        }
    }
}

@BindingAdapter("binding_srl_footerAccentColor")
fun SmartRefreshLayout.bindingFooterAccentColor(@ColorInt color: Int) {
    val footer = this.refreshFooter
    if (footer == null) {
        this.setRefreshFooter(ClassicsFooter(this.context).apply { setAccentColor(color) })
    } else {
        if (footer is ClassicsFooter) {
            footer.setAccentColor(color)
        }
    }
}
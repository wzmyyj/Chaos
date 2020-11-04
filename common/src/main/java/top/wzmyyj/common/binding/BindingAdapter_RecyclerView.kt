package top.wzmyyj.common.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import top.wzmyyj.adapter.core.IFeAdapter
import top.wzmyyj.adapter.core.IVhModelType

/**
 * Created on 2020/10/23.
 *
 * BindingAdapter of RecyclerView.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 * @see RecyclerView
 * @see IFeAdapter
 */
@Suppress("UNCHECKED_CAST")
@BindingAdapter(value = ["binding_rv_dataList"], requireAll = true)
fun <M : IVhModelType> RecyclerView.bindingDataList(list: List<M>?) {
    val adapter = this.adapter as? IFeAdapter<M> ?: return
    adapter.setList(list.orEmpty())
}

@Suppress("UNCHECKED_CAST")
@BindingAdapter(value = ["binding_rv_refreshItems"], requireAll = true)
fun <M : IVhModelType> RecyclerView.bindingRefreshItems(items: List<M>?) {
    val adapter = this.adapter as? IFeAdapter<M> ?: return
    adapter.refreshItems(items.orEmpty())
}

@BindingAdapter(value = ["binding_rv_noAnim"], requireAll = true)
fun RecyclerView.bindingNoAnimation(noAnim: Boolean) {
    if (noAnim) {
        animation = null
        itemAnimator = null
    }
}
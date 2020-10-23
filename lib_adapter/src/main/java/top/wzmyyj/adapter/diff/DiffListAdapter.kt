package top.wzmyyj.adapter.diff

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import top.wzmyyj.adapter.core.BindingViewHolder
import top.wzmyyj.adapter.core.FeAdapterHelper
import top.wzmyyj.adapter.core.IFeAdapter

/**
 * Created on 2020/10/22.
 *
 * DiffListAdapter. This adapter used {@link DiffUtil}.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 * @see ListAdapter
 * @see DiffUtil
 */
abstract class DiffListAdapter<M : IDiffVhModelType>(callback: DiffCallBack<M> = DiffCallBack()) :
    ListAdapter<M, BindingViewHolder>(callback), IFeAdapter<M> {

    private val helper by lazy { FeAdapterHelper(this) }

    private val readOnlyList = ArrayList<M>()

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        helper.onAttachedToRecyclerView()
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        helper.onDetachedFromRecyclerView()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder {
        return helper.onCreateViewHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: BindingViewHolder, position: Int) {
        helper.onBindViewHolder(holder, position)
    }

    override fun getItem(position: Int): M? {
        return super<ListAdapter>.getItem(position)
    }

    override fun setList(list: List<M>) {
        val li = helper.transform(list)
        readOnlyList.clear()
        readOnlyList.addAll(li)
        // Always submit a new list.
        submitList(li)
    }

    override fun getList(): List<M> {
        // Just for read.
        return readOnlyList
    }

    open class DiffCallBack<M : IDiffVhModelType> : DiffUtil.ItemCallback<M>() {

        override fun areContentsTheSame(oldItem: M, newItem: M): Boolean {
            // Judge whether the contents of two items are the same.
            return oldItem.areContentsTheSame(newItem)
        }

        override fun areItemsTheSame(oldItem: M, newItem: M): Boolean {
            // Judge whether two items use the same item.
            return oldItem.areItemsTheSame(newItem)
        }

        override fun getChangePayload(oldItem: M, newItem: M): Any? {
            // Advanced usage, used to extract changes and refresh local variables accurately.
            // Not for the time being.
            return null
        }
    }

}
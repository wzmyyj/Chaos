package top.wzmyyj.adapter.core

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding

/**
 * Created on 2020/10/21.
 *
 * Please let your RecyclerView.Adapter implements IExtAdapter.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
interface IExtAdapter<M : IVhModelType> {

    /**
     * What to do when creating the viewHolder for all.
     */
    fun onCreateVHForAll(binding: ViewDataBinding)

    /**
     * What to do when binding the viewHolder for all
     */
    fun onBindVHForAll(binding: ViewDataBinding, m: M)

    /**
     * Get item by position.
     */
    fun getItem(position: Int): M?

    /**
     * Create BaseViewHolder.
     */
    fun createVH(parent: ViewGroup, viewType: Int): BaseViewHolder

    /**
     * Init ViewTypeDelegateManager. You can add VTDs.
     */
    fun initManager(manager: ViewTypeDelegateManager<M>) {}

}
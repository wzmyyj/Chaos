@file:Suppress("unused")

package top.wzmyyj.adapter.core

/**
 * Created on 2020/11/10.
 *
 * When recyclerView's layoutManager is GridLayoutManager, item can fix span size.
 * When recyclerView's layoutManager is StaggeredGridLayoutManager, just can set SPAN_SIZE_FULL!
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
interface ISpanSize {

    companion object {
        // full one line.
        const val SPAN_SIZE_FULL = -1
        const val SPAN_SIZE_SINGLE = 1
        const val SPAN_SIZE_DOUBLE = 2
        const val SPAN_SIZE_TRIPLE = 3
    }

    /**
     * Get span size. How many lattices does a model occupy.
     */
    fun getSpanSize(): Int = SPAN_SIZE_SINGLE
}
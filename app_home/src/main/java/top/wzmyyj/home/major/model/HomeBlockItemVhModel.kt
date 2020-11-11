package top.wzmyyj.home.major.model

import top.wzmyyj.adapter.core.ISpanSize.Companion.SPAN_SIZE_DOUBLE
import top.wzmyyj.adapter.core.ISpanSize.Companion.SPAN_SIZE_FULL
import top.wzmyyj.adapter.core.ISpanSize.Companion.SPAN_SIZE_TRIPLE
import top.wzmyyj.home.R

/**
 * Created on 2020/11/09.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
abstract class HomeBlockItemVhModel : IHomeBlockVhModelType {

    var title: String = ""
    var desc: String = ""
    var imageUrl: String = ""
    var route: String = ""

    interface OnItemEventListener {
        /**
         * 点击item。
         */
        fun onBlockItemClick(item: HomeBlockItemVhModel)
    }
}

class HomeBlockItem1VhModel : HomeBlockItemVhModel() {

    override fun getViewType(): Int = R.layout.home_block_item_1

    override fun getSpanSize(): Int = SPAN_SIZE_FULL
}

class HomeBlockItem2VhModel : HomeBlockItemVhModel() {

    override fun getViewType(): Int = R.layout.home_block_item_2

    override fun getSpanSize(): Int = SPAN_SIZE_TRIPLE
}

class HomeBlockItem3VhModel : HomeBlockItemVhModel() {

    override fun getViewType(): Int = R.layout.home_block_item_3

    override fun getSpanSize(): Int = SPAN_SIZE_DOUBLE

}
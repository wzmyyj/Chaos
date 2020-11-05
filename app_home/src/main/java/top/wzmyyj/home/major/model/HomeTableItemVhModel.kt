package top.wzmyyj.home.major.model

import top.wzmyyj.home.R

/**
 * Created on 2020/10/23.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
class HomeTableItemVhModel : IHomeTableVhModelType {

    override fun getViewType(): Int = R.layout.home_table_item

    var title: String = ""
    var imageUrl: String = ""

    interface OnItemEventListener {
        /**
         * 点击item。
         */
        fun onTableItemClick(item: HomeTableItemVhModel)
    }

}
package top.wzmyyj.home.major.model

import top.wzmyyj.home.R

/**
 * Created on 2020/11/09.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
class HomeColumnItemVhModel : IHomeColumnVhModelType {

    override fun getViewType(): Int = R.layout.home_column_item

    var title: String = ""
    var desc: String = ""
    var imageUrl: String = ""
    var route: String = ""

    interface OnItemEventListener {
        /**
         * 点击item。
         */
        fun onColumnItemClick(item: HomeColumnItemVhModel)
    }
}
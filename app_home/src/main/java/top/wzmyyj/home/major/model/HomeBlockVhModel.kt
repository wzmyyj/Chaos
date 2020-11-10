package top.wzmyyj.home.major.model

import android.graphics.Color
import androidx.annotation.ColorInt
import top.wzmyyj.home.R

/**
 * Created on 2020/11/09.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
class HomeBlockVhModel : IHomeVhModelType {

    override fun getViewType(): Int = R.layout.home_block

    var title: String = ""
    var route: String = ""
    val itemList = ArrayList<IHomeBlockVhModelType>()

    @ColorInt
    var titleColor: Int = Color.BLACK

    interface OnItemEventListener {
        /**
         * 点击模块更多。
         */
        fun onBlockMoreClick(item: HomeBlockVhModel)
    }
}
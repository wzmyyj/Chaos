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
class HomeColumnVhModel : IHomeVhModelType {

    override fun getViewType(): Int = R.layout.home_column

    var title: String = ""
    var desc: String = ""
    var route: String = ""
    val itemList = ArrayList<IHomeColumnVhModelType>()

    @ColorInt
    var titleColor: Int = Color.BLACK

    interface OnItemEventListener {
        /**
         * 点击栏目更多。
         */
        fun onColumnMoreClick(item: HomeColumnVhModel)
    }
}
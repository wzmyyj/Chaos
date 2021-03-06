package top.wzmyyj.home.major.model

import top.wzmyyj.home.R

/**
 * Created on 2020/10/23.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
class HomeBannerVhModel : IHomeVhModelType {

    override fun getViewType(): Int = R.layout.home_banner

    val imageList = ArrayList<String>()
    val titleList = ArrayList<String>()
    val routeList = ArrayList<String>()

    interface OnItemEventListener {
        /**
         * 点击Banner的图片。
         */
        fun onBannerClick(item: HomeBannerVhModel, position: Int)
    }
}
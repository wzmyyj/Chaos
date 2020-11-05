package top.wzmyyj.home.major.model

import top.wzmyyj.home.R

/**
 * Created on 2020/10/23.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
class HomeTableVhModel : IHomeVhModelType {

    override fun getViewType(): Int = R.layout.home_table

    val itemList = ArrayList<IHomeTableVhModelType>()

}
package top.wzmyyj.home.major.vm

import android.app.Application
import androidx.lifecycle.MediatorLiveData
import top.wzmyyj.common.base.CBaseViewModel
import top.wzmyyj.common.utils.color
import top.wzmyyj.home.R
import top.wzmyyj.home.major.model.*

/**
 * Created on 2020/10/23.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
class HomeViewModel(app: Application) : CBaseViewModel(app) {

    val listLiveData = MediatorLiveData<List<IHomeVhModelType>>()

    /**
     * 初始化。
     */
    fun init() {
        listLiveData.postValue(
            listOf(
                getHomeBanner(),
                getHomeTable(),
                getBlock(0),
                getColumn(0),
                getBlock(1),
                getColumn(1),
                getColumn(2),
                getColumn(3),
                getColumn(4),
                getColumn(5),
                getColumn(6),
            )
        )
    }

    private fun getHomeBanner() = HomeBannerVhModel().apply {
        for (i in 0..5) {
            imageList.add("https://upload-images.jianshu.io/upload_images/3262738-1f1bcd714aa0813c.jpg")
            titleList.add("图片$i")
            routeList.add("路由:$i")
        }
    }

    private fun getHomeTable() = HomeTableVhModel().apply {
        for (i in 0..9) {
            itemList.add(HomeTableItemVhModel().apply {
                title = "Item$i"
                route = "route:$i"
            })
        }
    }

    private fun getColumn(p: Int) = HomeColumnVhModel().apply {
        title = "栏目标题$p"
        titleColor = R.color.color555555.color()
        route = "路由:$p"
        for (i in 0..9) {
            itemList.add(HomeColumnItemVhModel().apply {
                title = "标题$i"
                desc = "这是一条描述！"
                imageUrl =
                    "https://upload-images.jianshu.io/upload_images/3262738-d76ead23b82d23da.jpg"
                route = "路由:$p-$i"
            })
        }
    }

    private fun getBlock(p: Int) = HomeBlockVhModel().apply {
        title = "模块标题$p"
        titleColor = if (p < 1) R.color.colorOrange.color() else R.color.colorBlue.color()
        route = "路由:$p"
        fun getItem(i: Int) = if (i < 2) HomeBlockItem1VhModel() else HomeBlockItem2VhModel()
        for (i in 0..7) {
            itemList.add(getItem(i).apply {
                title = "标题$i"
                desc = "这是一条描述！"
                imageUrl =
                    "https://upload-images.jianshu.io/upload_images/3262738-d6311ba287710bd6.jpg"
                route = "路由:$p-$i"
            })
        }
    }
}
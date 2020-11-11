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
                getBlock(0, 5),
                getColumn(0),
                getBlock(1, 4),
                getColumn(1),
                getBlock(2, 6),
                getColumn(2),
                getBlock(3, 3),
                getColumn(3),
                getBlock(4, 7),
                getColumn(4),
                getBlock(5, 8),
                getColumn(5),
                getBlock(6, 4),
                getColumn(6)
            )
//            list()
        )
    }

    private fun list() = ArrayList<IHomeVhModelType>().apply {
        for (i in 0..100) {
            add(getColumn(i))
        }
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

    private fun getBlock(p: Int, size: Int) = HomeBlockVhModel().apply {
        title = "模块标题$p"
        route = "路由:$p"
        fun HomeBlockItemVhModel.init(i: Int): HomeBlockItemVhModel {
            title = "标题$i"
            desc = "这是一条描述！"
            imageUrl =
                "https://upload-images.jianshu.io/upload_images/3262738-d6311ba287710bd6.jpg"
            route = "路由:$p-$i"
            return this
        }
        when (size) {
            3 -> {
                itemList.add(HomeBlockItem1VhModel().init(0))
                itemList.add(HomeBlockItem2VhModel().init(1))
                itemList.add(HomeBlockItem2VhModel().init(2))
                titleColor = R.color.colorBlue.color()
                rvHeightPt = 200 + 125
            }
            4 -> {
                itemList.add(HomeBlockItem1VhModel().init(0))
                itemList.add(HomeBlockItem3VhModel().init(1))
                itemList.add(HomeBlockItem3VhModel().init(2))
                itemList.add(HomeBlockItem3VhModel().init(3))
                titleColor = R.color.colorSky.color()
                rvHeightPt = 200 + 165
            }
            5 -> {
                itemList.add(HomeBlockItem2VhModel().init(0))
                itemList.add(HomeBlockItem2VhModel().init(1))
                itemList.add(HomeBlockItem3VhModel().init(2))
                itemList.add(HomeBlockItem3VhModel().init(3))
                itemList.add(HomeBlockItem3VhModel().init(4))
                titleColor = R.color.colorOrange.color()
                rvHeightPt = 125 + 165
            }
            6 -> {
                itemList.add(HomeBlockItem1VhModel().init(0))
                itemList.add(HomeBlockItem2VhModel().init(1))
                itemList.add(HomeBlockItem2VhModel().init(2))
                itemList.add(HomeBlockItem3VhModel().init(3))
                itemList.add(HomeBlockItem3VhModel().init(4))
                itemList.add(HomeBlockItem3VhModel().init(5))
                titleColor = R.color.colorGolden.color()
                rvHeightPt = 200 + 125 + 165
            }
            7 -> {
                itemList.add(HomeBlockItem1VhModel().init(0))
                itemList.add(HomeBlockItem3VhModel().init(1))
                itemList.add(HomeBlockItem3VhModel().init(2))
                itemList.add(HomeBlockItem3VhModel().init(3))
                itemList.add(HomeBlockItem3VhModel().init(4))
                itemList.add(HomeBlockItem3VhModel().init(5))
                itemList.add(HomeBlockItem3VhModel().init(6))
                titleColor = R.color.colorPurple.color()
                rvHeightPt = 200 + 165 + 165
            }
            8 -> {
                itemList.add(HomeBlockItem2VhModel().init(0))
                itemList.add(HomeBlockItem2VhModel().init(1))
                itemList.add(HomeBlockItem3VhModel().init(2))
                itemList.add(HomeBlockItem3VhModel().init(3))
                itemList.add(HomeBlockItem3VhModel().init(4))
                itemList.add(HomeBlockItem3VhModel().init(5))
                itemList.add(HomeBlockItem3VhModel().init(6))
                itemList.add(HomeBlockItem3VhModel().init(7))
                titleColor = R.color.colorCopper.color()
                rvHeightPt = 125 + 165 + 165
            }
        }
    }
}
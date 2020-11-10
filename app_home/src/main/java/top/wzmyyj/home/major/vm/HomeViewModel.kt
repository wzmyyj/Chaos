package top.wzmyyj.home.major.vm

import android.app.Application
import androidx.lifecycle.MediatorLiveData
import top.wzmyyj.common.base.CBaseViewModel
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
            imageList.add("https://upload-images.jianshu.io/upload_images/3262738-0a5b030907019fd8.jpg")
            titleList.add("图片$i")
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
        title = "大标题$p"
        route = "route:$p"
        for (i in 0..9) {
            itemList.add(HomeColumnItemVhModel().apply {
                title = "标题$i"
                desc = "这是一条描述！"
                imageUrl =
                    "https://upload-images.jianshu.io/upload_images/3262738-48ae02c873fb4c85.jpg"
                route = "route:$p:$i"
            })
        }
    }
}
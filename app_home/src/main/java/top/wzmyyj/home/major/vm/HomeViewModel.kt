package top.wzmyyj.home.major.vm

import android.app.Application
import androidx.lifecycle.MediatorLiveData
import top.wzmyyj.common.base.CBaseViewModel
import top.wzmyyj.home.major.model.HomeBannerVhModel
import top.wzmyyj.home.major.model.HomeTableItemVhModel
import top.wzmyyj.home.major.model.HomeTableVhModel
import top.wzmyyj.home.major.model.IHomeVhModelType

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
        listLiveData.postValue(listOf(getHomeBanner(), getHomeTable()))
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
            })
        }
    }
}
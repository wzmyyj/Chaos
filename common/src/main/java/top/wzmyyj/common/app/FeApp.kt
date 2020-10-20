package top.wzmyyj.common.app

import android.app.Application
import android.content.res.Resources
import top.wzmyyj.common.BuildConfig
import top.wzmyyj.common.weight.SmartRefreshHelper
import top.wzmyyj.utils.display.AdaptScreenUtil
import top.wzmyyj.utils.tools.LogUtil
import top.wzmyyj.utils.tools.ToastUtil

/**
 * Created on 2019/11/19.
 *
 * @author feling
 * @version 1.1.0
 * @since 1.1.0
 */
open class FeApp : Application() {

    companion object {
        private lateinit var app: FeApp
        val context: Application get() = app
        fun get() = app
    }

    override fun onCreate() {
        super.onCreate()
        app = this
        ToastUtil.init(this)
        LogUtil.init("feling", BuildConfig.DEBUG)
        SmartRefreshHelper.init()
    }

    override fun getResources(): Resources {
        return AdaptScreenUtil.adaptWidth(super.getResources(), 375)
    }

}
package top.wzmyyj.common.app

import android.app.Application
import top.wzmyyj.common.BuildConfig
import top.wzmyyj.utils.tools.LogUtil
import top.wzmyyj.utils.tools.ToastUtil

/**
 * Created on 2019/11/19.
 *
 * @author feling
 * @version 1.1.0
 * @since 1.1.0
 */
abstract class CBaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        ToastUtil.init(this)
        LogUtil.init("feling", BuildConfig.DEBUG)
    }

}
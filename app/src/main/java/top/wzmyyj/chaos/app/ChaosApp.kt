package top.wzmyyj.chaos.app

import com.alibaba.android.arouter.launcher.ARouter
import top.wzmyyj.common.app.FeApp

/**
 * Created on 2020/10/15.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
class ChaosApp : FeApp() {

    override fun onCreate() {
        super.onCreate()
        ARouter.init(this)
    }
}
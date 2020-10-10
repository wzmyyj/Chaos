import com.android.tools.r8.utils.H

/**
 * Created on 2020/09/19.
 *
 * Config Project.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */

object AppConfig {
    const val applicationIdPre = "top.wzmyyj."
    const val versionName = "1.0.0"
}

object AndroidConfig {
    const val compileSdkVersion = 30
    const val minSdkVersion = 21
    const val targetSdkVersion = 30
    const val buildToolsVersion = "30.0.2"
}

enum class Module(val tag: String, val runAlone: Boolean){
    App("app",true),
    Common("common",false),
    CommonService("common_service",false),
    Active("active",false)
}

object MiniProgramType {
    const val daily = 1
    const val gray = 1
    const val online = 0
}




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

object MiniProgramType {
    const val daily = 1
    const val gray = 1
    const val online = 0
}

enum class Module(val tag: String, val runAlone: Boolean){
    Common("common",false),
    CommonService("common_service",false),
    Login("login",false),
    Main("main",false),
    Home("home",false),
    Active("active",false),
    Message("message",false),
    Mine("mine",false),
    App("chaos",true)
}



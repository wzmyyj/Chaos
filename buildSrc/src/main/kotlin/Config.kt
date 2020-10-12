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

object Android {
    const val application = "com.android.application"
    const val library = "com.android.library"
}

enum class Module(val tag: String, val runAlone: Boolean) {
    Common("common", false),
    CommonService("common_service", false),
    Login("login", false),
    Main("main", false),
    Home("home", false),
    Active("active", false),
    Message("message", false),
    Mine("mine", false),
    App("chaos", true)
}


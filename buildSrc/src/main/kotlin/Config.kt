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

enum class Module(val tag: String, val path: String, val runAlone: Boolean) {
    App(
        tag = "app",
        path = ":app",
        runAlone = true
    ),
    Common(
        tag = "common",
        path = ":common",
        runAlone = false
    ),
    CommonService(
        tag = "common_service",
        path = ":common_service",
        runAlone = false
    ),
    Login(
        tag = "login",
        path = ":app_login",
        runAlone = false
    ),
    Main(
        tag = "main",
        path = ":app_main",
        runAlone = false
    ),
    Home(
        tag = "home",
        path = ":app_home",
        runAlone = false
    ),
    Category(
        tag = "category",
        path = ":app_category",
        runAlone = false
    ),
    Track(
        tag = "track",
        path = ":app_track",
        runAlone = false
    ),
    Message(
        tag = "message",
        path = ":app_message",
        runAlone = false
    ),
    Mine(
        tag = "mine",
        path = ":app_mine",
        runAlone = false
    )
}


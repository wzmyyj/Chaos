@file:Suppress("MayBeConstant")

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
    val applicationIdPre = "top.wzmyyj."
    const val versionName = "1.0.0"
}

object AndroidConfig {
    val compileSdkVersion = 30
    val minSdkVersion = 21
    val targetSdkVersion = 30
    val buildToolsVersion = "30.0.2"
}

object ApiHost {
    val daily = "http://daily.webuy.ai"
    val gray = "http://gray.webuy.ai"
    val online = "https://app.webuy.ai"
}

object H5Host {
    val daily = "https://h5.shuaibao.info"
    val gray = "https://h5.shuaibao.info"
    val online = "https://h5.shuaibao.info"
}

object UMengAppKey {
    val daily = "5f043178570df33d7e0000b8"
    val gray = "5f043178570df33d7e0000b8"
    val online = "5f042bad895ccae26900014c"
}

object UmengMessageSecret {
    val daily = "852bd6d5247711e75cf361a12230c50f"
    val gray = "852bd6d5247711e75cf361a12230c50f"
    val online = "a3f11bf160ec7f8cda8c5a74d3047c72"
}

object MiniProgramType {
    val daily = 1
    val gray = 1
    val online = 0
}


object RunAlone {
    val login = false
    val usercenter = false
    val main = false
    val web = false
    val share = false
    val fans = false
    val exhibition = false
    val address = false
    val order = false
    val home = false
    val shoppingCart = false
}

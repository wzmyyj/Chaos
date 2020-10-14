package top.wzmyyj.common_service

import androidx.annotation.StringDef

/**
 * Created on 2019/10/22.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
@StringDef(
    ActivityPath.LOGIN,
    ActivityPath.MAIN,
    ActivityPath.HOME,
    ActivityPath.CATEGORY,
    ActivityPath.TRACK,
    ActivityPath.MESSAGE,
    ActivityPath.MINE
)
annotation class ActivityPath {
    companion object {
        const val LOGIN = "/login/activity"

        const val MAIN = "/main/activity"

        const val HOME = "/home/activity"

        const val CATEGORY = "/category/activity"

        const val TRACK = "/track/activity"

        const val MESSAGE = "/message/activity"

        const val MINE = "/mine/activity"

        fun isIn(path: String): Boolean {
            return path == LOGIN
                    || path == MAIN
                    || path == HOME
                    || path == CATEGORY
                    || path == TRACK
                    || path == MESSAGE
        }
    }
}

@StringDef(
    ServicePath.HOME,
    ServicePath.CATEGORY,
    ServicePath.TRACK,
    ServicePath.MESSAGE,
    ServicePath.MINE
)
annotation class ServicePath {
    companion object {
        const val HOME = "/home/service"

        const val CATEGORY = "/category/service"

        const val TRACK = "/track/service"

        const val MESSAGE = "/message/service"

        const val MINE = "/mine/service"
    }
}

package top.wzmyyj.common_service

import android.content.Intent
import android.os.Bundle
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.launcher.ARouter

/**
 * Created on 2019/10/23.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
object RouterManager {

    private const val TARGET = "target"
    private const val PARAMS = "params"
    private const val FROM_PAGE = "from_page"

    /**
     * Get the from_page field.
     */
    fun getFromPageString(intent: Intent?): String? {
        if (intent == null) {
            return null
        }
        return intent.getStringExtra(FROM_PAGE)
    }

    /**
     * Get the target field.
     */
    fun getTargetString(intent: Intent?): String? {
        if (intent == null) {
            return null
        }
        return intent.getStringExtra(TARGET)
    }

    /**
     * Get the params field.
     */
    fun getParamsString(intent: Intent?): Bundle? {
        if (intent == null) {
            return null
        }
        return intent.getBundleExtra(PARAMS)
    }

    /**
     * Unified format Postcard.
     */
    private fun postcard(
        @ActivityPath path: String, target:
        String, params: Bundle?, fromPage: String
    ): Postcard {
        return ARouter.getInstance().build(path)
            .withString(FROM_PAGE, fromPage)
            .withString(TARGET, target)
            .withBundle(PARAMS, params)
    }

    /**
     * Get service by class.
     */
    fun <T> getService(service: Class<out T>): T? {
        return ARouter.getInstance().navigation(service)
    }

    /**
     * Go page by path with params.
     */
    fun goPage(path: String, target: String, params: Bundle?, fromPage: String) {
        if (!ActivityPath.isIn(path)) return
        postcard(path, target, params, fromPage)
            .navigation()
    }

    /**
     * Go main page.
     */
    fun goMain(fromPage: String) {
        postcard(ActivityPath.MAIN, "", null, fromPage)
            .navigation()
    }

}
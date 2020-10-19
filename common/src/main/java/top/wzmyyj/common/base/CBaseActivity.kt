package top.wzmyyj.common.base

import android.content.res.Resources
import top.wzmyyj.base.app.BaseActivity
import top.wzmyyj.utils.display.AdaptScreenUtil

/**
 * Created on 2019/09/29.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
open class CBaseActivity : BaseActivity() {

    override fun getResources(): Resources {
        return AdaptScreenUtil.adaptWidth(super.getResources(),375)
    }
}
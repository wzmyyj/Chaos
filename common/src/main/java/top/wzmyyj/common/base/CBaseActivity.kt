package top.wzmyyj.common.base

import android.content.res.Resources
import android.os.Bundle
import top.wzmyyj.base.app.BaseActivity
import top.wzmyyj.utils.display.AdaptScreenUtil
import top.wzmyyj.utils.display.StatusBarUtil

/**
 * Created on 2019/09/29.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
open class CBaseActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StatusBarUtil.immersiveBar(this, true)
        StatusBarUtil.transparentBg(this)
        StatusBarUtil.blackText(this)
    }

    override fun getResources(): Resources {
        return AdaptScreenUtil.adaptWidth(super.getResources(), 375)
    }
}
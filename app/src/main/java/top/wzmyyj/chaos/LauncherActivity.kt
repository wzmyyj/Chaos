package top.wzmyyj.chaos

import android.os.Bundle
import top.wzmyyj.common.base.CBaseActivity
import top.wzmyyj.common_service.RouterManager

class LauncherActivity : CBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_activity_launcher)
        RouterManager.goMain("L")
        finish()
    }
}
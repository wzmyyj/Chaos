package top.wzmyyj.chaos

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import top.wzmyyj.common.base.CBaseActivity
import top.wzmyyj.common_service.RouterManager

class LauncherActivity : CBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_activity_launcher)
        handler.postDelayed({
            RouterManager.goMain("L")
            finish()
        }, 1000)
    }


    override fun onDestroy() {
        super.onDestroy()
        handler.removeMessages(0)
    }
    private val handler = Handler(Looper.getMainLooper())

}
package top.wzmyyj.chaos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import top.wzmyyj.common_service.RouterManager

class LauncherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_activity_launcher)
        RouterManager.goMain("L")
        finish()
    }
}
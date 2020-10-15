package top.wzmyyj.chaos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import top.wzmyyj.common_service.RouterManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        RouterManager.goMain("L")
        finish()
    }
}
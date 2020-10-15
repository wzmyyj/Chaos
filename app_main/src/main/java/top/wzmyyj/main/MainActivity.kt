package top.wzmyyj.main

import android.os.Bundle
import android.os.PersistableBundle
import com.alibaba.android.arouter.facade.annotation.Route
import top.wzmyyj.common.app.CBaseActivity
import top.wzmyyj.common.utils.replaceFragment
import top.wzmyyj.common_service.ActivityPath
import top.wzmyyj.main.ui.MainFragment

/**
 * Created on 2020/10/14.
 *
 * Main Activity.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
@Route(path = ActivityPath.MAIN, name = "Main")
class MainActivity : CBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        replaceFragment(R.id.fl_container, MainFragment.newInstance())
    }
}
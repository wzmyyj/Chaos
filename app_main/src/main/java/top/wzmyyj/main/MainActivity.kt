package top.wzmyyj.main

import android.os.Bundle
import android.os.PersistableBundle
import top.wzmyyj.common.app.CBaseActivity
import top.wzmyyj.common.utils.replaceFragment
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
class MainActivity : CBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.main_activity)
        replaceFragment(R.id.fl_container, MainFragment.newInstance())
    }
}
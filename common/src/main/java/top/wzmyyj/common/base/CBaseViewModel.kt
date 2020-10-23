package top.wzmyyj.common.base

import android.app.Application
import androidx.lifecycle.DefaultLifecycleObserver
import top.wzmyyj.base.lifecycle.BaseViewModel

/**
 * Created on 2019/09/30.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
open class CBaseViewModel(application: Application) :
    BaseViewModel(application), DefaultLifecycleObserver {

}
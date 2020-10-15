package top.wzmyyj.home.service

import android.content.Context
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import top.wzmyyj.common_service.ServicePath
import top.wzmyyj.common_service.home.IHomeService
import top.wzmyyj.home.major.ui.HomeFragment

/**
 * Created on 2020/10/15.
 *
 * Home service impl.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
@Route(path = ServicePath.HOME)
class HomeServiceImpl : IHomeService {

    override fun init(context: Context?) {
    }

    override fun getFragment(): Fragment {
        return HomeFragment.newInstance()
    }

}
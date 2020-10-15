package top.wzmyyj.mine.service

import android.content.Context
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import top.wzmyyj.common_service.ServicePath
import top.wzmyyj.common_service.mine.IMineService
import top.wzmyyj.mine.major.ui.MineFragment

/**
 * Created on 2020/10/15.
 *
 * Mine service impl.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
@Route(path = ServicePath.MINE)
class MineServiceImpl : IMineService {

    override fun init(context: Context?) {
    }

    override fun getFragment(): Fragment {
        return MineFragment.newInstance()
    }

}
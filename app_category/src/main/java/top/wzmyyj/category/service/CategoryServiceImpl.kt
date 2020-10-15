package top.wzmyyj.category.service

import android.content.Context
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import top.wzmyyj.common_service.ServicePath
import top.wzmyyj.common_service.category.ICategoryService
import top.wzmyyj.category.major.ui.CategoryFragment

/**
 * Created on 2020/10/15.
 *
 * Home service impl.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
@Route(path = ServicePath.CATEGORY)
class CategoryServiceImpl : ICategoryService {

    override fun init(context: Context?) {
    }

    override fun getFragment(): Fragment {
        return CategoryFragment.newInstance()
    }

}
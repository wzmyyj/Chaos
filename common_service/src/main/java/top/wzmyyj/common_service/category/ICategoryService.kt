package top.wzmyyj.common_service.category

import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.template.IProvider

/**
 * Created on 2019/10/22.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
interface ICategoryService : IProvider {

    fun getFragment(): Fragment
}
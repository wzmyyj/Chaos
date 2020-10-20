package top.wzmyyj.common.weight

import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.scwang.smartrefresh.layout.footer.ClassicsFooter
import com.scwang.smartrefresh.layout.header.ClassicsHeader
import top.wzmyyj.common.R
import top.wzmyyj.common.utils.string

/**
 * Created on 2020/10/19.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
object SmartRefreshHelper {

    /**
     *  Init RefreshLayout.
     */
    fun init() {
        ClassicsHeader.REFRESH_HEADER_RELEASE = R.string.common_smart_refresh_head_release.string()
        ClassicsHeader.REFRESH_HEADER_LOADING = R.string.common_smart_refresh_loading.string()
        ClassicsFooter.REFRESH_FOOTER_ALLLOADED = R.string.common_smart_no_more.string()
        // Set up global header builder.
        SmartRefreshLayout.setDefaultRefreshHeaderCreator { context, _ ->
            ClassicsHeader(context).setDrawableSize(20f)
        }
        // Set up global footer builder.
        SmartRefreshLayout.setDefaultRefreshFooterCreator { context, _ ->
            ClassicsFooter(context).setDrawableSize(20f)
        }
    }
}
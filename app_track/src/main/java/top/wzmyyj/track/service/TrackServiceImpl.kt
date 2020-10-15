package top.wzmyyj.track.service

import android.content.Context
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import top.wzmyyj.common_service.ServicePath
import top.wzmyyj.common_service.track.ITrackService
import top.wzmyyj.track.major.ui.TrackFragment

/**
 * Created on 2020/10/15.
 *
 * Track service impl.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
@Route(path = ServicePath.TRACK)
class TrackServiceImpl : ITrackService {

    override fun init(context: Context?) {
    }

    override fun getFragment(): Fragment {
        return TrackFragment.newInstance()
    }

}
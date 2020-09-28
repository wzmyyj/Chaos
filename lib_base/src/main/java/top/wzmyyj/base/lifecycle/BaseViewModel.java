package top.wzmyyj.base.lifecycle;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

/**
 * Created on 2019/09/29.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
public class BaseViewModel extends AndroidViewModel {

    public BaseViewModel(@NonNull Application application) {
        super(application);
    }
}

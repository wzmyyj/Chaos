package top.wzmyyj.utils.pm;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

/**
 * Created on 2019/08/17.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
public final class PackageUtil {

    private static final String TAG = PackageUtil.class.getSimpleName();


    private PackageUtil() {
        throw new UnsupportedOperationException(TAG + "you can't instantiate me.");
    }

    /**
     * for debug.
     */
    public static boolean DEBUG = false;

    /**
     * 获取应用版本号名称。
     *
     * @param context .
     * @return 应用版本号名称(String)
     */
    @Nullable
    public static String getVersionName(@NonNull Context context) {
        PackageInfo info = getPackageInfo(context);
        return info == null ? null : info.versionName;
    }

    /**
     * 获取应用版本号。
     *
     * @param context .
     * @return 应用版本号(long)
     */
    public static long getVersionCode(@NonNull Context context) {
        PackageInfo info = getPackageInfo(context);
        if (info != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                return info.getLongVersionCode();
            } else {
                return info.versionCode;
            }
        }
        return 0L;
    }


    /**
     * 获取应用包名。
     *
     * @param context .
     * @return 应用包名(String)
     */
    @Nullable
    public static String getPackageName(@NonNull Context context) {
        PackageInfo info = getPackageInfo(context);
        return info == null ? null : info.packageName;
    }

    /**
     * 获取包名Info。
     *
     * @param context context
     * @return PackageInfo
     */
    @Nullable
    public static PackageInfo getPackageInfo(@NonNull Context context) {
        PackageManager pManager = context.getPackageManager();
        try {
            return pManager.getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            if (DEBUG) {
                Log.d(TAG, "method getPackageInfo has exception");
                e.printStackTrace();
            }
        }

        return null;
    }

    /**
     * 判断指定包名的应用是否在手机上安装。
     *
     * @param context     .
     * @param packageName 包名。
     * @return apk is exist
     */
    public static boolean checkApkExist(@NonNull Context context, @NonNull String packageName) {
        PackageManager packageManager = context.getPackageManager();
        List<PackageInfo> packageInfoList = packageManager.getInstalledPackages(0);
        for (int i = 0; i < packageInfoList.size(); ++i) {
            String pn = packageInfoList.get(i).packageName;
            if (pn.equals(packageName)) {
                if (DEBUG) {
                    Log.d(TAG, packageName + "is exist");
                }
                return true;
            }
        }
        if (DEBUG) {
            Log.d(TAG, packageName + "is not exist");
        }
        return false;
    }
}
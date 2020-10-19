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
 * <p>
 * Package information related Util.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
@SuppressWarnings("unused")
public final class PackageUtil {

    private static final String TAG = PackageUtil.class.getSimpleName();

    private PackageUtil() {
        throw new UnsupportedOperationException(TAG + ": You can't instantiate me.");
    }

    /**
     * For debug.
     */
    public static boolean DEBUG = false;

    /**
     * Get the app version name.
     *
     * @param context context
     * @return versionName
     */
    @Nullable
    public static String getVersionName(@NonNull Context context) {
        PackageInfo info = getPackageInfo(context);
        return info == null ? null : info.versionName;
    }

    /**
     * Get the app version code.
     *
     * @param context context
     * @return versionCode
     */
    public static long getVersionCode(@NonNull Context context) {
        PackageInfo info = getPackageInfo(context);
        if (info != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                return info.getLongVersionCode();
            } else {
                //noinspection deprecation
                return info.versionCode;
            }
        }
        return 0L;
    }

    /**
     * Get the app package name.
     *
     * @param context context
     * @return packageName
     */
    @Nullable
    public static String getPackageName(@NonNull Context context) {
        PackageInfo info = getPackageInfo(context);
        return info == null ? null : info.packageName;
    }

    /**
     * Get the app package info.
     *
     * @param context context
     * @return packageInfo
     */
    @Nullable
    public static PackageInfo getPackageInfo(@NonNull Context context) {
        PackageManager pManager = context.getPackageManager();
        try {
            return pManager.getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            if (DEBUG) {
                Log.d(TAG, "Method getPackageInfo has exception!");
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * Determine whether the app with the specified package name is installed on the mobile phone.
     *
     * @param context     context
     * @param packageName packageName
     * @return apk is exist?
     */
    public static boolean checkApkExist(@NonNull Context context, @NonNull String packageName) {
        PackageManager packageManager = context.getPackageManager();
        List<PackageInfo> packageInfoList = packageManager.getInstalledPackages(0);
        for (int i = 0; i < packageInfoList.size(); ++i) {
            String pn = packageInfoList.get(i).packageName;
            if (pn.equals(packageName)) {
                if (DEBUG) {
                    Log.d(TAG, packageName + "is exist!");
                }
                return true;
            }
        }
        if (DEBUG) {
            Log.d(TAG, packageName + "is not exist!");
        }
        return false;
    }

}
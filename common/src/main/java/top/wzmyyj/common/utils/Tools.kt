package top.wzmyyj.common.utils

import top.wzmyyj.utils.tools.LogUtil
import top.wzmyyj.utils.tools.ToastUtil

/**
 * Created on 2020/11/05.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
fun toast(msg: String?) {
    ToastUtil.show(msg)
}

fun debugToast(msg: String?) {
    ToastUtil.debugShow(msg)
}

fun log(msg: String?) {
    LogUtil.d(msg)
}

fun log(tag: String, msg: String?) {
    LogUtil.d(tag, msg)
}
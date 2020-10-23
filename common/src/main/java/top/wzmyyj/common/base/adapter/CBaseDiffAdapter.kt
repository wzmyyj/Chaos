package top.wzmyyj.common.base.adapter

import top.wzmyyj.adapter.diff.DiffListAdapter
import top.wzmyyj.adapter.diff.IDiffVhModelType

/**
 * Created on 2020/10/22.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
abstract class CBaseDiffAdapter<T:IDiffVhModelType>(callback: DiffCallBack<T> = DiffCallBack())
    : DiffListAdapter<T>(callback)
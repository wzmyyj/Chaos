package top.wzmyyj.common.helper

import android.view.Choreographer
import top.wzmyyj.utils.tools.LogUtil


/**
 * Created on 2020/11/11.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
object ChoreographerHelper {

    /**
     * Debug.
     */
    var DEBUG = true

    /**
     * Start Choreographer.
     */
    fun start() {
        if (DEBUG) Choreographer.getInstance().postFrameCallback(frameCallback)
    }

    /**
     * Stop Choreographer.
     */
    fun stop() {
        Choreographer.getInstance().removeFrameCallback(frameCallback)
    }

    private const val TAG = "性能检测"

    private val frameCallback = MyFrameCallback()

    private class MyFrameCallback : Choreographer.FrameCallback {

        private var lastTime: Long = 0
        override fun doFrame(frameTimeNanos: Long) {
            lastTime = if (lastTime == 0L) {
                // first use.
                frameTimeNanos
            } else {
                val times = (frameTimeNanos - lastTime) / 1000000
                val frames = (times / 16).toInt()
                if (times > 16) {
                    LogUtil.w(TAG, "UI线程超时(超过16ms):" + times + "ms" + " , 丢帧:" + frames)
                }
                frameTimeNanos
            }
            Choreographer.getInstance().postFrameCallback(frameCallback)
        }
    }
}
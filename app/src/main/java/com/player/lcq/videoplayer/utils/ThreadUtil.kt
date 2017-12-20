package com.player.lcq.videoplayer.utils

import android.os.Handler
import android.os.Looper


/**
 * ClassName:ThreadUtil
 * Description:线程工具类
 */
object ThreadUtil {
    val handler = Handler(Looper.getMainLooper());
    /**
     * 运行在主线程中
     */
    fun runOnMainThread(runnable: Runnable) {
        handler.post(runnable)
    }

}
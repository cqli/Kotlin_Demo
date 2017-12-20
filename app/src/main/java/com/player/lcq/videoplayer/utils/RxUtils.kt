package com.player.lcq.videoplayer.utils

import io.reactivex.disposables.Disposable

/**
 * Created by lcq on 2017/12/15.
 * 释放当前请求
 */
object RxUtils {
    fun dispose(disposable: Disposable?) {
        if (disposable != null && !disposable.isDisposed) {
            disposable.dispose()
        }
    }
}
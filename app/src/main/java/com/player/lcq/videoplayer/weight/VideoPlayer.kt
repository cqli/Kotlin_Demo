package com.player.lcq.videoplayer.weight

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import cn.jzvd.JZVideoPlayer
import cn.jzvd.JZVideoPlayerStandard

/**
 * Created by lcq on 2018/1/5.
 * 视频播放器
 */
class VideoPlayer : JZVideoPlayerStandard {
    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)


    override fun init(context: Context) {
        super.init(context)
    }

    override fun onClick(v: View) {
        super.onClick(v)
        val i = v.id
        if (i == cn.jzvd.R.id.fullscreen) {
            if (currentScreen == JZVideoPlayer.SCREEN_WINDOW_FULLSCREEN) {
                //click quit fullscreen
            } else {
                //click goto fullscreen
            }
        }
    }

    override fun onTouch(v: View, event: MotionEvent): Boolean {
        return super.onTouch(v, event)
    }

    override fun startVideo() {
        super.startVideo()
    }

    override fun onStateNormal() {
        super.onStateNormal()
    }

    override fun onStatePreparing() {
        super.onStatePreparing()
    }

    override fun onStatePlaying() {
        super.onStatePlaying()
    }

    override fun onStatePause() {
        super.onStatePause()
    }

    override fun onStateError() {
        super.onStateError()
    }

    override fun onStateAutoComplete() {
        super.onStateAutoComplete()
    }

}

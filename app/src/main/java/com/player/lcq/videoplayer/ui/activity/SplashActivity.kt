package com.player.lcq.videoplayer.ui.activity

import android.os.Build
import android.support.v4.view.ViewCompat
import android.support.v4.view.ViewPropertyAnimatorListener
import android.view.View
import android.view.Window
import android.view.WindowManager
import com.player.lcq.videoplayer.R
import com.player.lcq.videoplayer.base.BaseActivity
import kotlinx.android.synthetic.main.activity_splash.*

/**
 * Created by lcq on 2017/11/22.
 *  欢迎界面
 */
class SplashActivity : BaseActivity(), ViewPropertyAnimatorListener {
    override fun onAnimationCancel(view: View?) {
    }

    override fun onAnimationStart(view: View?) {
    }

    override fun onAnimationEnd(view: View?) {
        startActivityAndFinish<MainActivity>()
    }

    override fun getLayoutId(): Int {
        /*set it to be no title*/
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        /*set it to be full screen*/
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        return R.layout.activity_splash
    }

    override fun initData() {
        ViewCompat.animate(iv_splash).scaleX(1.0f).scaleY(1.0f).setListener(this).setDuration(2000)
    }
}
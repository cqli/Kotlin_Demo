package com.player.lcq.videoplayer.ui.activity

import android.support.v7.widget.Toolbar
import com.jakewharton.rxbinding2.view.RxView
import com.player.lcq.videoplayer.R
import com.player.lcq.videoplayer.base.BaseActivity
import com.player.lcq.videoplayer.utils.ToolBarManager
import kotlinx.android.synthetic.main.activity_about.*
import org.jetbrains.anko.find
import java.util.concurrent.TimeUnit

/**
 * Created by lcq on 2017/12/5.
 * 关于界面
 */
class AboutActivity : BaseActivity(), ToolBarManager {
    override val toolbar: Toolbar by lazy { find<Toolbar>(R.id.toolbar) }


    override fun getLayoutId(): Int {
        return R.layout.activity_about
    }


    override fun initData() {
        initAboutToolBar()
        RxView.clicks(app_des)
                .throttleFirst(3000, TimeUnit.MICROSECONDS)
                .subscribe {
                    myToast("3秒内只点击一次")
                }
    }
}
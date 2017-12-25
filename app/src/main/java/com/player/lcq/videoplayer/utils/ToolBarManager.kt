package com.player.lcq.videoplayer.utils

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.widget.Toolbar
import com.player.lcq.videoplayer.R
import com.player.lcq.videoplayer.ui.activity.SettingActivity
import org.jetbrains.anko.toast

/**
 * Created by lcq on 2017/11/23.
 * ToolBarMananger
 */
interface ToolBarManager {
    val toolbar: Toolbar
    /**
     * 初始化主界面中的toolbar
     */
    fun initMainToolBar() {
        toolbar.setTitle("影音播放")
        toolbar.inflateMenu(R.menu.main)
        //kotlin 和java调用特性
        //如果java接口中只有一个未实现的方法  可以省略接口对象 直接用{}表示未实现的方法
        toolbar.setOnMenuItemClickListener {
            day_night()
            true
        }
//        toolbar.setOnMenuItemClickListener(object : Toolbar.OnMenuItemClickListener {
//            override fun onMenuItemClick(item: MenuItem?): Boolean {
//                when (item?.itemId) {
//                    R.id.setting -> {
//                        //跳转到设置界面
//                        toolbar.context.startActivity(Intent(toolbar.context, SettingActivity::class.java))
//                    }
//                }
//                return true
//            }
//
//        })

    }

    /**
     * 模式切换
     */
    fun day_night();

    /**
     * 处理设置界面的toolbar
     */
    fun initSettingToolbar() {
        toolbar.setTitle("设置界面")
    }

    fun initAboutToolBar() {
        toolbar.setTitle("关于界面")
    }

}
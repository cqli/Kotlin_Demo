package com.player.lcq.videoplayer.base

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.player.lcq.videoplayer.R
import com.player.lcq.videoplayer.utils.SharedPreferencesUtil
import com.ypy.eventbus.EventBus
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

/**
 * Created by lcq on 2017/11/22.
 *
 * 所有activiyt 基类
 */
abstract class BaseActivity : AppCompatActivity(), AnkoLogger {
    var sp: SharedPreferencesUtil? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sp = SharedPreferencesUtil.getInstance(applicationContext, "mode", Context.MODE_APPEND)
        val value = sp?.getIntValue("day_night", 0)
        if (value == 0) {//白天
            setTheme(R.style.MarioTheme_Day)
        } else {//夜间
            setTheme(R.style.MarioTheme_Night)
        }
        setContentView(getLayoutId())
        initListener()
        initData()
    }

    /**
     * 数据初始化操作
     */
    open protected fun initData() {

    }

    /**
     * adapter listener 相关操作
     */
    open protected fun initListener() {

    }

    /**
     * 获取布局id
     */
    abstract fun getLayoutId(): Int

    fun myToast(msg: String) {
        runOnUiThread {
            toast(msg)
        }
    }

    /**
     * 开启Activity并且关闭当前界面
     */
    inline fun <reified T : BaseActivity> startActivityAndFinish() {
        startActivity<T>()
        finish()
    }
}
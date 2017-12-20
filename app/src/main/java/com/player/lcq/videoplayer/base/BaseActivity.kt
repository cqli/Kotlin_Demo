package com.player.lcq.videoplayer.base

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

/**
 * Created by lcq on 2017/11/22.
 *
 * 所有activiyt 基类
 */
abstract class BaseActivity : AppCompatActivity(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
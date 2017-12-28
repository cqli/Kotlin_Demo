package com.player.lcq.videoplayer.base

import android.annotation.TargetApi
import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import com.player.lcq.videoplayer.R
import com.player.lcq.videoplayer.utils.SharedPreferencesUtil
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
        sp = SharedPreferencesUtil.getInstance(baseContext)
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

    fun swich_day_night() {
        if (sp?.getIntValue("day_night", 0) == 0) {
            sp?.setValue("day_night", 1)
        } else {
            sp?.setValue("day_night", 0)
        }
        recreate()
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

    /**
     * 使状态栏透明
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    private fun transparentStatusBar(activity: Activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            activity.window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            activity.window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
            activity.window.statusBarColor = Color.TRANSPARENT
        } else {
            activity.window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        }
    }

    /**
     * 设置根布局参数
     */
    private fun setRootView(activity: Activity) {
        val parent = activity.findViewById<View>(android.R.id.content) as ViewGroup
        var i = 0
        val count = parent.childCount
        while (i < count) {
            val childView = parent.getChildAt(i)
            if (childView is ViewGroup) {
                childView.setFitsSystemWindows(true)
                childView.clipToPadding = true
            }
            i++
        }
    }

    /**
     * 设置状态栏全透明
     *
     * @param activity 需要设置的activity
     */
    fun setTransparent(activity: Activity) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            return
        }
        transparentStatusBar(activity)
        setRootView(activity)
    }
}
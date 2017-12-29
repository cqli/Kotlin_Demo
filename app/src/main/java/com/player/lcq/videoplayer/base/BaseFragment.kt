package com.player.lcq.videoplayer.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.player.lcq.videoplayer.utils.SharedPreferencesUtil
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.runOnUiThread
import org.jetbrains.anko.toast

/**
 * Created by lcq on 2017/11/22.
 * 所有frament的基类
 */
abstract class BaseFragment : Fragment(), AnkoLogger {
    var sp: SharedPreferencesUtil? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sp = SharedPreferencesUtil.getInstance(context)
        init()
    }

    /**
     * fragment初始化
     */
    open protected fun init() {

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return initView()

    }

    /**
     * 获取布局View
     */
    protected abstract fun initView(): View?

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initData()
    }

    /**
     * 初始化数据操作
     */
    abstract fun initData()

    /**
     * adapter listener
     */
    abstract fun initListener()

    fun myToast(msg: String) {
        context?.runOnUiThread { toast(msg) }
    }
}

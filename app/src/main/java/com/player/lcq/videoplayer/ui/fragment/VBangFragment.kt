package com.player.lcq.videoplayer.ui.fragment

import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.widget.TextView
import com.player.lcq.videoplayer.base.BaseFragment

/**
 * Created by lcq on 2017/12/5.
 */
class VBangFragment :BaseFragment() {
    override fun initView(): View? {
        val tv = TextView(context)
        tv.gravity = Gravity.CENTER
        tv.setTextColor(Color.RED)
        tv.text = javaClass.simpleName
        return tv

    }
}
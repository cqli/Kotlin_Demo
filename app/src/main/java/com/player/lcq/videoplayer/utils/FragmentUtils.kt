package com.player.lcq.videoplayer.utils

import com.player.lcq.videoplayer.R
import com.player.lcq.videoplayer.base.BaseFragment
import com.player.lcq.videoplayer.ui.fragment.HomeFragment
import com.player.lcq.videoplayer.ui.fragment.MvFragment
import com.player.lcq.videoplayer.ui.fragment.VBangFragment
import com.player.lcq.videoplayer.ui.fragment.YueDanFragment

/**
 * Created by lcq on 2017/12/5.
 * fragmeng 创建工具类
 */
class FragmentUtils private constructor() {
    val homeFragmet by lazy { HomeFragment() }
    val mvFragment by lazy { MvFragment() }
    val vBangFragment by lazy { VBangFragment() }
    val yudabFragment by lazy { YueDanFragment() }

    //私有化构造方法
    companion object {
        val fragmentUtils by lazy { FragmentUtils() }
    }

    /**
     * 根据资源id创建并返回对应的fragmeng
     */
    fun getFragment(id: Int): BaseFragment? {
        when (id) {
            R.id.navigation_first -> return homeFragmet
            R.id.navigation_second -> return mvFragment
            R.id.navigation_third -> return vBangFragment
            R.id.navigation_four -> return yudabFragment
        }
        return null
    }
}
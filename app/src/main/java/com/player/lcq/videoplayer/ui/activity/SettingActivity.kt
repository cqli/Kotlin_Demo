package com.player.lcq.videoplayer.ui.activity

import android.preference.PreferenceManager
import android.support.v7.widget.Toolbar
import com.player.lcq.videoplayer.R
import com.player.lcq.videoplayer.base.BaseActivity
import com.player.lcq.videoplayer.utils.ToolBarManager
import org.jetbrains.anko.find

/**
 * Created by lcq on 2017/12/5.
 * 设置界面
 */
class SettingActivity : BaseActivity(), ToolBarManager {
    override fun day_night() {
        swich_day_night()
    }

    override val toolbar: Toolbar  by lazy { find<Toolbar>(R.id.toolbar) }

    override fun getLayoutId(): Int {
        return R.layout.activity_setting
    }

    override fun initData() {
        initSettingToolbar()
////        swich 可以自动保存选中状态
//        val sp = PreferenceManager.getDefaultSharedPreferences(this);
//        val isPush = sp.getBoolean("push", false)
    }
}
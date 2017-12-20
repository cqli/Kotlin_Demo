package com.player.lcq.videoplayer.ui.activity

import android.support.design.widget.BottomNavigationView
import android.support.v4.app.FragmentTransaction
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import com.player.lcq.videoplayer.R
import com.player.lcq.videoplayer.base.BaseActivity
import com.player.lcq.videoplayer.customview.BottomNavigationViewHelper
import com.player.lcq.videoplayer.utils.FragmentUtils
import com.player.lcq.videoplayer.utils.ToolBarManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.find

/**
 * App 主界面
 */
class MainActivity : BaseActivity(), ToolBarManager {
    override val toolbar: Toolbar by lazy { find<Toolbar>(R.id.toolbar) }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initData() {
        initMainToolBar()
    }

    override fun initListener() {
        buttomnavigation.setOnNavigationItemSelectedListener(MyOnNavigationItemSelectedListener())
        BottomNavigationViewHelper.disableShiftMode(buttomnavigation)
        val item: MenuItem = buttomnavigation.menu.getItem(0)
        creatFragment(item)
    }

    inner class MyOnNavigationItemSelectedListener : BottomNavigationView.OnNavigationItemSelectedListener {
        override fun onNavigationItemSelected(item: MenuItem): Boolean {
            creatFragment(item)
            return true
        }

    }

    private fun creatFragment(item: MenuItem) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, FragmentUtils.fragmentUtils.getFragment(item.itemId), item.title as String?)
        transaction.commit()
    }
}
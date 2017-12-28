package com.player.lcq.videoplayer.ui.activity

import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
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
    private var mContent: Fragment? = null
    override fun day_night() {
        swich_day_night()
        buttomnavigation.selectedItemId = buttomnavigation.menu.getItem(0).itemId
    }

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
//        val transaction = supportFragmentManager.beginTransaction()
//        transaction.replace(R.id.container, FragmentUtils.fragmentUtils.getFragment(item.itemId), item.title as String?)
//        transaction.commit()
        switchFrament(mContent, FragmentUtils.fragmentUtils.getFragment(item.itemId))
    }

    /**
     * Fragment切换
     */
    private fun switchFrament(from: Fragment?, to: Fragment?) {
        if (from != to) {
            mContent = to!!
            val ft = supportFragmentManager.beginTransaction()
            //才切换
            //判断有没有被添加
            if (!to!!.isAdded) {
                //to没有被添加
                //from隐藏
                if (from != null) {
                    ft.hide(from)
                }
                //添加to
                ft.add(R.id.container, to).commit()
            } else {
                //to已经被添加
                // from隐藏
                if (from != null) {
                    ft.hide(from)
                }
                //显示to
                ft.show(to).commit()
            }
        }

    }
}
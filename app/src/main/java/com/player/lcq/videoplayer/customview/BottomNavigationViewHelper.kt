package com.player.lcq.videoplayer.customview

import android.annotation.SuppressLint
import android.support.design.internal.BottomNavigationItemView
import android.support.design.internal.BottomNavigationMenuView
import android.support.design.widget.BottomNavigationView
import android.util.Log


/**
 * Created by lcq on 2017/11/23.
 * 取消navigationView 动画
 */
object BottomNavigationViewHelper {
    @SuppressLint("RestrictedApi")
    fun disableShiftMode(view: BottomNavigationView) {
        //获取子View BottomNavigationMenuView的对象
        val menuView = view.getChildAt(0) as BottomNavigationMenuView
        try {
            //设置私有成员变量mShiftingMode可以修改
            val shiftingMode = menuView.javaClass.getDeclaredField("mShiftingMode")
            shiftingMode.isAccessible = true
            shiftingMode.setBoolean(menuView, false)
            shiftingMode.isAccessible = false
            for (i in 0 until menuView.childCount) {
                val item = menuView.getChildAt(i) as BottomNavigationItemView
                //去除shift效果
                item.setShiftingMode(false)
                item.setChecked(item.itemData.isChecked)
            }
        } catch (e: NoSuchFieldException) {
            Log.e("BNVHelper", "没有mShiftingMode这个成员变量", e)
        } catch (e: IllegalAccessException) {
            Log.e("BNVHelper", "无法修改mShiftingMode的值", e)
        }

    }
}
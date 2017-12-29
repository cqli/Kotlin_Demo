package com.player.lcq.videoplayer.mvp

import android.app.Activity

/**
 * Created by lcq on 2017/12/28.
 *  * ================================================
 * 框架要求框架中的每个 Presenter 都需要实现此类,以满足规范
 * @see BasePresenter
 * ================================================
 */
interface IPresenter {

    /**
     * 做一些初始化操作
     */
    fun onStart()

    /**
     * 刷新数据
     */
    fun loadDatas()

    /**
     * 加载更多
     */
    fun loadMore(offset: Int)


    /**
     * 在框架中 [Activity.onDestroy] 会默认调用[IPresenter.onDestroy]
     */
    fun onDestroy()
}
package com.sqliteutils.lcq.base_mvp_http_utils.mvp

/**
 * Created by lcq on 2017/12/28.
 * ================================================
 * 框架要求框架中的每个 View 都需要实现此类,以满足规范
 *
 * ================================================
 */
open interface IView<RESPONSE> {
    companion object {
        val TYPE_INIT_OR_REFRESH = 1
        val TYPE_LOAD_MORE = 2
    }

    /**
     * 显示加载
     */
    fun showLoading()

    /**
     * 隐藏加载
     */
    fun hideLoading()

    /**
     * 显示信息
     */
    fun showMessage(message: String)

    /**
     * 获取数据失败
     */
    fun onError(type: Int, message: String?)

    /**
     * 初始化数据或者刷新数据成功
     */
    fun loadSuccess(reponse: RESPONSE?)

    /**
     * 加载更多成功
     */
    fun loadMore(response: RESPONSE?)
}
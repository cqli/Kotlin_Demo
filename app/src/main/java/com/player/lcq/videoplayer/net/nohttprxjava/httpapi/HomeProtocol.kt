package com.player.lcq.videoplayer.net.nohttprxjava.httpapi

import com.itheima.player.model.bean.HomeItemBean
import com.player.lcq.videoplayer.net.URLProviderUtils
import com.player.lcq.videoplayer.net.nohttprxjava.BaseProtocol
import io.reactivex.Observable

/**
 * Created by lcq on 2017/12/15.
 * rxjava 首页request 创建
 */
object HomeProtocol : BaseProtocol<List<HomeItemBean>>() {
    //首页接口请求
    fun testHomeRequest(offset: Int): Observable<List<HomeItemBean>> {
        return createObservable(URLProviderUtils.getHomeUrl(offset))
    }
}
package com.player.lcq.videoplayer.net.nohttprxjava

import com.itheima.player.model.bean.HomeItemBean
import com.player.lcq.videoplayer.net.URLProviderUtils
import io.reactivex.Observable

/**
 * Created by lcq on 2017/12/15.
 * rxjava request 创建
 */
class TestProtocol : BaseProtocol<List<HomeItemBean>>() {
    //首页接口请求
    fun testHomeRequest(offset: Int): Observable<List<HomeItemBean>> {
        return createObservable(URLProviderUtils.getHomeUrl(offset))
    }
}
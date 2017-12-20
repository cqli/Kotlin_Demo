package com.player.lcq.videoplayer.net.nohttprxjava

import com.player.lcq.videoplayer.model.BaseBean
import com.player.lcq.videoplayer.net.URLProviderUtils
import com.yanzhenjie.nohttp.RequestMethod
import io.reactivex.Observable

/**
 * Created by lcq on 2017/12/15.
 * rxjava request 创建
 */
class TestProtocol : BaseProtocol() {
    //首页接口请求
    fun testHomeRequest(offset: Int): Observable<Any> {
        return createObservable(URLProviderUtils.getHomeUrl(offset), BaseBean::class.java)
    }
}
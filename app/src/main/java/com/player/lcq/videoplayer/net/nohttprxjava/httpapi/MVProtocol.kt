package com.player.lcq.videoplayer.net.nohttprxjava.httpapi

import com.itheima.player.model.bean.MvAreaBean
import com.itheima.player.model.bean.YueDanBean
import com.player.lcq.videoplayer.net.URLProviderUtils
import com.player.lcq.videoplayer.net.nohttprxjava.BaseProtocol
import io.reactivex.Observable

/**
 * Created by lcq on 2017/12/29.
 * MV请求
 */
object MVProtocol : BaseProtocol<List<MvAreaBean>>() {
    //首页接口请求
    fun MVRequest(): Observable<List<MvAreaBean>> {
        return createObservable(URLProviderUtils.getMVareaUrl())
    }
}
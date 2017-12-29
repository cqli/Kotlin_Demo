package com.player.lcq.videoplayer.net.nohttprxjava.httpapi

import com.itheima.player.model.bean.YueDanBean
import com.player.lcq.videoplayer.net.URLProviderUtils
import com.player.lcq.videoplayer.net.nohttprxjava.BaseProtocol
import io.reactivex.Observable

/**
 * Created by lcq on 2017/12/29.
 * 悦单请求
 */
object YueDanProtocol : BaseProtocol<YueDanBean>() {
    //首页接口请求
    fun yueDanRequest(offset: Int): Observable<YueDanBean> {
        return createObservable(URLProviderUtils.getYueDanUrl(offset))
    }
}
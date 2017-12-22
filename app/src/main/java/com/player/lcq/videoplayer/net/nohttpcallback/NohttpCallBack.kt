package com.player.lcq.videoplayer.net.nohttpcallback

import com.player.lcq.videoplayer.net.URLProviderUtils
import com.player.lcq.videoplayer.net.request.BaseRequest
import com.yanzhenjie.nohttp.NoHttp
import com.yanzhenjie.nohttp.RequestMethod
import com.yanzhenjie.nohttp.rest.SimpleResponseListener

/**
 * Created by lcq on 2017/12/15.
 * NoHttp callBack 传统回调数据 单列模式
 */
class NohttpCallBack {
    companion object {
        val nohttpCallBack by lazy { NohttpCallBack() }
    }

    val YUEDANLIST = 0x00001
    /**
     * 悦单 界面列表请求
     */
    inline fun <reified T> YueDanRequest(parames: Map<String, String>?, res: SimpleResponseListener<T>) {
        val req = BaseRequest<T>(URLProviderUtils.getHomeUrl(1), RequestMethod.GET, T::class.java)
        if (parames != null)
            req.add(parames)
        NoHttp.getRequestQueueInstance()?.add<T>(YUEDANLIST, req, res)
    }

    inline fun <reified T> YueDanRequest(res: SimpleResponseListener<T>) {
        YueDanRequest(null, res)
    }
}
package com.player.lcq.videoplayer.net.request

import com.player.lcq.videoplayer.utils.GsonUtils
import com.yanzhenjie.nohttp.Headers
import com.yanzhenjie.nohttp.Logger
import com.yanzhenjie.nohttp.RequestMethod
import com.yanzhenjie.nohttp.rest.RestRequest
import com.yanzhenjie.nohttp.rest.StringRequest

/**
 * Created by lcq on 2017/12/15.
 */
class BaseRequest<T>(url: String?, requestMethod: RequestMethod?, clazz: Class<T>) : RestRequest<T>(url, requestMethod) {
    private val mClass = clazz
    /**
     * 设置请求头内容
     */
    fun addHeader() {

//        addHeader("id", DeviceInfo.getInstance(mContext).getIMEI())
//        addHeader("model", DeviceInfo.getInstance(mContext).getDeviceType())
//        addHeader("channel", DeviceInfo.getInstance(mContext).getChannel())
//        addHeader("version", DeviceInfo.getInstance(mContext).getOsVersion())
//        addHeader("display", DeviceInfo.getInstance(mContext).getDisplay())
//        addHeader("sid",
//                String.valueOf(DeviceInfo.getInstance(mContext).getsid()))
//        addHeader("ssid", DeviceInfo.getInstance(mContext).getssid())
//        addHeader("appversion", DeviceInfo.getInstance(mContext)
//                .getVersionCode() + "")
//        addHeader("token", DeviceInfo.getInstance(mContext).getToken())
//        addHeader("memcard", DeviceInfo.getInstance(mContext).getMemcard())

    }

    override fun parseResponse(responseHeaders: Headers?, responseBody: ByteArray?): T? {
        val url = url()
        val result = StringRequest.parseResponseString(headers, responseBody)
        Logger.e(url)
        Logger.e(result)
        return GsonUtils.fromJson(result, mClass)
    }

}
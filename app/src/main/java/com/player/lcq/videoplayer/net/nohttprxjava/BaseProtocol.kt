package com.player.lcq.videoplayer.net.nohttprxjava

import com.google.gson.Gson
import com.player.lcq.videoplayer.net.URLProviderUtils
import com.player.lcq.videoplayer.net.request.BaseRequest
import com.player.lcq.videoplayer.utils.GsonUtils
import com.yanzhenjie.nohttp.Headers
import com.yanzhenjie.nohttp.RequestMethod
import com.yanzhenjie.nohttp.rest.SyncRequestExecutor
import com.yanzhenjie.nohttp.tools.HeaderUtils
import com.yanzhenjie.nohttp.tools.IOUtils
import io.reactivex.Observable
import io.reactivex.Observable.create
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

/**
 * Created by lcq on 2017/12/15.
 * 被观察着(被订阅)
 */
open class BaseProtocol {

    private val mGson by lazy { Gson() }
    val client by lazy { OkHttpClient() }
    /**
     *  创建一个被观察者(被订阅者)对象
     *  @param url
     *  @param method
     *  @param params
     */
    protected fun <T> createObservable(url: String, clazz: Class<T>): Observable<Any> {
        return create {
            // val req = BaseRequest(url, method, clazz)
            //            if (params != null)
            //                req.add(params)
            //            val execute = SyncRequestExecutor.INSTANCE.execute(req)
            //            if (execute?.isSucceed!!) {
            //                it.onNext(execute.get())
            //                it.onComplete()
            //            } else {
            //                it.onError(execute.exception)
            //
            //            }
            val request = Request.Builder()
                    .url(url)
                    .get()
                    .build()
            val res: Response = client.newCall(request).execute()
            if (res.isSuccessful) {
                val result = parseResponseString(res?.body()?.bytes())
                val res = GsonUtils.GsonToList<T>(result)
                it.onNext(res)
                it.onComplete()
            } else {
                it.onError(Throwable("not data"))
            }
            res.body()
            //            val request = OKHttpClient.getRequest(url, OKHttpClient.METHOD_GET, params)
            //            val json = OKHttpClient.execute2String(request)
            //            if (!json.isNullOrBlank()) {
            //                it.onNext(mGson.fromJson(json, clazz))
            ////                it.onNext(GsonUtils.fromJson(json!!, clazz))
            ////                it.onNext(GsonUtils.fromJson(json!!, clazz))
            //                it.onComplete()
            //            } else {
            //                it.onError(Throwable("not data"))
            //            }
        }
    }

    /**
     * Parse http response to string.
     *
     * @param responseHeaders header from http response.
     * @param responseBody    byteArray from http response.
     * @return result fro response.
     */
    fun parseResponseString(responseBody: ByteArray?): String {
        if (responseBody == null || responseBody.size == 0)
            return ""
        return IOUtils.toString(responseBody, "UTF-8")
    }

    protected fun <T> createObservable(url: String, method: RequestMethod, clazz: Class<T>): Observable<Any> {
        return createObservable(url, clazz)
    }

}
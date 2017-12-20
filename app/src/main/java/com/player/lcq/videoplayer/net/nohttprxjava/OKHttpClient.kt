package com.player.lcq.videoplayer.net.nohttprxjava

import okhttp3.*
import java.io.IOException

/**
 * Created by lcq on 2017/12/15.
 * request 管理
 */
object OKHttpClient {
    private val DEFAULT_TIME_OUT = 5000L

    val METHOD_GET: String = "GET"
    val METHOD_POST: String = "POST"
    val METHOD_PUT: String = "PUT"
    val METHOD_DELETE: String = "DELETE"

    //日志过滤器
    private val mLogInterceptor = LogInterceptor(object : LogInterceptor.Logger {
        override fun log(message: String) {
            XgoLog.d(message)
        }
    }, LogInterceptor.Level.BODY)

    private val mHttpClient = OkHttpClient.Builder().addInterceptor(mLogInterceptor).build()


    /**
     * 同步
     * */
    fun execute2String(request: Request): String? {
        var result: String? = null
        try {
            val response = mHttpClient.newCall(request).execute()
            if (response!!.isSuccessful) {
                result = response.body()?.string()
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return result
    }

    /**
     * 异步
     * */
    fun enqueue(request: Request, responseCallback: Callback) {
        mHttpClient.newCall(request).enqueue(responseCallback)
    }

    /**
     * 创建个Request
     * */
    fun getRequest(url: String, method: String, params: Map<String, String>?): Request {
        val builder = Request.Builder()
        if (METHOD_GET.equals(method, true)) {
            builder.url(initGetRequest(url, params)).get()
        } else if (METHOD_POST.equals(method, true)) {
            builder.url(url).post(initRequestBody(params))
        } else if (METHOD_PUT.equals(method, true)) {
            builder.url(url).put(initRequestBody(params))
        } else if (METHOD_DELETE.equals(method, true)) {
            if (params == null || params.isEmpty()) {
                builder.url(url).delete()
            } else {
                builder.url(url).delete(initRequestBody(params))
            }
        }

        return builder.build()
    }


    /**
     * 创建Body请求体
     * */
    fun initRequestBody(params: Map<String, String>?): RequestBody {
        val bodyBuilder = MultipartBody.Builder().setType(MultipartBody.FORM)
        params!!.map {
            bodyBuilder.addFormDataPart(it.key, it.value)
        }
        return bodyBuilder.build()
    }


    /**
     * 创建Get链接
     * */
    fun initGetRequest(url: String, params: Map<String, String>?): String {
        if (params != null && params.isNotEmpty()) {
            val sb = StringBuilder(url).append("?")
            var count = 0
            params.map {
                println("map")
                count++
                sb.append(it.key).append("=").append(it.value)
                if (count != params.size) {
                    sb.append("&")
                }
            }
            return sb.toString()
        }
        return url
    }
}
package com.player.lcq.videoplayer.net.nohttprxjava

import com.yanzhenjie.nohttp.*
import java.net.URL
import javax.net.ssl.HttpsURLConnection

/**
 * Created by lcq on 2017/12/19.
 */
class DefOkHttpNetworkExecutor : NetworkExecutor {
    @Throws(Exception::class)
    override fun execute(request: BasicRequest<*>): Network {
        val url = URL(request.url())
        val connection = URLConnectionFactory.getInstance().open(url, request.proxy)
        connection.connectTimeout = request.connectTimeout
        connection.readTimeout = request.readTimeout
        connection.instanceFollowRedirects = false

        if (connection is HttpsURLConnection) {
            val sslSocketFactory = request.sslSocketFactory
            if (sslSocketFactory != null)
                connection.sslSocketFactory = sslSocketFactory
            val hostnameVerifier = request.hostnameVerifier
            if (hostnameVerifier != null)
                connection.hostnameVerifier = hostnameVerifier
        }

        connection.requestMethod = request.requestMethod.toString()

        connection.doInput = true
        val isAllowBody = request.requestMethod.allowRequestBody()
        connection.doOutput = isAllowBody

        val headers = request.headers

        val values = headers.getValues(Headers.HEAD_KEY_CONNECTION)
        if (values == null || values.size == 0)
            headers.add(Headers.HEAD_KEY_CONNECTION, Headers.HEAD_VALUE_CONNECTION_KEEP_ALIVE)

        if (isAllowBody)
            headers.set(Headers.HEAD_KEY_CONTENT_LENGTH, java.lang.Long.toString(request.contentLength))

        val requestHeaders = headers.toRequestHeaders()
        for ((headKey, headValue) in requestHeaders) {
            Logger.i(headKey + ": " + headValue)
            connection.setRequestProperty(headKey, headValue)
        }
        // 5. Connect
        connection.connect()
        return OkHttpNetwork(connection)
    }
}
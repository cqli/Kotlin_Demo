package com.player.lcq.videoplayer

import android.content.Context
import android.support.multidex.MultiDexApplication
import android.support.v7.app.AppCompatDelegate
import com.player.lcq.videoplayer.net.nohttprxjava.DefOkHttpNetworkExecutor
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreater
import com.scwang.smartrefresh.layout.api.RefreshHeader
import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.scwang.smartrefresh.layout.constant.SpinnerStyle
import com.scwang.smartrefresh.layout.footer.ClassicsFooter
import com.scwang.smartrefresh.layout.header.ClassicsHeader
import com.yanzhenjie.nohttp.InitializationConfig
import com.yanzhenjie.nohttp.Logger
import com.yanzhenjie.nohttp.NoHttp


/**
 * Created by lcq on 2017/12/12.
 */
class MyApplication : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        initNoHttp()
        initRefreshLayout()
    }

    private fun initRefreshLayout() {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        SmartRefreshLayout.setDefaultRefreshHeaderCreater { context, layout ->
            //            layout.setPrimaryColorsId(R.color.colorPrimary, android.R.color.white)//全局设置主题颜色
            ClassicsHeader(context).setSpinnerStyle(SpinnerStyle.Translate)
        }
        SmartRefreshLayout.setDefaultRefreshFooterCreater { context, layout ->
            //            layout.setPrimaryColorsId(R.color.colorPrimary, android.R.color.white)//全局设置主题颜色
            ClassicsFooter(context).setSpinnerStyle(SpinnerStyle.Translate)
        }
    }

    /**
     * 初始化网络请求
     */
    private fun initNoHttp() {


        val config = InitializationConfig.newBuilder(getApplicationContext())
                // 全局连接服务器超时时间，单位毫秒，默认10s。
                .connectionTimeout(20 * 1000)
                // 全局等待服务器响应超时时间，单位毫秒，默认10s。
                .readTimeout(20 * 1000)
                // 配置缓存，默认保存数据库DBCacheStore，保存到SD卡使用DiskCacheStore。
                .cacheStore(
                        // 如果不使用缓存，setEnable(false)禁用。
                        com.yanzhenjie.nohttp.cache.DBCacheStore(getApplicationContext()).setEnable(false)
                )
                // 配置Cookie，默认保存数据库DBCookieStore，开发者可以自己实现CookieStore接口。
                .cookieStore(
                        // 如果不维护cookie，setEnable(false)禁用。
                        com.yanzhenjie.nohttp.cookie.DBCookieStore(getApplicationContext()).setEnable(false)
                )
                // 配置网络层，默认URLConnectionNetworkExecutor，如果想用OkHttp：OkHttpNetworkExecutor。
                .networkExecutor(DefOkHttpNetworkExecutor())
                // 全局通用Header，add是添加，多次调用add不会覆盖上次add。
                //                .addHeader()
                //                // 全局通用Param，add是添加，多次调用add不会覆盖上次add。
                //                .addParam()
                //                .sslSocketFactory() // 全局SSLSocketFactory。
                //                .hostnameVerifier() // 全局HostnameVerifier。
//                .retry(1) // 全局重试次数，配置后每个请求失败都会重试x次。
                .build()
        Logger.setDebug(true);// 开启NoHttp的调试模式, 配置后可看到请求过程、日志和错误信息。
        Logger.setTag("NoHttpSample");// 打印Log的tag。
        NoHttp.initialize(config)
    }
}
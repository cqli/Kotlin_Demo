package com.player.lcq.videoplayer.net

import com.player.lcq.videoplayer.BuildConfig

/**
 * Created by lcq on 2017/12/15.
 */
object Constants {
    val KEY_HEADER_CACHE = "ok_header_cache_type"

    val DEBUG = BuildConfig.DEBUG

    val PAGE_SIZE = "15"


    val SPLASH_ID = "splashid"
    val SPLASH_PATH = "splashpath"
    /**
     * 接口域名地址
     * deviceinfo=${getDeviceInfo((480 * 800).toString())} 通用参数
     */
    val baseUrl = "http://mapi.yinyuetai.com/"

    /**
     * 首页url 接口 480*800
     *  "&offset=" + offset
     *    "&size=" + size
     *    "&v=4&rn=640*540"
     */
//    val homeHrl = "${baseUrl}suggestions/front_page.json"
    val homeHrl = ("http://mapi.yinyuetai.com/suggestions/front_page.json?deviceinfo="
            + "{\"aid\":\"10201036\",\"os\":\"Android\","
            + "\"ov\":" + "\"" + getSystemVersion() + "\"" + ","
            + "\"rn\":\"480*800\","
            + "\"dn\":" + "\"" + getPhoneModel() + "\"" + ","
            + "\"cr\":\"46000\","
            + "\"as\":"
            + "\"WIFI\","
            + "\"uid\":"
            + "\"dbcaa6c4482bc05ecb0bf39dabf207d2\","
            + "\"clid\":110025000}"
            + "&offset=" + 0
            + "&size=" + 20
            + "&v=4&rn=640*540")


    /**
     * mv相关接口 480*800
     */
    val mvareaUrl = "${baseUrl}video/get_mv_areas.json"

    /**
     * mv列表数据 480*800
     * "&area=" + area
     * "&offset=" + offset
     * "&size=" + size
     */
    val MVlistUrl = "${baseUrl}video/list.json"
    /**
     * 悦单 url 480 800
     * "&offset=" + offset
     * "&size=" + size
     */
    val yueDanUrl = "${baseUrl}playlist/list.json"

    /**
     * 获取音乐节目列表 480*800
     * "&offset=" + offset
     * "&size=" + size
     * "&artistIds=" + artistIds
     */
    val yinyueProgramListUrl = "${baseUrl}playlist/show.json"

    /**
     * 获取v榜地址 480*800
     */
    val vChartAreasUrl = "${baseUrl}vchart/get_vchart_areas.json"
    /**
     * 获取v榜的周期 480*800
     * "&area=" + area
     */
    val vcChartPeriodUrl = "${baseUrl}vchart/period.json"
    /**
     * 获取v榜列表 480*800
     * "&area=" + area
     * "&datecode=" + dateCode
     */
    val vChartListUrl = "${baseUrl}vchart/show.json"
    //获取相关MV 480*800
    /**
     *  "&relatedVideos=true"
     *  "&id=" + id
     */
    val relativeVideoListUrl = "${baseUrl}video/show.json"

    /**
     * 获取默认的悦单 480*800
     *    "&id=" + id
     */
    val peopleYueDanList = "playlist/show.json"

    fun getDeviceInfo(): String {
        val deviceInfoUrl = ("{\"aid\":\"10201036\",\"os\":\"Android\","
                + "\"ov\":" + "\"" + getSystemVersion() + "\"" + ","
                + "\"rn\":\"480*800\","
                + "\"dn\":" + "\"" + getPhoneModel() + "\"" + ","
                + "\"cr\":\"46000\","
                + "\"as\":"
                + "\"WIFI\","
                + "\"uid\":"
                + "\"dbcaa6c4482bc05ecb0bf39dabf207d2\","
                + "\"clid\":110025000}")
        return deviceInfoUrl
    }

    /**
     * 系统版本
     */
    private fun getSystemVersion(): String {
        return android.os.Build.VERSION.RELEASE
    }

    /**
     * 手机型号
     */
    private fun getPhoneModel(): String {
        return android.os.Build.MODEL
    }
}
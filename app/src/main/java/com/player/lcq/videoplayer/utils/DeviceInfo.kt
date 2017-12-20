package com.player.lcq.videoplayer.utils

import android.annotation.SuppressLint
import android.content.Context
import android.telephony.TelephonyManager
import android.util.Log
import android.view.inputmethod.InputMethodManager

/**
 * Created by lcq on 2017/12/15.
 */
class DeviceInfo {
    private var mTelephonyManager: TelephonyManager? = null
    private var mContext: Context? = null
    @SuppressLint("MissingPermission")

    /**
     * 私有构造函数，为实现singleton类
     *
     * @param context Context对象
     */
    private fun DeviceInfo(context: Context) {
        mContext = context
        mTelephonyManager = mContext!!
                .getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
    }

    @SuppressLint("MissingPermission")
            /**
             * 获取本机的IMEI
             *
             * @return IMEI
             */
    fun getIMEI(): String? {
        return mTelephonyManager?.deviceSoftwareVersion
    }

    @SuppressLint("MissingPermission", "HardwareIds")
            /**
             * 获取本机的IMSI，若无，提供一默认的
             *
             * @return IMSI
             */
    fun getIMSI(): String {
        var myIMSI: String? = mTelephonyManager?.getSubscriberId()
        if (myIMSI == null) {
            myIMSI = "310260000000000"
        }
        Log.d("DeviceInfo", "imsi:" + myIMSI)
        return myIMSI
    }
}
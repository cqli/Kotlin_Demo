package com.player.lcq.videoplayer.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by lcq on 2017/12/22.
 */

public class SharedPreferencesUtil {

    private static SharedPreferencesUtil mSharePrefUtils;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    public final static String SHAREPREFFILENAME = "zgjkj_sharepref";// 文件名称
    public final static String SHAREPREFNEWSREADED = "zgjkj_newsreaded";// 记录新闻已读状态
    public final static String LOGINED = "logined";// 是否已登录状态
    public static final String USERNAME = "username";
    public static final String NICKNAME = "nickName";
    public static final String PHOTOIMG = "photoImg";

    public static final String QQTOKEN = "qqtoken";
    public static final String QQTOKENSECRET = "qqtokensecret";
    public static final String QQVERIFIER = "qqverifier";

    @SuppressWarnings("unused")
    private String filename;
    @SuppressWarnings("unused")
    private Integer mode;
    private Context mContext;

    private SharedPreferencesUtil(Context _mContext, String filename, Integer mode) {
        this.filename = filename;
        this.mode = mode;
        this.mContext = _mContext;
        preferences = this.mContext.getSharedPreferences(filename, mode);
        editor = preferences.edit();
    }

    /***
     * 单例模式需要修改，同步问题需要修改
     * @param _mContext
     * @param filename
     * @param mode
     * @return
     */
    public static SharedPreferencesUtil getInstance(Context _mContext,
                                                    String filename, Integer mode) {
        if (mSharePrefUtils == null) {
            return new SharedPreferencesUtil(_mContext, filename, mode);
        } else {
            return mSharePrefUtils;
        }
    }

    public boolean contains(String key) {
        return preferences.contains(key);
    }

    /**
     * 存储值
     *
     * @param key
     * @param value 支持类型：java.lang.Integer\java.lang.Boolean\java.lang.Float\java.
     *              lang.String\java.lang.Long
     */
    public void setValue(String key, Object value) {
        String className = value.getClass().getName();
        if ("java.lang.Integer".equals(className)) {
            editor.putInt(key, Integer.valueOf(String.valueOf(value)));
        } else if ("java.lang.Boolean".equals(className)) {
            editor.putBoolean(key, Boolean.valueOf(String.valueOf(value)));
        } else if ("java.lang.Float".equals(className)) {
            editor.putFloat(key, Float.valueOf(String.valueOf(value)));
        } else if ("java.lang.String".equals(className)) {
            editor.putString(key, String.valueOf(value));
        } else if ("java.lang.Long".equals(className)) {
            editor.putLong(key, Long.valueOf(String.valueOf(value)));
        }
        editor.commit();
    }

    /**
     * 获取已存储的值
     *
     * @param key
     * @param defValue 如果不存在，设置缺少值
     * @return
     */
    public boolean getBooleanValue(String key, boolean defValue) {
        return preferences.getBoolean(key, defValue);
    }

    public String getStringValue(String key, String defValue) {
        return preferences.getString(key, defValue);
    }

    public int getIntValue(String key, int defValue) {
        return preferences.getInt(key, defValue);
    }

    public long getLongValue(String key, Long defValue) {
        return preferences.getLong(key, defValue);
    }

    public float getFloatValue(String key, float defValue) {
        return preferences.getFloat(key, defValue);
    }

    /**
     * 删除指定的值
     *
     * @param key
     */
    public void clearValue(String key) {
        editor.remove(key);
        editor.commit();
    }

    /**
     * 释放资源
     */
    public void clearAll() {
        editor.clear();
        editor.commit();
        editor = null;
        preferences = null;
    }

}

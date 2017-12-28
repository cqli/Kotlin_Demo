package com.player.lcq.videoplayer.utils

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import android.R.attr.name
import com.itheima.player.model.bean.HomeItemBean


/**
 * Created by lcq on 2017/12/15.
 */
object GsonUtils {

    val gson: Gson by lazy {
        GsonBuilder()
//                .excludeFieldsWithoutExposeAnnotation()//打开Export注解，但打开了这个注解,副作用，要转换和不转换都要加注解
//              .serializeNulls()  //是否序列化空值
//                .setDateFormat("yyyy-MM-dd HH:mm:ss")//序列化日期格式  "yyyy-MM-dd"
//              .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)//会把字段首字母大写
//                .setPrettyPrinting() //自动格式化换行
//              .setVersion(1.0)  //需要结合注解使用，有的字段在1。0的版本的时候解析，但0。1版本不解析
                .create()
    }


    //对象转换为json
    fun toJson(`object`: Any): String? {
        return gson.toJson(`object`)
    }

    //JSON转换为对象1--普通类型
    fun <T> fromJson(json: String, classOfT: Class<T>): T {
        return gson.fromJson(json, classOfT)
    }

    //JSON转换为对象-针对泛型的类型
    fun <T> fromJson(json: String, typeOfT: Type): T? {
        return gson.fromJson(json, typeOfT)
    }

    /**
     *
     *
     * @param gsonString
     * @param cls
     * @return
     */

    inline fun < reified T> gsonToList(result: String): T {

        var rs: T

        val type = object : TypeToken<T>() {
        }.type

        rs = gson.fromJson(result, type)
        return rs
    }


    fun  gsonToListItemBean(result: String): List<HomeItemBean> {

        var rs: List<HomeItemBean>

        val type = object : TypeToken<HomeItemBean>() {
        }.type

        rs = gson.fromJson(result, type)
        return rs
    }

    /**
     *
     *
     * @param gsonString
     * @return
     */
    fun <T> GsonToListMaps(gsonString: String): List<Map<String, T>>? {
        return gson.fromJson(gsonString,
                object : TypeToken<List<Map<String, T>>>() {

                }.type)
    }

    /**
     *
     *
     * @param gsonString
     * @return
     */
    fun <T> GsonToMaps(gsonString: String): Map<String, T>? {
        return gson.fromJson(gsonString, object : TypeToken<Map<String, T>>() {
        }.type)
    }
}
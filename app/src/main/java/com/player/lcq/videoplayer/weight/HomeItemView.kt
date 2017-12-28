package com.player.lcq.videoplayer.weight

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.bumptech.glide.Glide
import com.itheima.player.model.bean.HomeItemBean
import com.player.lcq.videoplayer.R
import kotlinx.android.synthetic.main.item_home.view.*

/**
 * Created by lcq on 2017/12/27.
 * 首页列表itemView
 */
class HomeItemView : RelativeLayout {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    /**
     * 初始化方法加载xml
     */
    init {
        View.inflate(context, R.layout.item_home, this)
    }

    fun setData(data: HomeItemBean) {
        var resID = -1
        when (data.type) {
            "PLAYLIST" -> resID = R.mipmap.home_page_playlist//悦单
            "VIDEO" -> resID = R.mipmap.home_page_video//首播
            "ACTIVITY" -> resID = R.mipmap.home_page_activity//活动
            "AD" -> resID = R.mipmap.home_page_ad//广告
            "BULLETIN" -> resID = R.mipmap.home_page_bulletin//公告
            "FANART" -> resID = R.mipmap.home_page_fanart//饭制
            "LIVE" -> resID = R.mipmap.home_page_live//直播
            "LIVE_NEW" -> resID = R.mipmap.home_page_activity//饭趴
            "PROGRAM" -> resID = R.mipmap.home_page_program//节目
            "PROJECT" -> resID = R.mipmap.home_page_project//专题
            "STAR" -> resID = R.mipmap.home_page_project//star
        }
        if (resID != -1) iv_type.background = context.getDrawable(resID)
        Glide.with(context)
                .load(data.posterPic)
                .into(iv_item_home)
        tv_item_title.text = data.title
        tv_item_des.text = data.description
    }
}
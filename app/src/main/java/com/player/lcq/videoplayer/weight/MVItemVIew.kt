package com.player.lcq.videoplayer.weight

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.bumptech.glide.Glide
import com.itheima.player.model.bean.VideosBean
import com.player.lcq.videoplayer.R
import kotlinx.android.synthetic.main.item_mv.view.*

/**
 * Created by lcq on 2017/12/29.
 * mv 列表item
 */
class MVItemVIew : RelativeLayout {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        View.inflate(context, R.layout.item_mv, this)
    }

    /**
     * 适配每一个条目view
     */
    fun setData(data: VideosBean) {
        //歌手名称
        artist.text = data.artistName
        //歌曲名称
        title.text = data.title
        //背景图
        Glide.with(context).load(data.playListPic).into(bg)
    }
}
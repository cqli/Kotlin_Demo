package com.player.lcq.videoplayer.adapter

import android.content.Context
import com.itheima.player.model.bean.VideosBean
import com.player.lcq.videoplayer.weight.MVItemVIew

/**
 * Created by lcq on 2017/12/26.
 * MV数据适配
 */
class MVAdapter : BaseListAdapter<VideosBean, MVItemVIew>() {
    override fun refreshItemView(itemView: MVItemVIew, data: VideosBean) {
        itemView.setData(data)
    }

    override fun getItemView(context: Context?): MVItemVIew {
        return MVItemVIew(context)
    }
}
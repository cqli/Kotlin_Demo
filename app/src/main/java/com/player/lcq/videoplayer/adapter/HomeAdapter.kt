package com.player.lcq.videoplayer.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.itheima.player.model.bean.HomeItemBean
import com.player.lcq.videoplayer.weight.HomeItemView

/**
 * Created by lcq on 2017/12/26.
 * 悦单数据适配
 */
class HomeAdapter : BaseListAdapter<HomeItemBean, HomeItemView>() {
    override fun refreshItemView(itemView: HomeItemView, data: HomeItemBean) {
        itemView.setData(data)
    }

    override fun getItemView(context: Context?): HomeItemView {
        return HomeItemView(context)
    }


}
package com.player.lcq.videoplayer.adapter

import android.content.Context
import com.itheima.player.model.bean.YueDanBean
import com.player.lcq.videoplayer.weight.YueDanItemView

/**
 * Created by lcq on 2017/12/26.
 * 首页数据适配
 */
class YueDanAdapter : BaseListAdapter<YueDanBean.PlayListsBean, YueDanItemView>() {
    override fun refreshItemView(itemView: YueDanItemView, data: YueDanBean.PlayListsBean) {
        itemView.setData(data)
    }


    override fun getItemView(context: Context?): YueDanItemView {
        return YueDanItemView(context)
    }


}
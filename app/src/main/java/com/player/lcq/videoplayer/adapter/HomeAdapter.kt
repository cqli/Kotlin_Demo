package com.player.lcq.videoplayer.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.itheima.player.model.bean.HomeItemBean
import com.player.lcq.videoplayer.weight.HomeItemView

/**
 * Created by lcq on 2017/12/26.
 * 首页数据适配
 */
class HomeAdapter : RecyclerView.Adapter<HomeAdapter.HomeHolder>() {
    var mItemList = ArrayList<HomeItemBean>()
    /**
     * 更新数据
     */
    fun updateList(list: List<HomeItemBean>?) {
        list?.let {
            this.mItemList.clear()
            this.mItemList.addAll(list)
            notifyDataSetChanged()
        }
    }

    /**
     * 加载更多
     */
    fun loadMore(list: List<HomeItemBean>?) {
        list?.let {
            this.mItemList.addAll(list)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return mItemList.size
    }

    override fun onBindViewHolder(holder: HomeAdapter.HomeHolder?, position: Int) {
        val itemView = holder?.itemView as HomeItemView
        itemView.setData(mItemList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): HomeHolder {
        return HomeHolder(HomeItemView(parent?.context))
    }

    class HomeHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }
}
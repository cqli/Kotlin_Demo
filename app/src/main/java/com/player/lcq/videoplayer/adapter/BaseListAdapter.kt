package com.player.lcq.videoplayer.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup

/**
 * Created by lcq on 2017/12/29.
 * list Adapter 基类
 */
abstract class BaseListAdapter<ITEMBEAN, ITEMVIEW : View> : RecyclerView.Adapter<BaseListAdapter.BaseListHolder>() {
    private var list = ArrayList<ITEMBEAN>()
    /**
     * 更新数据
     */
    fun updateList(list: List<ITEMBEAN>?) {

        list?.let {

            this.list.clear()
            this.list.addAll(list)
            notifyDataSetChanged()
        }
    }

    /**
     * 加载更多
     */
    fun loadMore(list: List<ITEMBEAN>?) {
        list?.let {
            this.list.addAll(list)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseListHolder {
        return BaseListHolder(getItemView(parent?.context))
    }

    override fun onBindViewHolder(holder: BaseListHolder?, position: Int) {
        val itemView = holder?.itemView as ITEMVIEW
        //条目刷新
        refreshItemView(itemView, list.get(position))


    }

    override fun getItemCount(): Int {
        return list.size
    }


    class BaseListHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    /**
     * 刷新条目view
     */
    abstract fun refreshItemView(itemView: ITEMVIEW, data: ITEMBEAN)

    /**
     * 获取条目view
     */
    abstract fun getItemView(context: Context?): ITEMVIEW
}

package com.player.lcq.videoplayer.ui.fragment

import com.itheima.player.model.bean.HomeItemBean
import com.player.lcq.videoplayer.adapter.BaseListAdapter
import com.player.lcq.videoplayer.adapter.HomeAdapter
import com.player.lcq.videoplayer.base.BaseListFragment
import com.player.lcq.videoplayer.mvp.IPresenter
import com.player.lcq.videoplayer.mvp.presenter.HomePresenter
import com.player.lcq.videoplayer.weight.HomeItemView

/**
 * Created by lcq on 2017/12/5.
 * 首页
 */
class HomeFragment : BaseListFragment<List<HomeItemBean>, HomeItemBean, HomeItemView>() {
    override fun getSpecialAdapter(): BaseListAdapter<HomeItemBean, HomeItemView> {
        return HomeAdapter()
    }

    override fun getSpecialPresenter(): IPresenter {
        return HomePresenter(this)
    }

    override fun getList(response: List<HomeItemBean>?): List<HomeItemBean>? {
        return response
    }


}
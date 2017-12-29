package com.player.lcq.videoplayer.ui.fragment

import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.itheima.player.model.bean.HomeItemBean
import com.itheima.player.model.bean.YueDanBean
import com.player.lcq.videoplayer.R
import com.player.lcq.videoplayer.R.id.refreshLayout
import com.player.lcq.videoplayer.adapter.BaseListAdapter
import com.player.lcq.videoplayer.adapter.HomeAdapter
import com.player.lcq.videoplayer.adapter.YueDanAdapter
import com.player.lcq.videoplayer.base.BaseFragment
import com.player.lcq.videoplayer.base.BaseListFragment
import com.player.lcq.videoplayer.mvp.IPresenter
import com.player.lcq.videoplayer.mvp.presenter.HomePresenter
import com.player.lcq.videoplayer.mvp.IView
import com.player.lcq.videoplayer.mvp.presenter.YueDanPresenter
import com.player.lcq.videoplayer.weight.YueDanItemView
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Created by lcq on 2017/12/5.
 * 悦单列表
 */
class YueDanFragment : BaseListFragment<YueDanBean, YueDanBean.PlayListsBean, YueDanItemView>() {
    override fun getList(response: YueDanBean?): List<YueDanBean.PlayListsBean>? {
        return response?.playLists
    }

    override fun getSpecialAdapter(): BaseListAdapter<YueDanBean.PlayListsBean, YueDanItemView> {
        return YueDanAdapter()
    }

    override fun getSpecialPresenter(): IPresenter {
        return YueDanPresenter(this)
    }


}
package com.player.lcq.videoplayer.ui.fragment

import com.itheima.player.model.bean.MvPagerBean
import com.itheima.player.model.bean.VideosBean
import com.player.lcq.videoplayer.adapter.BaseListAdapter
import com.player.lcq.videoplayer.adapter.MVAdapter
import com.player.lcq.videoplayer.base.BaseListFragment
import com.player.lcq.videoplayer.mvp.IPresenter
import com.player.lcq.videoplayer.mvp.presenter.MVlistPresenter
import com.player.lcq.videoplayer.weight.MVItemVIew

/**
 * Created by lcq on 2017/12/29.
 * MV列表
 */
class MvPagerFragment : BaseListFragment<MvPagerBean, VideosBean, MVItemVIew>() {
    var code: String? = null
    override fun init() {
        code = arguments.getString("args")
    }

    override fun getSpecialAdapter(): BaseListAdapter<VideosBean, MVItemVIew> {
        return MVAdapter()
    }

    override fun getSpecialPresenter(): IPresenter {
        return MVlistPresenter(code, this)
    }

    override fun getList(response: MvPagerBean?): List<VideosBean>? {
        return response?.videos
    }
}
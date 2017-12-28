package com.player.lcq.videoplayer.ui.fragment

import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.itheima.player.model.bean.HomeItemBean
import com.player.lcq.videoplayer.R
import com.player.lcq.videoplayer.adapter.HomeAdapter
import com.player.lcq.videoplayer.base.BaseFragment
import com.player.lcq.videoplayer.mvp.presenter.HomePresenter
import com.sqliteutils.lcq.base_mvp_http_utils.mvp.IView
import com.sqliteutils.lcq.base_mvp_http_utils.mvp.IView.Companion.TYPE_INIT_OR_REFRESH
import com.sqliteutils.lcq.base_mvp_http_utils.mvp.IView.Companion.TYPE_LOAD_MORE
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Created by lcq on 2017/12/5.
 * 首页
 */
class HomeFragment : BaseFragment(), IView<List<HomeItemBean>> {
    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun showMessage(message: String) {
    }


    override fun onError(type: Int, message: String?) {
        when (type) {
            TYPE_INIT_OR_REFRESH -> refreshLayout.finishRefresh()
            TYPE_LOAD_MORE -> refreshLayout.finishLoadmore()
        }
        if (message != null) {
            myToast(message)
        }
    }

    override fun loadSuccess(reponse: List<HomeItemBean>?) {
        adapter.updateList(reponse)
        refreshLayout.finishRefresh()
    }

    override fun loadMore(response: List<HomeItemBean>?) {
        adapter.loadMore(response)
        refreshLayout.finishLoadmore()
    }

    private val adapter by lazy { HomeAdapter() }
    val presenter by lazy { HomePresenter(this) }
    override fun initView(): View? {
        return View.inflate(context, R.layout.fragment_home, null)
    }


    override fun initData() {
        //初始化RecyclerView
        initListener()
        recyclerview.itemAnimator = DefaultItemAnimator()
        recyclerview.layoutManager = LinearLayoutManager(context)
        recyclerview.adapter = adapter
        presenter.loadDatas()
    }

    /**
     *SmartRefreshlayout监听
     */
    fun initListener() {
        refreshLayout.setOnRefreshListener {
            presenter.loadDatas()
        }
        refreshLayout.setOnLoadmoreListener {
            presenter.loadMore(adapter.itemCount)
        }
    }
}
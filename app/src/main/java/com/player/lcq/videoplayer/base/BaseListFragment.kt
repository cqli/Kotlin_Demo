package com.player.lcq.videoplayer.base

import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.player.lcq.videoplayer.R
import com.player.lcq.videoplayer.adapter.BaseListAdapter
import com.player.lcq.videoplayer.mvp.IPresenter
import com.player.lcq.videoplayer.mvp.IView
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Created by lcq on 2017/12/29.
 * 列表基类
 */
abstract class BaseListFragment<RESPONSE, ITEMBEAN, ITEMVIEW : View> : BaseFragment(), IView<RESPONSE> {
    private val adapter by lazy { getSpecialAdapter() }
    private val presenter by lazy { getSpecialPresenter() }
    override fun showLoading() {
    }

    override fun hideLoading() {
    }


    override fun onError(type: Int, message: String?) {
        when (type) {
            IView.TYPE_INIT_OR_REFRESH -> refreshLayout?.finishRefresh()
            IView.TYPE_LOAD_MORE -> refreshLayout?.finishLoadmore()
        }
        if (message != null) {
            myToast(message)
        }
    }

    override fun loadSuccess(reponse: RESPONSE?) {
        adapter.updateList(getList(reponse))
        refreshLayout?.finishRefresh()
    }

    override fun loadMore(response: RESPONSE?) {
        adapter.loadMore(getList(response))
        refreshLayout?.finishLoadmore()
    }

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
     *SmartrefreshLayout?监听
     */
    override fun initListener() {
        refreshLayout?.setOnRefreshListener {
            presenter.loadDatas()
        }
        refreshLayout?.setOnLoadmoreListener {
            presenter.loadMore(adapter.itemCount)
        }
    }

    /**
     * 获取适配器adapter
     */
    abstract fun getSpecialAdapter(): BaseListAdapter<ITEMBEAN, ITEMVIEW>

    /**
     * 获取presenter
     */
    abstract fun getSpecialPresenter(): IPresenter

    /**
     * 从返回结果中获取列表数据集合
     */
    abstract fun getList(response: RESPONSE?): List<ITEMBEAN>?
}
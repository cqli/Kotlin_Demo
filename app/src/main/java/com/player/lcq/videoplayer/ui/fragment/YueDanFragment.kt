package com.player.lcq.videoplayer.ui.fragment

import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.itheima.player.model.bean.HomeItemBean
import com.player.lcq.videoplayer.R
import com.player.lcq.videoplayer.adapter.HomeAdapter
import com.player.lcq.videoplayer.base.BaseFragment
import com.player.lcq.videoplayer.mvp.presenter.HomePresenter
import com.player.lcq.videoplayer.net.nohttprxjava.TestProtocol
import com.player.lcq.videoplayer.utils.RxUtils
import com.sqliteutils.lcq.base_mvp_http_utils.mvp.IView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Created by lcq on 2017/12/5.
 * 悦单列表
 */
class YueDanFragment : BaseFragment(), IView<List<HomeItemBean>> {
    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun showMessage(message: String) {
    }


    override fun onError(type: Int, message: String?) {
        when (type) {
            IView.TYPE_INIT_OR_REFRESH -> refreshLayout.finishRefresh()
            IView.TYPE_LOAD_MORE -> refreshLayout.finishLoadmore()
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
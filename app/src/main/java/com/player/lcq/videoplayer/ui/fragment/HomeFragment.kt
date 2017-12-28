package com.player.lcq.videoplayer.ui.fragment

import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.player.lcq.videoplayer.R
import com.player.lcq.videoplayer.adapter.HomeAdapter
import com.player.lcq.videoplayer.base.BaseFragment
import com.player.lcq.videoplayer.net.nohttprxjava.TestProtocol
import com.player.lcq.videoplayer.utils.RxUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Created by lcq on 2017/12/5.
 * 首页
 */
class HomeFragment : BaseFragment() {
    private val testProtocol by lazy { TestProtocol() }
    private val adapter by lazy { HomeAdapter() }
    private var mHomeDisposable: Disposable? = null
    override fun initView(): View? {
        return View.inflate(context, R.layout.fragment_home, null)
    }


    override fun initData() {
        //初始化RecyclerView
        initListener()
        recyclerview.itemAnimator = DefaultItemAnimator()
        recyclerview.layoutManager = LinearLayoutManager(context)
        recyclerview.adapter = adapter
        loadData()
    }

    /**
     *SmartRefreshlayout监听
     */
    fun initListener() {
        refreshLayout.setOnRefreshListener {
            loadData()
        }
        refreshLayout.setOnLoadmoreListener {
            loadMore(adapter.itemCount)
        }
    }

    private fun loadData() {
        RxUtils.dispose(mHomeDisposable)
        mHomeDisposable = testProtocol.testHomeRequest(1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    adapter.updateList(it)
                    refreshLayout.finishRefresh()
                }, {
                    myToast(it.toString())
                })
    }

    private fun loadMore(offset: Int) {
        RxUtils.dispose(mHomeDisposable)
        mHomeDisposable = testProtocol.testHomeRequest(offset)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    adapter.loadMore(it)
                    refreshLayout.finishLoadmore()
                }, {
                    myToast(it.toString())
                })
    }
}
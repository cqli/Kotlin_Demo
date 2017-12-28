package com.player.lcq.videoplayer.mvp.presenter

import com.itheima.player.model.bean.HomeItemBean
import com.player.lcq.videoplayer.net.nohttprxjava.TestProtocol
import com.player.lcq.videoplayer.utils.RxUtils
import com.sqliteutils.lcq.base_mvp_http_utils.mvp.IPresenter
import com.sqliteutils.lcq.base_mvp_http_utils.mvp.IView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by lcq on 2017/12/28.
 */
class HomePresenter(var homeView: IView<List<HomeItemBean>>?) : IPresenter {
    private val testProtocol by lazy { TestProtocol() }
    private var mHomeDisposable: Disposable? = null
    /**
     * 界面初始化的操作
     */
    override fun onStart() {
    }

    override fun loadDatas() {
        RxUtils.dispose(mHomeDisposable)
        mHomeDisposable = testProtocol.testHomeRequest(0)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    homeView?.loadSuccess(it)
                }, {
                    homeView?.onError(IView.TYPE_INIT_OR_REFRESH, it.toString())
                })
    }

    override fun loadMore(offset: Int) {
        RxUtils.dispose(mHomeDisposable)
        mHomeDisposable = testProtocol.testHomeRequest(offset)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    homeView?.loadMore(it)
                }, {
                    homeView?.onError(IView.TYPE_LOAD_MORE, it.toString())
                })
    }

    override fun onDestroy() {
        if (homeView != null) {
            homeView = null
        }
        RxUtils.dispose(mHomeDisposable)
    }


}
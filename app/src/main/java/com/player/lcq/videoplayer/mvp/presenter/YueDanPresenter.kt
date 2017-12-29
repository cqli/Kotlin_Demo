package com.player.lcq.videoplayer.mvp.presenter

import com.itheima.player.model.bean.HomeItemBean
import com.itheima.player.model.bean.YueDanBean
import com.player.lcq.videoplayer.mvp.IPresenter
import com.player.lcq.videoplayer.mvp.IView
import com.player.lcq.videoplayer.net.nohttprxjava.httpapi.HomeProtocol
import com.player.lcq.videoplayer.net.nohttprxjava.httpapi.YueDanProtocol
import com.player.lcq.videoplayer.utils.RxUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by lcq on 2017/12/28.
 * 首页presenter
 */
class YueDanPresenter(private var homeView: IView<YueDanBean>?) : IPresenter {
    private var mHomeDisposable: Disposable? = null
    /**
     * 界面初始化的操作
     */
    override fun onStart() {
    }

    override fun loadDatas() {
        RxUtils.dispose(mHomeDisposable)
        mHomeDisposable = YueDanProtocol.yueDanRequest(0)
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
        mHomeDisposable = YueDanProtocol.yueDanRequest(offset)
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
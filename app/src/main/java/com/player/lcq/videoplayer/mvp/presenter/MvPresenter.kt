package com.player.lcq.videoplayer.mvp.presenter

import com.itheima.player.model.bean.MvAreaBean
import com.player.lcq.videoplayer.mvp.IPresenter
import com.player.lcq.videoplayer.mvp.IView
import com.player.lcq.videoplayer.net.nohttprxjava.httpapi.MVProtocol
import com.player.lcq.videoplayer.net.nohttprxjava.httpapi.YueDanProtocol
import com.player.lcq.videoplayer.ui.fragment.MvFragment
import com.player.lcq.videoplayer.utils.RxUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by lcq on 2017/12/28.
 * mv首页presenter
 */
class MvPresenter(private var homeView: IView<List<MvAreaBean>>?) : IPresenter {
    private var mHomeDisposable: Disposable? = null
    /**
     * 界面初始化的操作
     */
    override fun onStart() {
    }

    override fun loadDatas() {
        RxUtils.dispose(mHomeDisposable)
        mHomeDisposable = MVProtocol.MVRequest()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    homeView?.loadSuccess(it)
                }, {
                    homeView?.onError(IView.TYPE_INIT_OR_REFRESH, it.toString())
                })
    }

    override fun loadMore(offset: Int) {
    }

    override fun onDestroy() {
        if (homeView != null) {
            homeView = null
        }
        RxUtils.dispose(mHomeDisposable)
    }


}
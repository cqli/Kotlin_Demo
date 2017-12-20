package com.player.lcq.videoplayer.ui.fragment

import android.view.View
import com.player.lcq.videoplayer.R
import com.player.lcq.videoplayer.base.BaseFragment
import com.player.lcq.videoplayer.net.nohttprxjava.TestProtocol
import com.player.lcq.videoplayer.utils.RxUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_list.*

/**
 * Created by lcq on 2017/12/5.
 * 首页
 */
class HomeFragment : BaseFragment() {
    val testProtocol by lazy { TestProtocol() }
    private var mHomeDisposable: Disposable? = null
    override fun initView(): View? {
        return View.inflate(context, R.layout.fragment_list, null)
    }

    override fun initData() {
        RxUtils.dispose(mHomeDisposable)
        mHomeDisposable = testProtocol.testHomeRequest(1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    tv_result.text = it.toString()
                }, {
                    tv_result.text = it.toString()
                })

    }
}
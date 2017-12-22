package com.player.lcq.videoplayer.ui.fragment

import android.view.View
import com.player.lcq.videoplayer.R
import com.player.lcq.videoplayer.base.BaseFragment
import com.player.lcq.videoplayer.model.BaseBean
import com.player.lcq.videoplayer.net.nohttpcallback.NohttpCallBack
import com.player.lcq.videoplayer.net.nohttprxjava.TestProtocol
import com.player.lcq.videoplayer.utils.RxUtils
import com.yanzhenjie.nohttp.rest.Response
import com.yanzhenjie.nohttp.rest.SimpleResponseListener
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_list.*

/**
 * Created by lcq on 2017/12/5.
 * 首页
 */
class HomeFragment : BaseFragment() {
    override fun initView(): View? {
        return View.inflate(context, R.layout.fragment_list, null)
    }

    override fun initData() {
        NohttpCallBack.nohttpCallBack.YueDanRequest(object : SimpleResponseListener<String>() {
            override fun onFailed(what: Int, response: Response<String>?) {
                super.onFailed(what, response)
                tv_result?.text = response?.get().toString()
            }

            override fun onSucceed(what: Int, response: Response<String>?) {
                super.onSucceed(what, response)


                tv_result?.text = response?.get().toString()
            }

        })

    }
}
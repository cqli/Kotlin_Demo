package com.player.lcq.videoplayer.ui.fragment

import android.view.View
import com.itheima.player.model.bean.MvAreaBean
import com.player.lcq.videoplayer.R
import com.player.lcq.videoplayer.adapter.MvPagerAdapter
import com.player.lcq.videoplayer.base.BaseFragment
import com.player.lcq.videoplayer.mvp.IView
import com.player.lcq.videoplayer.mvp.presenter.MvPresenter
import kotlinx.android.synthetic.main.fragment_mv.*

/**
 * Created by lcq on 2017/12/5.
 * MV
 */
class MvFragment : BaseFragment(), IView<List<MvAreaBean>> {
    override fun loadSuccess(response: List<MvAreaBean>?) {
        //在fragment中管理fragment需要用childFragmentManager
        val adapter = MvPagerAdapter(context, response, childFragmentManager)
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)
    }

    override fun loadMore(response: List<MvAreaBean>?) {
    }

    override fun initListener() {


    }

    private val presenter by lazy { MvPresenter(this) }
    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun initData() {
        presenter.loadDatas()
    }


    override fun onError(type: Int, message: String?) {
        if (message != null) {
            myToast(message)
        }
    }


    override fun initView(): View? {
        return View.inflate(context, R.layout.fragment_mv, null)
    }

}
package com.player.lcq.videoplayer.ui.fragment

import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.itheima.player.model.VideoPlayBean
import com.itheima.player.model.bean.HomeItemBean
import com.player.lcq.videoplayer.R
import com.player.lcq.videoplayer.adapter.HomeAdapter
import com.player.lcq.videoplayer.base.BaseFragment
import com.player.lcq.videoplayer.mvp.presenter.HomePresenter
import com.player.lcq.videoplayer.mvp.IView
import com.player.lcq.videoplayer.ui.activity.VideoActivity
import kotlinx.android.synthetic.main.fragment_home.*
import org.jetbrains.anko.support.v4.startActivity

/**
 * Created by lcq on 2017/12/5.
 * 榜单
 */
class VBangFragment : BaseFragment(), IView<List<HomeItemBean>> {
    override fun showLoading() {
    }

    override fun hideLoading() {
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
    private val presenter by lazy { HomePresenter(this) }
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
    override fun initListener() {
        refreshLayout.setOnRefreshListener {
            presenter.loadDatas()
        }
        refreshLayout.setOnLoadmoreListener {
            presenter.loadMore(adapter.itemCount)
        }

        //设置条目点击事件监听函数
//        adapter.setMyListener{
//            val videoPlayBean = VideoPlayBean(it.id,it.title,it.url)
//            //跳转到视频播放界面
//            startActivity<JiecaoVideoPlayerActivity>("item" to videoPlayBean)
//        }
        adapter.listener = {
            when (it.type) {
//                "PLAYLIST" -> resID = R.mipmap.home_page_playlist//悦单
//                "ACTIVITY" -> resID = R.mipmap.home_page_activity//活动
//                "BULLETIN" -> resID = R.mipmap.home_page_bulletin//公告

                "VIDEO" -> {
                    val videoPlayBean = VideoPlayBean(it.id, it.title, it.url, it.posterPic)
                    startActivity<VideoActivity>("item" to videoPlayBean)
                }
                "AD" -> {
                    val videoPlayBean = VideoPlayBean(it.id, it.title, it.url, it.posterPic)
                    startActivity<VideoActivity>("item" to videoPlayBean)
                }
                "PROGRAM" -> {
                    val videoPlayBean = VideoPlayBean(it.id, it.title, it.url, it.posterPic)
                    startActivity<VideoActivity>("item" to videoPlayBean)
                }
                "FANART" -> {
                    val videoPlayBean = VideoPlayBean(it.id, it.title, it.url, it.posterPic)
                    startActivity<VideoActivity>("item" to videoPlayBean)
                }
                "LIVE" -> {
                    val videoPlayBean = VideoPlayBean(it.id, it.title, it.url, it.posterPic)
                    startActivity<VideoActivity>("item" to videoPlayBean)
                }
                "PROJECT" -> {
                    val videoPlayBean = VideoPlayBean(it.id, it.title, it.url, it.posterPic)
                    startActivity<VideoActivity>("item" to videoPlayBean)
                }
                "STAR" -> {
                    val videoPlayBean = VideoPlayBean(it.id, it.title, it.url, it.posterPic)
                    startActivity<VideoActivity>("item" to videoPlayBean)
                }
                "LIVE_NEW" -> {
                    val videoPlayBean = VideoPlayBean(it.id, it.title, it.url, it.posterPic)
                    startActivity<VideoActivity>("item" to videoPlayBean)
                }

            }

        }
    }


}
package com.player.lcq.videoplayer.ui.fragment

import com.itheima.player.model.VideoPlayBean
import com.itheima.player.model.bean.HomeItemBean
import com.player.lcq.videoplayer.R
import com.player.lcq.videoplayer.adapter.BaseListAdapter
import com.player.lcq.videoplayer.adapter.HomeAdapter
import com.player.lcq.videoplayer.base.BaseListFragment
import com.player.lcq.videoplayer.mvp.IPresenter
import com.player.lcq.videoplayer.mvp.presenter.HomePresenter
import com.player.lcq.videoplayer.ui.activity.VideoActivity
import com.player.lcq.videoplayer.weight.HomeItemView
import org.jetbrains.anko.support.v4.startActivity

/**
 * Created by lcq on 2017/12/5.
 * 首页
 */
class HomeFragment : BaseListFragment<List<HomeItemBean>, HomeItemBean, HomeItemView>() {
    override fun getSpecialAdapter(): BaseListAdapter<HomeItemBean, HomeItemView> {
        return HomeAdapter()
    }

    override fun getSpecialPresenter(): IPresenter {
        return HomePresenter(this)
    }

    override fun getList(response: List<HomeItemBean>?): List<HomeItemBean>? {
        return response
    }

    override fun initListener() {

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
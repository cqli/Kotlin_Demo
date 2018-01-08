package com.player.lcq.videoplayer.ui.fragment

import com.itheima.player.model.VideoPlayBean
import com.itheima.player.model.bean.MvPagerBean
import com.itheima.player.model.bean.VideosBean
import com.player.lcq.videoplayer.adapter.BaseListAdapter
import com.player.lcq.videoplayer.adapter.MVAdapter
import com.player.lcq.videoplayer.base.BaseListFragment
import com.player.lcq.videoplayer.mvp.IPresenter
import com.player.lcq.videoplayer.mvp.presenter.MVlistPresenter
import com.player.lcq.videoplayer.ui.activity.VideoActivity
import com.player.lcq.videoplayer.weight.MVItemVIew
import org.jetbrains.anko.support.v4.startActivity

/**
 * Created by lcq on 2017/12/29.
 * MV列表
 */
class MvPagerFragment : BaseListFragment<MvPagerBean, VideosBean, MVItemVIew>() {
    var code: String? = null
    override fun init() {
        code = arguments.getString("args")
    }

    override fun getSpecialAdapter(): BaseListAdapter<VideosBean, MVItemVIew> {
        return MVAdapter()
    }

    override fun getSpecialPresenter(): IPresenter {
        return MVlistPresenter(code, this)
    }

    override fun getList(response: MvPagerBean?): List<VideosBean>? {
        return response?.videos
    }
    override fun initListener() {

        //设置条目点击事件监听函数
//        adapter.setMyListener{
//            val videoPlayBean = VideoPlayBean(it.id,it.title,it.url)
//            //跳转到视频播放界面
//            startActivity<JiecaoVideoPlayerActivity>("item" to videoPlayBean)
//        }
        adapter.listener = {
            val videoPlayBean = VideoPlayBean(it.id, it.title, it.url, it.posterPic)
            startActivity<VideoActivity>("item" to videoPlayBean)
        }
    }
}
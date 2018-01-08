package com.player.lcq.videoplayer.ui.activity

import cn.jzvd.JZVideoPlayer
import cn.jzvd.JZVideoPlayerStandard
import com.bumptech.glide.Glide
import com.itheima.player.model.VideoPlayBean
import com.player.lcq.videoplayer.R
import com.player.lcq.videoplayer.base.BaseActivity
import kotlinx.android.synthetic.main.activity_video.*

/**
 * Created by lcq on 2018/1/5.
 * 视频播放界面
 */
class VideoActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_video
    }

    override fun initData() {
        val data = intent.data
        println("data=$data")
        if (data == null) {
            //获取传递的数据
            val videoPlayBean = intent.getParcelableExtra<VideoPlayBean>("item")
            //从应用内响应视频播放
            videoplayer.setUp(videoPlayBean.url,
                    JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, videoPlayBean.title)
            Glide.with(this)
                    .load(videoPlayBean.bgUrl)
                    .into(videoplayer.thumbImageView)
        } else {
            if (data.toString().startsWith("http")) {
                //应用外网络视频请求
                //应用外响应
                videoplayer.setUp(data.toString(),
                        JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, data.toString())
            } else {
                //应用外的本地视频请求
                //应用外响应
                videoplayer.setUp(data.path,
                        JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, data.toString())
            }

        }
//        videoplayer.setUp("http://jzvd.nathen.cn/342a5f7ef6124a4a8faf00e738b8bee4/cf6d9db0bd4d41f59d09ea0a81e918fd-5287d2089db37e62345123a1be272f8b.mp4", JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, "饺子快长大")

    }

    override fun onPause() {
        super.onPause()
        JZVideoPlayer.releaseAllVideos()
    }

    override fun onBackPressed() {
        if (JZVideoPlayer.backPress()) {
            return
        }
        super.onBackPressed()
    }

}
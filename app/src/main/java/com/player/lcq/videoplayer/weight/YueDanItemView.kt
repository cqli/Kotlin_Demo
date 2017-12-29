package com.player.lcq.videoplayer.weight

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.itheima.player.model.bean.YueDanBean
import com.player.lcq.videoplayer.R
import kotlinx.android.synthetic.main.item_yuedan.view.*

/**
 * Created by lcq on 2017/12/27.
 * 首页列表itemView
 */
class YueDanItemView : RelativeLayout {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    /**
     * 初始化方法加载xml
     */
    init {
        View.inflate(context, R.layout.item_yuedan, this)
    }

    @SuppressLint("SetTextI18n")
    fun setData(data: YueDanBean.PlayListsBean) {
        Glide.with(context)
                .load(data.playListBigPic)
                .into(iv_item_home)
        val requestOptions = RequestOptions.circleCropTransform()
        var photourl = data.creator?.largeAvatar
        if (!photourl?.startsWith("http:", false)!!) {
            photourl = "http:${photourl}"
        }

        Glide.with(context)
                .load(photourl)
                .apply(requestOptions)
                .into(iv_photo)
        tv_item_title.text = data.title
        tv_item_des.text = data.description
        tv_username.text = data.creator?.nickName
        tv_uservip_level.text = "会员等级:${data.creator?.vipLevel.toString()}"
        tv_time.text = "创建时间: ${data.createdTime}   更新时间: ${data.updateTime} "
        tv_category.text = data.category
        tv_integral.text = "积分: ${data.integral}    周积分${data.weekIntegral}"
        tv_usercount_totalfavorites.text = "关注用户:${data.totalUser}   喜欢:${data.totalFavorites}"
        tv_videocount_totalfviews.text = "视频数:${data.videoCount}   图片${data.totalViews}"
    }
}
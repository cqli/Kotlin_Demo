package com.player.lcq.videoplayer.ui.fragment

import android.view.View
import com.player.lcq.videoplayer.R
import com.player.lcq.videoplayer.base.BaseFragment
import com.ypy.eventbus.EventBus
import kotlinx.android.synthetic.main.fragment_list.*

/**
 * Created by lcq on 2017/12/5.
 */
class MvFragment : BaseFragment() {
    override fun initView(): View? {
        return View.inflate(context, R.layout.fragment_list, null)
    }

    override fun initData() {
        tv_result.text = "点击切换主题"
        tv_result?.setOnClickListener({
            if (sp?.getIntValue("day_night", 0) == 0) {
                sp?.setValue("day_night", 1)
            } else {
                sp?.setValue("day_night", 0)
            }

        })
    }


}
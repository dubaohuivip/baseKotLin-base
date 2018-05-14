package com.cn.hfm.ui.fragment

import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.widget.TextView
import com.cn.hfm.base.BaseFragment

/**
 * Created by dubaohui on 2018/5/10.
 */
class TabTowFragment : BaseFragment() {
    override fun initView(): View {
        val tv = TextView(context)
        tv.gravity = Gravity.CENTER
        tv.setTextColor(Color.RED)
        tv.text  = javaClass.simpleName
        return tv
    }

}
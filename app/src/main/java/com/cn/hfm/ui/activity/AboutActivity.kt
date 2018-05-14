package com.cn.hfm.ui.activity

import android.app.Activity
import android.support.v7.widget.Toolbar
import android.widget.TextView
import com.cn.hfm.R
import com.cn.hfm.base.BaseActivity
import com.cn.hfm.util.ToolBarManager
import org.jetbrains.anko.find

/**
 * Created by dubaohui on 2018/5/10.
 */
class AboutActivity: BaseActivity(),ToolBarManager {
    override val toolbar by lazy { find<Toolbar>(R.id.toolbar) }
    override fun showBack(): Boolean {
       return true
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_about
    }

    override fun initView() {
        initMainToolBar("about",this)
        val about_text = findViewById<TextView>(R.id.about_text)
        about_text.text = "这一个基础框架的说明"
    }

}
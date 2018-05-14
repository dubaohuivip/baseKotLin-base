package com.cn.hfm.ui.activity

import android.preference.PreferenceManager
import android.support.v7.widget.Toolbar
import com.cn.hfm.R
import com.cn.hfm.base.BaseActivity
import com.cn.hfm.util.ToolBarManager
import org.jetbrains.anko.find

/**
 * Created by dubaohui on 2018/5/10.
 */
class SettingActivity: BaseActivity(),ToolBarManager {
    override val toolbar by lazy { find<Toolbar>(R.id.toolbar) }
    override fun getLayoutId(): Int {
        return R.layout.activity_setting
    }
    override fun initView() {
        initMainToolBar("设置",this)
        //获取Preference管理
        val ps = PreferenceManager.getDefaultSharedPreferences(this)
        val pushnotice = ps.getBoolean("push_notice",false)
        val nowifiloadimage = ps.getBoolean("no_wifi_load_image",false)
    }

    override fun showBack():Boolean {
        return  true
    }
}
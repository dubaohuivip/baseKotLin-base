package com.cn.hfm.util
import android.app.Activity
import android.content.Intent
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.widget.TextView
import com.cn.hfm.R
import com.cn.hfm.ui.activity.SettingActivity


/**
 * Created by dubaohui on 2018/5/10.
 *  所有界面的ToolBar 的管理类
 */
interface ToolBarManager {
      //定义toolbar
    val toolbar: Toolbar
    /**
     * 初始化主界面toolbar
     * */
    fun  initMainToolBar(title: String,context: Activity){
        val toolbarTitle = toolbar.findViewById<TextView>(R.id.toolbar_title)
        toolbarTitle.text = title
        backOpt(context)
    }

    fun initMainTooBarMenu(title: String,context: Activity){
        //设置标题
        val toolbarTitle = toolbar.findViewById<TextView>(R.id.toolbar_title)
        toolbarTitle.text = title
        //初始化menu
        toolbar.inflateMenu(R.menu.toolbarmenu)
        //绑定菜单点击事件 第一次点击无效
       // toolbar.setOnMenuItemClickListener { onmenuItemClick() }
        //每次点击均有效
        toolbar.setOnMenuItemClickListener(object :Toolbar.OnMenuItemClickListener{
            override fun onMenuItemClick(item: MenuItem?): Boolean {
                when (item?.itemId){
                    R.id.toolbar_setting -> {
                        toolbar.context.startActivity(Intent(toolbar.context,SettingActivity::class.java))
                    }
                }
                return true
            }
        })
        backOpt(context)
    }

    //执行后退操作
    private fun backOpt(context: Activity){
        if(showBack()){
            toolbar.setNavigationIcon(R.mipmap.icon_back)
            toolbar.setNavigationOnClickListener { context.onBackPressed() }
        }
    }


    /**
     * 是否显示后退按钮
     */
     abstract  fun showBack(): Boolean


    //菜单点击事件
   /* private fun onmenuItemClick(): Boolean{
        toolbar.setOnMenuItemClickListener(object: Toolbar.OnMenuItemClickListener{
            override fun onMenuItemClick(item: MenuItem?): Boolean {
                when(item?.itemId) {
                    R.id.toolbar_setting -> {
                        toolbar.context.startActivity(Intent(toolbar.context, SettingActivity::class.java))
                    }
                }
                return true
            }
        })
        return true
    }*/
}
package com.cn.hfm.base

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.cn.hfm.ui.activity.MainActivity
import org.jetbrains.anko.*

/**
 * Created by dubaohui on 2018/5/10.
 * 所有Activity基类
 */
abstract class BaseActivity : AppCompatActivity(), AnkoLogger {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initView()
        initListener()
        initData()
    }

    /**获取布局ID*/
    abstract fun getLayoutId(): Int

    /**初始化UI**/
    open protected fun initView() {}
    /**初始化监听*/
    open protected fun initListener(){}
    /**初始化数据**/
    open protected fun initData() {}

    open protected fun myTosat(message: String) {
        runOnUiThread { toast(message) }
    }

     inline fun <reified T:Activity> startActivityAndFinsh(){
        startActivity<T>()
        finish()
    }
}
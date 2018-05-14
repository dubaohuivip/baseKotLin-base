package com.cn.hfm.base

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.jetbrains.anko.runOnUiThread
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

/**
 * Created by dubaohui on 2018/5/10.
 * 所有Fragment基类
 * 注意 继承V4 Fragment可以兼容3.0以下版本
 */
abstract class BaseFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return initView()
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initListener()
        initData()
    }
    //初始化
    protected fun init() {}
    //获取布局View
    abstract fun initView(): View
    //adapter linstener
    open protected fun initListener() {}
    //数据初始化
    open protected fun initData() {}

    open protected fun myTosat(message: String) {
        context.runOnUiThread { toast(message) }
    }

    inline fun <reified T: Activity> startActivityAndFinsh(context: Activity){
        context.startActivity<T>()
        context.finish()
    }


}
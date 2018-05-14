package com.cn.hfm.view

import com.itheima.player.model.bean.ImageItemBean

/**
 * Created by dubaohui on 2018/5/11.
 * 负责Fragment层与Presenter交互
 */
interface BaseView {
    //初始化或者刷新数据
    fun  loadSuccess(result: String)
    //加载更多数据
    fun  loadMoreSuccess(result: String)
}
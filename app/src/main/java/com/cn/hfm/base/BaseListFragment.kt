package com.cn.hfm.base

import android.graphics.Color
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.cn.hfm.R
import com.cn.hfm.net.ResponseError
import com.cn.hfm.presenter.impl.BasePersenterImpl
import com.cn.hfm.util.UtilEnum
import com.cn.hfm.view.BaseView
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_list.*

abstract class BaseListFragment<ITEMBEN,ITEMVIEW:View>: BaseFragment(),BaseView,ResponseError {
    val gson by lazy { Gson() }
    val persenter by lazy { BasePersenterImpl(this,context,this) }
    val aapter by lazy { getNowAdapter() }

    override fun initView(): View {
        return View.inflate(context, R.layout.fragment_list,null)
    }

    override fun initListener() {
        //将RecyclerView初始化成一个LinerLayout 列表布局
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = aapter
        //初始化刷新空间 修改颜色 vararg--可变参数 即可传递多个参数
        referLayout.setColorSchemeColors(Color.GREEN, Color.YELLOW, Color.RED)
        //设置刷新监听
        referLayout.setOnRefreshListener {
            persenter.loadDataGet(getRequestUrl(0), UtilEnum.REFER)
        }

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                //判断是否处于空闲状态
                if (newState == RecyclerView.SCROLL_STATE_IDLE){
                    //判断当前列表是否为线形列表
                    val layoutManager = recyclerView?.layoutManager
                    if(layoutManager is LinearLayoutManager){
                        val manager: LinearLayoutManager = layoutManager
                        val lastPosition = manager.findLastVisibleItemPosition()
                        if(lastPosition == aapter.itemCount-1){
                            persenter.loadDataGet(getRequestUrl(lastPosition), UtilEnum.LOAD)
                        }
                    }
                }
            }
        })
    }
    override fun initData() {
        //val url = URLProviderUtils.getHomeUrl(0,20)
        persenter.loadDataGet(getRequestUrl(0), UtilEnum.REFER)
    }
    override fun loadMoreSuccess(result:String) {
        aapter.LoadMore(getListData(result))
    }
    override fun loadSuccess(result:String) {
        aapter.updateList(getListData(result))
        closeRefer()
    }
    override fun getOnError(message: String) {
        myTosat("数据加载出错")
    }

    fun closeRefer(){
        if(referLayout !=null && referLayout.isRefreshing){
            referLayout.isRefreshing = false
        }
    }
    //获取Adapter
    abstract fun getNowAdapter():BaseListAdapter<ITEMBEN,ITEMVIEW>

    //获取请求地址
    abstract fun getRequestUrl(pageNo:Int):String

    abstract fun getListData(result: String):List<ITEMBEN>
}
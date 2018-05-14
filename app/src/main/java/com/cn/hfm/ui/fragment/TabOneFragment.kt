package com.cn.hfm.ui.fragment
import android.graphics.Color
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.cn.hfm.R
import com.cn.hfm.adapter.ImageAdapter
import com.cn.hfm.base.BaseFragment
import com.cn.hfm.base.BaseListAdapter
import com.cn.hfm.base.BaseListFragment
import com.cn.hfm.net.ResponseError
import com.cn.hfm.presenter.impl.BasePersenterImpl
import com.cn.hfm.util.URLProviderUtils
import com.cn.hfm.util.UtilEnum
import com.cn.hfm.view.BaseView
import com.cn.hfm.widget.ImageItemView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.itheima.player.model.bean.ImageItemBean

/**
 * Created by dubaohui on 2018/5/10.
 */
class TabOneFragment:BaseListFragment<ImageItemBean,ImageItemView>(){
    override fun getNowAdapter(): BaseListAdapter<ImageItemBean, ImageItemView> {
        return ImageAdapter()
    }

    override fun getRequestUrl(pageNo: Int): String {
        return URLProviderUtils.getHomeUrl(pageNo,20)
    }

    override fun getListData(result: String): List<ImageItemBean> {
        val  list = gson.fromJson<List<ImageItemBean>>(result,object : TypeToken<List<ImageItemBean>>(){}.type)
        return list
    }

    override fun initListener() {
        super.initListener()
        aapter.setMyListener {
            println("it--->$it")
        }
    }

}
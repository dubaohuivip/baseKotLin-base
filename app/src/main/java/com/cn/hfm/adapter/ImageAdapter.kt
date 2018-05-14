package com.cn.hfm.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.cn.hfm.base.BaseListAdapter
import com.cn.hfm.widget.ImageItemView
import com.cn.hfm.widget.LoadMoreView
import com.itheima.player.model.bean.ImageItemBean

/**
 * Created by dubaohui on 2018/5/11.
 */
class ImageAdapter: BaseListAdapter<ImageItemBean, ImageItemView>() {

    override fun referItemView(itemView: ImageItemView, data: ImageItemBean) {
        itemView.setData(data)
    }

    override fun getItemView(context: Context?): ImageItemView {
        return ImageItemView(context)
    }
}
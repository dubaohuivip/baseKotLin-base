package com.cn.hfm.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.cn.hfm.R
import com.itheima.player.model.bean.ImageItemBean
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.image_item.view.*

/**
 * Created by dubaohui on 2018/5/11.
 */
class ImageItemView: RelativeLayout{
    //初始化
    constructor(context: Context?) : super(context)
    //布局
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    //主题相关
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    //初始化方法
    init {
        View.inflate(context, R.layout.image_item,this)
    }

    //适配数据
    fun setData(data: ImageItemBean) {
        title.text = data.title
        desc.text = data.description
        Picasso.get().load(data.posterPic).into(imageviewbg)
    }
}
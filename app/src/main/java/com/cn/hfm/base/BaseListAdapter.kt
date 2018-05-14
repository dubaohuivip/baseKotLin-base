package com.cn.hfm.base

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.cn.hfm.widget.LoadMoreView
/**
 * 所有上拉加载下拉刷新Adaoter基类
 *
 * */
abstract class BaseListAdapter<ITEMBEAN,ITEMVIEW:View> : RecyclerView.Adapter<BaseListAdapter.BaseListAdapter>() {
    private var list = ArrayList<ITEMBEAN>()
    //更新数据集合
    fun updateList(list: List<ITEMBEAN>?){
        list?.let {
            this.list.clear()
            this.list.addAll(list)
            //刷新页面
            notifyDataSetChanged()
        }
    }
    //加载更多
    fun LoadMore(list: List<ITEMBEAN>?){
        list?.let {
            this.list.addAll(list)
            notifyDataSetChanged()
        }
    }

    //总条数
    override fun getItemCount(): Int {
        //当前数据条目+1 预留进度条显示空间
        return list.size+1
    }

    override fun getItemViewType(position: Int): Int {
        if(list.size == position){
            //最后一条
            return 1
        }else{
            //普通条目
            return 0
        }
    }
    //绑定数据
    override fun onBindViewHolder(holder: BaseListAdapter?, position: Int) {
        if (position == list.size) return
        //刷新数据
        val data = list.get(position)
        //刷新条目
        val itemView = holder?.itemView as ITEMVIEW
        //加载数据
        referItemView(itemView,data)
        //为条目绑定点击事件
        itemView.setOnClickListener {
            listener?.let {
                it(data)
            }
        }
    }

    var listener: ((itemBean:ITEMBEAN)-> Unit)? = null
    fun setMyListener(listener:(itemBean:ITEMBEAN)-> Unit){
        this.listener = listener
    }
    

    //初始化ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseListAdapter {
        if (viewType == 1){
            //最后一条
            return BaseListAdapter(LoadMoreView(parent?.context))
        }else {
            //普通条目
            return BaseListAdapter(getItemView(parent?.context))
        }
    }



    class BaseListAdapter(itemView: View): RecyclerView.ViewHolder(itemView){
    }

    //刷新条目
    abstract fun referItemView(itemView: ITEMVIEW, data: ITEMBEAN)

    //获取条目View
    abstract fun getItemView(context: Context?): ITEMVIEW

}
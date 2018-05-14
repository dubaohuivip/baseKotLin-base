package com.cn.hfm.presenter.impl
import android.content.Context
import com.cn.hfm.net.ResponseError
import com.cn.hfm.net.netRequest
import com.cn.hfm.presenter.infter.BasePersenter
import com.cn.hfm.util.ThreadUtil
import com.cn.hfm.util.UtilEnum
import com.cn.hfm.view.BaseView

/**
 * Created by dubaohui on 2018/5/11.
 * 负责业务处理
 */
class  BasePersenterImpl(var baseView: BaseView?, var context: Context,var res: ResponseError):BasePersenter {

    fun desDispView(){
        if (baseView != null){
            baseView = null
        }
    }

    override fun loadDataGet(url: String,info: UtilEnum) {
        netRequest.Insterance.Get(url,context,res,{
            result -> Unit
            ThreadUtil.RunOnThrean(object :Runnable{
                override fun run() {
                    //将结果回调给View层
                    when(info){
                        UtilEnum.LOAD -> baseView?.loadMoreSuccess(result)
                        UtilEnum.REFER -> baseView?.loadSuccess(result)
                    }
                }
            })
        })
    }

    override fun loadDataPost(url: String, param: String,info: UtilEnum) {
        netRequest.Insterance.Post(url,param,context,res,{
            result -> Unit
            ThreadUtil.RunOnThrean(object: Runnable{
                override fun run() {
                    //将结果回调给View层
                    when(info){
                        UtilEnum.LOAD -> baseView?.loadMoreSuccess(result)
                        UtilEnum.REFER -> baseView?.loadSuccess(result)
                    }
                }
            })
        })
    }

    override fun loadDataFile(url: String, param: String, list: List<String>,info: UtilEnum) {
        netRequest.Insterance.PostFile(url,param,list,context,res,{
            result -> Unit
            ThreadUtil.RunOnThrean(object: Runnable{
                override fun run() {
                    //将结果回调给View层
                    when(info){
                        UtilEnum.LOAD -> baseView?.loadMoreSuccess(result)
                        UtilEnum.REFER -> baseView?.loadSuccess(result)
                    }
                }
            })
        })
    }


}
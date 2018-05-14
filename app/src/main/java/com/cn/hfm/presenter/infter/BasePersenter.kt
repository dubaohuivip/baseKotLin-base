package com.cn.hfm.presenter.infter

import com.cn.hfm.util.UtilEnum

/**
 * Created by dubaohui on 2018/5/11.
 */
interface BasePersenter {

    /**
     * url 请求地址
     * */
    fun  loadDataGet(url: String,info: UtilEnum)

    /**
     * url 请求地址
     * param 请求参数
     * */
    fun  loadDataPost(url: String,param:String,info: UtilEnum)
    /**
     * url 请求地址
     * param 请求参数
     * list 附件地址
     * */
    fun  loadDataFile(url: String,param: String,list: List<String> ,info: UtilEnum)
}
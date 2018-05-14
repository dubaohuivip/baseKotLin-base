package com.cn.hfm.net
import android.content.Context
import okhttp3.*
import org.jetbrains.anko.runOnUiThread
import org.jetbrains.anko.toast
import java.io.IOException
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File


/**
 * Created by dubaohui on 2018/5/11.
 * 数据请求方法封装
 */
class netRequest private constructor(){
    val TYPE = "application/octet-stream"
    //单例模式
    companion object {
        val Insterance by lazy { netRequest() }
    }
    //发起request get请求
     fun Get(url:String,contexts: Context,res: ResponseError,callback: (String) -> Unit){
        val client = OkHttpClient()
        val request = Request.Builder()
                .get()
                .url(url)
                .build()
        client.newCall(request).enqueue(object :Callback{
            override fun onFailure(call: Call?, e: IOException?) {
                //contexts.runOnUiThread { toast("请求失败") }
                res.getOnError(e?.message.toString())
            }
            override fun onResponse(call: Call?, response: Response?) {
                val result = response?.body()?.string()
                callback.invoke(result.toString())
            }
        })
    }

    //发起request post请求 无文件
    fun Post(url:String,param:String?,contexts: Context,res: ResponseError,callback: (String) -> Unit){
        val formBoby  = FormBody.Builder().add("info",param).build()
        val client = OkHttpClient()
        val request = Request.Builder()
                .post(formBoby)
                .url(url)
                .build()
        client.newCall(request).enqueue(object :Callback{
            override fun onFailure(call: Call?, e: IOException?) {
                //contexts.runOnUiThread { toast("请求失败") }
                res.getOnError(e?.message.toString())
            }
            override fun onResponse(call: Call?, response: Response?) {
                val result = response?.body()?.string()
                callback.invoke(result.toString())
            }
        })
    }

    //发起request post请求 无文件
    fun PostFile(url:String,params:String?,pathList:List<String>,contexts: Context,res: ResponseError,callback: (String) -> Unit){
        val requestBody = getRequestBody(pathList,params)
        val client = OkHttpClient()
        val request = Request.Builder()
                .post(requestBody)
                .url(url)
                .build()
        client.newCall(request).enqueue(object :Callback{
            override fun onFailure(call: Call?, e: IOException?) {
                //contexts.runOnUiThread { toast("请求失败") }
                res.getOnError(e?.message.toString())
            }
            override fun onResponse(call: Call?, response: Response?) {
                val result = response?.body()?.string()
                callback.invoke(result.toString())
            }
        })
    }

    private fun getRequestBody(FilePaths: List<String>,params:String?):RequestBody?{
        val builder = MultipartBody.Builder()
        //设置文件参数
        for (path in FilePaths){
            val file = File(path)
            val requestBody = RequestBody.create(MediaType.parse(TYPE),file)
            builder.addFormDataPart("filename",file.name, requestBody)
        }
        //设置参数
        builder.addFormDataPart("info",params)
        return  builder.build()
    }

}
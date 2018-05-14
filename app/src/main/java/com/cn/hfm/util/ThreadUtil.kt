package com.cn.hfm.util

import android.os.Handler
import android.os.Looper

/**
 * Created by dubaohui on 2018/5/11.
 */
object ThreadUtil {
    val handler = Handler(Looper.getMainLooper())
    //在主线程中执行
    fun RunOnThrean(runnable: Runnable){
        handler.post(runnable)
    }
}
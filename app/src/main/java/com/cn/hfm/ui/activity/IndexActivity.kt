package com.cn.hfm.ui.activity

import android.support.v4.view.ViewCompat
import android.support.v4.view.ViewPropertyAnimatorListener
import android.view.View
import com.cn.hfm.R
import com.cn.hfm.base.BaseActivity
import kotlinx.android.synthetic.main.activity_index.*

/**
 * Created by dubaohui on 2018/5/10.
 * 欢迎页面
 */
class IndexActivity: BaseActivity(), ViewPropertyAnimatorListener {

    override fun getLayoutId(): Int {
        return R.layout.activity_index
    }

    override fun initView() {
        //对首页图片添加缩放动画
        ViewCompat.animate(index_imageview)
                .scaleX(1.0f)
                .scaleY(1.0f) //图片还原比例
                .setListener(this) //监听
                .setDuration(2000) //时长
    }
    //动画开始
    override fun onAnimationStart(view: View?) {
    }
    //动画结束
    override fun onAnimationEnd(view: View?) {
        startActivityAndFinsh<MainActivity>()
    }
    //取消动画
    override fun onAnimationCancel(view: View?) {

    }


}
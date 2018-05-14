package com.cn.hfm.ui.activity
import android.support.v7.widget.Toolbar
import com.cn.hfm.R
import com.cn.hfm.base.BaseActivity
import com.cn.hfm.util.FragmentUtil
import com.cn.hfm.util.ToolBarManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.find
import org.jetbrains.anko.toast

class MainActivity : BaseActivity(),ToolBarManager {
    //使用懒加载方式 初始化toolbar
    override val toolbar by lazy { find<Toolbar>(R.id.toolbar) }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }
    override fun initView() {
        initMainTooBarMenu("Base",this)
    }

    override fun initListener() {
        //bottomBar点击事件
        bottomBar.setOnTabSelectListener {
            //it it可作为点击值
            var transaction = supportFragmentManager.beginTransaction()
            //将当前id为container的Fragmnet替换成点击的Fragment
            transaction.replace(R.id.container,FragmentUtil.fragmentUtil.getInstance(it),it.toString())
            transaction.commit()
        }
        //bottomBar连续点击两次事件
      /*  bottomBar.setOnTabReselectListener {
            toast("又一次点击:$it")
        }*/
    }

    override fun initData() {
    }

    override fun showBack(): Boolean {
        return false;
    }


}

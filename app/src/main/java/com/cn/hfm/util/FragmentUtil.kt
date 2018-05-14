package com.cn.hfm.util

import com.cn.hfm.R
import com.cn.hfm.base.BaseFragment
import com.cn.hfm.ui.fragment.TabThreeFragment
import com.cn.hfm.ui.fragment.TabOneFragment
import com.cn.hfm.ui.fragment.TabFourFragment
import com.cn.hfm.ui.fragment.TabTowFragment

/**
 * Created by dubaohui on 2018/5/10.
 *  利用单例模式 管理Fragment
 */
class FragmentUtil private constructor(){ //私有化构造方法
    val tabOneFragment by lazy { TabOneFragment() }
    val tabTowFragment by lazy { TabTowFragment() }
    val tabThreeFrament by lazy { TabThreeFragment() }
    val tabFourFragment by lazy { TabFourFragment() }

    //使用半身对象
    companion object {
        //by lazy 懒加载 线程安全 只会创建一次
        val fragmentUtil by lazy { FragmentUtil() }
    }

    //根据tabid获取对应的Fragment
    fun getInstance(tabId:Int): BaseFragment?{
        when(tabId){
            R.id.tab_toolbar1 -> return tabOneFragment
            R.id.tab_toolbar2 -> return tabTowFragment
            R.id.tab_toolbar3 -> return tabThreeFrament
            R.id.tab_toolbar4 -> return tabFourFragment
        }
        return null
    }
}
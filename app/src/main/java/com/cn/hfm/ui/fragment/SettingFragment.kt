package com.cn.hfm.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.preference.Preference
import android.preference.PreferenceFragment
import android.preference.PreferenceScreen
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cn.hfm.R
import com.cn.hfm.ui.activity.AboutActivity
import org.jetbrains.anko.toast

/**
 * Created by dubaohui on 2018/5/10.
 */
class SettingFragment: PreferenceFragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        addPreferencesFromResource(R.xml.setting)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onPreferenceTreeClick(preferenceScreen: PreferenceScreen?, preference: Preference?): Boolean {
        val key = preference?.key
        if ("clean_cache".equals(key)){
            toast("点了清除缓存")
        }
        if ("about".equals(key)) {
            activity.startActivity(Intent(context,AboutActivity::class.java))
        }
        return super.onPreferenceTreeClick(preferenceScreen, preference)
    }
}
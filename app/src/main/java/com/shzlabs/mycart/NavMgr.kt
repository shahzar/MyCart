package com.shzlabs.mycart

import android.app.Activity
import android.content.Intent
import androidx.fragment.app.FragmentActivity
import com.shzlabs.mycart.ui.base.BaseActivity
import com.shzlabs.mycart.ui.base.BaseFragment


class NavMgr {

    fun pushFragment(activity: FragmentActivity?, fragment: BaseFragment<*>, addToBackStack: Boolean = true) {
        (activity as? BaseActivity)?.let {
            pushFragment(it, fragment, addToBackStack)
        }
    }

    fun pushFragment(baseActivity: BaseActivity, baseFragment: BaseFragment<*>, addToBackStack: Boolean = true) {
        val transaction = baseActivity.supportFragmentManager.beginTransaction()

        transaction.replace(R.id.content, baseFragment, baseFragment.javaClass::getSimpleName.toString())

        if (addToBackStack) {
            transaction.addToBackStack(baseFragment.javaClass::getSimpleName.toString())
        }

        transaction.commit()
    }


    fun pop(baseActivity: BaseActivity): Boolean {

        if (baseActivity.supportFragmentManager.backStackEntryCount <= 1) {
            return false
        }

        baseActivity
            .supportFragmentManager
            .popBackStack()

        return true
    }
}
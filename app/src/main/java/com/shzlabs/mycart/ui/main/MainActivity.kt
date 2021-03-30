package com.shzlabs.mycart.ui.main

import androidx.lifecycle.ViewModelProvider
import com.shzlabs.mycart.NavMgr
import com.shzlabs.mycart.R
import com.shzlabs.mycart.ui.base.BaseActivity
import com.shzlabs.mycart.ui.cart.CartFragment
import javax.inject.Inject

class MainActivity : BaseActivity() {
    @Inject
    lateinit var navMgr: NavMgr

    private lateinit var viewModel: MainViewModel

    override fun getLayoutRes() = R.layout.activity_main

    override fun injectDependency() = getDiComponent().inject(this)

    override fun initViews() {
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        navMgr.pushFragment(this, CartFragment.newInstance(), false)
    }

    override fun setupObservers() {
        super.setupObservers()
    }

    override fun onBackPressed() {
        if(!navMgr.pop(this)) {
            finish()
        }
    }
}
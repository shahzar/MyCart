package com.shzlabs.mycart.ui.confirmation

import com.shzlabs.mycart.NavMgr
import com.shzlabs.mycart.R
import com.shzlabs.mycart.ui.base.BaseFragment
import javax.inject.Inject

class OrderConfirmationFragment : BaseFragment<OrderConfirmationViewModel>() {

    @Inject
    lateinit var navMgr: NavMgr

    companion object {
        fun newInstance() = OrderConfirmationFragment()
    }

    override fun getLayoutRes() = R.layout.fragment_order_confirmation
    override fun getViewModelClass() = OrderConfirmationViewModel::class.java
    override fun injectDependency() = getDiComponent().inject(this)

    override fun initViews() {
    }

    override fun setupObservers() {
        super.setupObservers()
    }

}

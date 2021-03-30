package com.shzlabs.mycart.ui.cart

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.shzlabs.mycart.NavMgr
import com.shzlabs.mycart.R
import com.shzlabs.mycart.ui.base.BaseFragment
import com.shzlabs.mycart.ui.confirmation.OrderConfirmationFragment
import com.shzlabs.mycart.ui.main.MainActivity
import kotlinx.android.synthetic.main.fragment_cart.*
import javax.inject.Inject

class CartFragment : BaseFragment<CartViewModel>() {

    @Inject
    lateinit var navMgr: NavMgr

    private var cartItemAdapter: CartItemAdapter? = null

    companion object {
        fun newInstance() = CartFragment()
    }

    override fun getLayoutRes() = R.layout.fragment_cart
    override fun getViewModelClass() = CartViewModel::class.java
    override fun injectDependency() = getDiComponent().inject(this)

    override fun initViews() {
        cartItemAdapter = CartItemAdapter()
        listItems.layoutManager = LinearLayoutManager(context)
        listItems.adapter = cartItemAdapter

        btnCheckout.setOnClickListener {
            checkout()
        }
    }

    override fun setupObservers() {
        super.setupObservers()
        viewModel.cartItems.observe(viewLifecycleOwner, Observer {
            cartItemAdapter?.submitList(it)
        })
    }

    private fun checkout() {
        fragmentManager?.let {
            val bottomSheetDialog = CheckoutBottomSheetDialog()
            bottomSheetDialog.show(it, "")

            bottomSheetDialog.setOnOrderConfirmedListener {
                orderConfirmed()
            }
        }
    }

    private fun orderConfirmed() {
        navMgr.pushFragment(activity, OrderConfirmationFragment.newInstance(), false)
    }

}

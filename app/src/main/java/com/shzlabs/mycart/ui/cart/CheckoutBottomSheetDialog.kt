package com.shzlabs.mycart.ui.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.shzlabs.mycart.R
import kotlinx.android.synthetic.main.dialog_checkout.*

class CheckoutBottomSheetDialog: BottomSheetDialogFragment() {

    var callback: (()->Unit)? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.dialog_checkout, container, false)
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()
    }

    private fun initView() {
        btnPlaceOrder.setOnClickListener {
            dismiss()
            callback?.invoke()
        }
    }

    fun setOnOrderConfirmedListener(callback: (()->Unit)) {
        this.callback = callback
    }

}
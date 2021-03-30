package com.shzlabs.mycart.ui.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.shzlabs.mycart.data.UserRepository
import com.shzlabs.mycart.data.model.CartModel
import com.shzlabs.mycart.ui.base.BaseViewModel
import javax.inject.Inject

class CartViewModel @Inject constructor (
    private val userRepository: UserRepository
) : BaseViewModel(){

    private val _cartItems = MutableLiveData<CartModel>()

    val cartItems: LiveData<CartModel>
        get() = _cartItems

    init {
        getCartItems()
    }

    fun getCartItems() {

        ioLaunch(
            block = {
                userRepository.getUserCartItems()
            },
            onSuccess = {
                _cartItems.value = it
            }
        )
    }


}

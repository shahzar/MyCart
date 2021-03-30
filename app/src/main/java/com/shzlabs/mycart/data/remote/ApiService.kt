package com.shzlabs.mycart.data.remote

import com.shzlabs.mycart.data.model.CartModel
import retrofit2.http.GET

interface ApiService {

    @GET("cart")
    suspend fun getCartItems(): CartModel


}
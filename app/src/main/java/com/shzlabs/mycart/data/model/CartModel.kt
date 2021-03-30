package com.shzlabs.mycart.data.model
import com.google.gson.annotations.SerializedName


class CartModel : ArrayList<CartModelItem>()

data class CartModelItem(
    @SerializedName("color")
    var color: String = "",
    @SerializedName("createdAt")
    var createdAt: String = "",
    @SerializedName("id")
    var id: String = "",
    @SerializedName("image")
    var image: String = "",
    @SerializedName("name")
    var name: String = "",
    @SerializedName("price")
    var price: String = ""
)
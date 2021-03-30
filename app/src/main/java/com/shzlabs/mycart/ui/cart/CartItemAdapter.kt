package com.shzlabs.mycart.ui.cart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.shzlabs.mycart.R
import com.shzlabs.mycart.data.model.CartModelItem
import com.shzlabs.mycart.util.Constants
import kotlinx.android.synthetic.main.item_cart.view.*

class CartItemAdapter: ListAdapter<CartModelItem, CartItemAdapter.CartItemViewHolder>(CartItemDiffUtilsCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartItemViewHolder {
        return CartItemViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: CartItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    class CartItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bind(data: CartModelItem) {
            itemView.txtItemName.text = data.name
            itemView.txtCurrency.text = Constants.currency
            itemView.txtItemPrice.text = data.price
        }

        companion object {
            fun from(parent: ViewGroup): CartItemViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val view = inflater.inflate(R.layout.item_cart, parent, false)
                return CartItemViewHolder(view)
            }
        }
    }


    class CartItemDiffUtilsCallback: DiffUtil.ItemCallback<CartModelItem>() {
        override fun areItemsTheSame(oldItem: CartModelItem, newItem: CartModelItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: CartModelItem, newItem: CartModelItem): Boolean {
            return oldItem == newItem
        }
    }
}

package com.lolblach333.onlineshop.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lolblach333.onlineshop.R
import com.lolblach333.onlineshop.db.dao.Goods
import kotlinx.android.synthetic.main.item_good.view.*

class GoodsAdapter(
    private val onClick: (Goods) -> Unit,
    private val onAddToCartClick: (Goods) -> Unit
) : ListAdapter<Goods, GoodsAdapter.ViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_good, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val ivGoodImage = itemView.ivGoodImage
        private val ivAddToCart = itemView.ivAddToCart
        private val tvPrice = itemView.tvPrice
        private val tvGoodName = itemView.tvGoodName
        private val clRoot = itemView.clRoot
        private val tvItemsInCart = itemView.tvItemsInCart

        fun bind(item: Goods) {
            ivGoodImage.load(item.url)

            tvItemsInCart.text = if (item.itemsInCart > 0) {
                item.itemsInCart.toString()
            } else {
                ""
            }

            ivAddToCart.setOnClickListener {
                onAddToCartClick(item)
            }

            tvGoodName.text = item.name
            tvPrice.text = "${item.price}$"

            clRoot.setOnClickListener {
                onClick(item)
            }

            clRoot.setBackgroundColor(itemView.context.getColor(item.color))
        }
    }

    private fun ImageView.load(url: String) {
        Glide.with(this).load(url).into(this)
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Goods>() {
            override fun areItemsTheSame(oldItem: Goods, newItem: Goods): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Goods, newItem: Goods): Boolean {
                return oldItem == newItem
            }
        }
    }
}

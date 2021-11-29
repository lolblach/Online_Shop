package com.lolblach333.onlineshop.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lolblach333.onlineshop.R
import com.lolblach333.onlineshop.db.dao.Category

class CategoriesAdapter(private val onClick: (Category) -> Unit) :
    ListAdapter<Category, CategoriesAdapter.ViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val ivCategoryPicture = itemView.findViewById<ImageView>(R.id.ivCategoryPicture)
        private val tvCategoryName = itemView.findViewById<TextView>(R.id.tvCategoryName)
        private val llCategory = itemView.findViewById<LinearLayout>(R.id.llCategory)

        fun bind(item: Category) {
            ivCategoryPicture.load(item.url)

            tvCategoryName.text = item.name

            llCategory.setOnClickListener {
                onClick(item)
            }
            llCategory.setBackgroundColor(itemView.context.getColor(item.color))
        }
    }

    private fun ImageView.load(url: String) {
        Glide.with(this).load(url).into(this)
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Category>() {
            override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
                return oldItem == newItem
            }
        }
    }
}
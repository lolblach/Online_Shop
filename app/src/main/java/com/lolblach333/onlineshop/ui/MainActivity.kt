package com.lolblach333.onlineshop.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.activity.viewModels
import com.lolblach333.onlineshop.R
import com.lolblach333.onlineshop.db.dao.Category
import com.lolblach333.onlineshop.db.dao.Goods
import com.lolblach333.onlineshop.ui.adapter.CategoriesAdapter
import com.lolblach333.onlineshop.ui.adapter.GoodsAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val viewModel by viewModels<MainViewModel>()

    private val categoriesAdapter by lazy {
        CategoriesAdapter { category ->
            getFoods(category)
        }
    }

    private val accountActivity by lazy {
        iv_shopping.setOnClickListener {
            Toast.makeText(this, "Item added to Goods cart", Toast.LENGTH_SHORT).show()
        }
        iv_account.setOnClickListener {
            Toast.makeText(this, "Item added to Goods cart", Toast.LENGTH_SHORT).show()
        }
    }

    private val goodsAdapter by lazy {
        GoodsAdapter(onClick = {
            // TODO Show new screen and pass id of good
        }, onAddToCartClick = {
            addGoodToCart(it)

            Toast.makeText(this, "Item added to Goods cart", Toast.LENGTH_SHORT).show()
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        iv_shopping.setOnClickListener {
            Toast.makeText(this, "В процессе разработки", Toast.LENGTH_SHORT).show()
        }
        iv_account.setOnClickListener {
            Toast.makeText(this, "В процессе разработки", Toast.LENGTH_SHORT).show()
        }
        initUI()
        fetchData()

    }

    private fun fetchData() {
        viewModel.getCategoriesDao().let {
            categoriesAdapter.submitList(it)
        }
    }

    private fun getFoods(category: Category) {
        viewModel.getGoodDao(category).let {
            goodsAdapter.submitList(it)
        }
    }

    private fun initUI() {
        rvCategories.adapter = categoriesAdapter
        rvGoods.adapter = goodsAdapter
    }

    private fun addGoodToCart(good: Goods) {
        goodsAdapter.currentList.map { if (it.id == good.id) it.copy(itemsInCart = it.itemsInCart.inc()) else it }
            .let { goodsAdapter.submitList(it) }
    }

}

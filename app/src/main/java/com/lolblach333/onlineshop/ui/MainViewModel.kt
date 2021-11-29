package com.lolblach333.onlineshop.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import com.lolblach333.onlineshop.R
import com.lolblach333.onlineshop.ShopApp
import com.lolblach333.onlineshop.db.dao.*

class MainViewModel : ViewModel() {

    private lateinit var cartGoods: CartGoodsDao
    private lateinit var categories: CategoriesDao
    private lateinit var goods: GoodsDao

    fun initDaos(context: Context) {
        cartGoods = (context.applicationContext as ShopApp).provideCartGoodsDao()
        goods = (context.applicationContext as ShopApp).provideGoodsDao()
        categories = (context.applicationContext as ShopApp).provideCategoriesDao()
    }

    fun getCartGoods(): List<CartGoods> {
        return cartGoods.getCartGoods()
    }

    fun getCategoriesDao(): List<Category> {
        return listOf(
            Category(1, "Клюшки", "https://pngimg.com/uploads/hockey/hockey_PNG67.png", R.color.purple_200),
            Category(2, "Велосипеды", "https://pngimg.com/uploads/bicycle/bicycle_PNG5374.png", R.color.purple_500),
            Category(3, "Мячики", "https://avatanplus.com/files/resources/original/57c1ce2dc0e44156cd0d62de.png", R.color.colorAccent),
            Category(4, "Бокс", "https://pngimg.com/uploads/boxing_gloves/boxing_gloves_PNG10463.png", R.color.colorPrimaryDark),
            Category(5, "Очки", "https://alpindustria.ru/i/product/l/-43666_2.png", R.color.colorAccent)
        )
    }

    fun getGoodDao(filterCategory: Category? = null): List<Goods> {
        val baseList = listOf(
            Goods(1, "Клюшка 'sport'", 7, 1, "https://pngimg.com/uploads/hockey/hockey_PNG102.png", R.color.purple_200),
            Goods(2, "Клюшка 'pro-sport-mega'", 10, 1, "https://static.wikia.nocookie.net/fallout/images/4/4d/FO76_Golf_club.png/revision/latest/scale-to-width-down/250?cb=20210224225708", R.color.purple_200),
            Goods(3, "Клюшка 'Антон'", 15, 1, "https://lh3.googleusercontent.com/proxy/XLjI9GzMREY_9VnCjvXjqxJRvIEioV6yxxz1Z2wZSHgT6svGTo97hkUjLGFKiwoCqjFiKg-9NpvOTTJJoW1z1g", R.color.purple_200),
            Goods(3, "Клюшка 'Winner'", 8, 1, "https://pngimg.com/uploads/hockey/hockey_PNG78.png", R.color.purple_200),

            Goods(4, "Велосипед 'Demix'", 175, 2, "https://pngimg.com/uploads/bicycle/bicycle_PNG5358.png", R.color.purple_500),
            Goods(5, "Велосипед 'Sport+'", 100, 2, "https://lh3.googleusercontent.com/proxy/4h_IjOseCXozyVFhkRglr_xuDsB1f0f1wzeaJkgChcKzVHoBH-Y0rGjNN56Y-HA2zQSKsAIqQqWpMB8bo0j5RcFkaY4", R.color.purple_500),
            Goods(6, "Велосипед 'Комфорт'", 350, 2, "https://bearbike.ru/upload/iblock/ced/ceda68b37b3db7e24b83feb9327c1e33.png", R.color.purple_500),
            Goods(7, "Велосипед 'Максим'", 100, 2, "https://skypka1.com/assets/images/bicycle-png-file-min.png", R.color.purple_500),
            Goods(8, "Велосипед 'MegaSport'", 178, 2, "https://luckybike.co/wp-content/uploads/2020/03/fran-bike.png", R.color.purple_500),

            Goods(9, "Мячик 'Баскетбол +'", 10, 3, "https://upload.wikimedia.org/wikipedia/commons/9/96/NEBL-Spalding-basket-ball.png", R.color.colorAccent),
            Goods(10, "Мячик Футбольный", 15, 3, "https://clipart-best.com/img/football/football-clip-art-48.png", R.color.colorAccent),
            Goods(11, "Мячик Волейбольный", 20, 3, "https://jogel.pro/upload/resize_cache/iblock/477/655_428_0/477071c4a5ee68398c736d9fd27f5fc1.png", R.color.colorAccent),
            Goods(12, "Мячик 'Александр'", 13, 3, "https://stdin.ru/upload/iblock/559/0223f6d5_77a3_11e9_80cd_002590a245fc_93b449b6_8374_11e9_80cd_002590a245fc.png", R.color.colorAccent),
            Goods(13, "Мячик 'Sport'", 21, 3, "https://upload.wikimedia.org/wikipedia/commons/thumb/7/7a/Basketball.png/220px-Basketball.png", R.color.colorAccent),

            Goods(14, "Перчатки 'Pro'", 15, 4, "https://kupitganteli.ru/image/cache/data/vidy-sporta/boks/110322173-perchatki-bokserskie-knockout-bgk-2266-14-oz-k-z-krasnyj-500x400.png", R.color.colorPrimaryDark),
            Goods(15, "Перчатки 'Бокс'", 21, 4, "https://pngimg.com/uploads/boxing_gloves/boxing_gloves_PNG10469.png", R.color.colorPrimaryDark),
            Goods(16, "Перчатки 'UFC'", 34, 4, "https://hasttings.ru/upload/shop_19/9/5/2/item_9524/small_item_9524.png", R.color.colorPrimaryDark),

            Goods(17, "Очки для плавания", 10, 5, "https://splashabout.ru/wa-data/public/shop/products/79/05/579/images/1072/1072.970.png", R.color.colorPrimaryDark),
            Goods(18, "Горнолыжные очки", 210, 5, "https://www.gssport.ru/sites/default/files/styles/product_image_on_product_page/public/img/products/main_photos/H602-3_new-scale-800-600.png?itok=fGKat8ne", R.color.colorPrimaryDark)

        )

        if (filterCategory != null) {
            return baseList.filter { it.category == filterCategory.id }
        }

        return baseList

//        return goods.getGoods()
    }
}
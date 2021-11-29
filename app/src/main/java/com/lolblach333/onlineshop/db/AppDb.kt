package com.lolblach333.onlineshop.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.lolblach333.onlineshop.db.dao.*

@Database(entities = [CartGoods::class, Goods::class, Category::class], version = 1)
abstract class AppDb : RoomDatabase() {

    abstract fun goodsDao(): GoodsDao
    abstract fun cartGoodsDao(): CartGoodsDao
    abstract fun categoriesDao(): CategoriesDao
}

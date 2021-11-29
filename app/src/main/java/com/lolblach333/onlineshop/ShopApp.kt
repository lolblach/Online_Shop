package com.lolblach333.onlineshop

import android.app.Application
import androidx.room.Room
import com.lolblach333.onlineshop.db.AppDb

class ShopApp : Application() {

    private val db by lazy {
        createDatabase()
    }

    private fun createDatabase(): AppDb {
        return Room.databaseBuilder(applicationContext, AppDb::class.java, "Online-shop").build()
    }

    fun provideCartGoodsDao() = db.cartGoodsDao()

    fun provideGoodsDao() = db.goodsDao()

    fun provideCategoriesDao() = db.categoriesDao()
}

package com.lolblach333.onlineshop.db.dao

import androidx.room.*

@Dao
interface CartGoodsDao {

    @Query("SELECT * FROM cartGoods")
    fun getCartGoods(): List<CartGoods>

    @Delete
    fun delete(item: CartGoods)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(item: CartGoods)
}

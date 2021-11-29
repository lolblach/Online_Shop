package com.lolblach333.onlineshop.db.dao

import androidx.room.*

@Dao
interface GoodsDao {

    @Query("SELECT * FROM goods")
    fun getGoods(): List<Goods>

    @Delete
    fun delete(item: Goods)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(item: Goods)
}

package com.lolblach333.onlineshop.db.dao

import androidx.room.*

@Dao
interface CategoriesDao {

    @Query("SELECT * FROM category")
    fun getCategory(): List<Category>

    @Delete
    fun delete(item: Category)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(item: Category)
}



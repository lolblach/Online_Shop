package com.lolblach333.onlineshop.db.dao

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "goods")
data class Goods(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String,
    val price: Int,
    val category: Long,
    val url: String,
    val color: Int,
    val itemsInCart: Int = 0
)

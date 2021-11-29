package com.lolblach333.onlineshop.db.dao

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "cartGoods")
data class CartGoods(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
)
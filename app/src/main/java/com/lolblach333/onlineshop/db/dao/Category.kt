package com.lolblach333.onlineshop.db.dao

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category")
data class Category(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String,
    val url: String,
    val color: Int
)
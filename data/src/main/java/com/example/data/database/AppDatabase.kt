package com.example.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.database.dao.FavoriteDao
import com.example.data.database.entity.Favorite

/**
 * Created by umiterkan on 1/3/2021
 */

@Database(entities = arrayOf(Favorite::class), version = 2, exportSchema = false)
abstract class AppDatabase  : RoomDatabase() {
    abstract fun favoriteDao() : FavoriteDao
}
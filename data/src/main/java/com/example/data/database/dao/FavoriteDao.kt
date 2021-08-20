package com.example.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.database.entity.Favorite
import kotlinx.coroutines.flow.Flow

/**
 * Created by umiterkan on 1/3/2021
 */
@Dao
interface FavoriteDao {

    @Query("SELECT * FROM favorite_table")
    suspend fun getFavorites(): List<Favorite>

    @Query("SELECT * FROM favorite_table where repo_id=:id")
    suspend fun getFavorite(id: Int): Favorite?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(favorite: Favorite)

    @Query("DELETE FROM favorite_table")
    suspend fun deleteAll()

    @Query("DELETE FROM favorite_table where repo_id=:id")
    suspend fun delete(id:Int)

    @Query("SELECT * FROM favorite_table ORDER BY repo_name ASC")
    fun getFavoritesFlow(): Flow<List<Favorite>>
}
package com.akshar.wallpaperchanger.data.database

import androidx.room.*
import com.akshar.wallpaperchanger.data.models.Wallpaper
import kotlinx.coroutines.flow.Flow

@Dao
interface WallpaperDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWallpaper(wallpaper: Wallpaper)

    @Delete
    suspend fun deleteWallpaper(wallpaper: Wallpaper)

    @Query("SELECT * FROM wallpapers ORDER BY addedAt DESC")
    fun getAllWallpapers(): Flow<List<Wallpaper>>

    @Query("SELECT * FROM wallpapers WHERE id = :wallpaperId")
    suspend fun getWallpaperById(wallpaperId: Int): Wallpaper?

    @Query("DELETE FROM wallpapers")
    suspend fun clearAllWallpapers()
}
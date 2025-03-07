package com.akshar.wallpaperchanger.data.repository

import com.akshar.wallpaperchanger.data.database.WallpaperDao
import com.akshar.wallpaperchanger.data.models.Wallpaper
import kotlinx.coroutines.flow.Flow

class WallpaperRepository(private val wallpaperDao: WallpaperDao) {

    fun getAllWallpapers(): Flow<List<Wallpaper>> = wallpaperDao.getAllWallpapers()

    suspend fun insertWallpaper(wallpaper: Wallpaper) {
        wallpaperDao.insertWallpaper(wallpaper)
    }

    suspend fun deleteWallpaper(wallpaper: Wallpaper) {
        wallpaperDao.deleteWallpaper(wallpaper)
    }

    suspend fun clearAllWallpapers() {
        wallpaperDao.clearAllWallpapers()
    }
}
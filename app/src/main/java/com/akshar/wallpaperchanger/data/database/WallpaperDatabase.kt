package com.akshar.wallpaperchanger.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.akshar.wallpaperchanger.data.models.Wallpaper

@Database(entities = [Wallpaper::class], version = 1, exportSchema = false)
abstract class WallpaperDatabase : RoomDatabase() {
    abstract fun wallpaperDao(): WallpaperDao
}
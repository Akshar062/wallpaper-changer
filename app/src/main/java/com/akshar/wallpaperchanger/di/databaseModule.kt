package com.akshar.wallpaperchanger.di

import android.app.Application
import androidx.room.Room
import com.akshar.wallpaperchanger.data.database.WallpaperDatabase
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            get<Application>(),
            WallpaperDatabase::class.java,
            "wallpaper_db"
        ).build()
    }

    single { get<WallpaperDatabase>().wallpaperDao() }
}
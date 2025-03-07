package com.akshar.wallpaperchanger

import android.app.Application
import com.akshar.wallpaperchanger.di.appModule
import com.akshar.wallpaperchanger.di.databaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class WallpaperChangerApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@WallpaperChangerApp)
            modules(appModule, databaseModule)
        }
    }
}
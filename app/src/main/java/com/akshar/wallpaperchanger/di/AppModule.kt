package com.akshar.wallpaperchanger.di

import com.akshar.wallpaperchanger.data.repository.WallpaperRepository
import com.akshar.wallpaperchanger.viewmodel.ImageSelectionViewModel
import com.akshar.wallpaperchanger.viewmodel.WallpaperViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { ImageSelectionViewModel(get()) }
    single {
        WallpaperRepository(get())
    }
    viewModel { WallpaperViewModel(get()) }
}
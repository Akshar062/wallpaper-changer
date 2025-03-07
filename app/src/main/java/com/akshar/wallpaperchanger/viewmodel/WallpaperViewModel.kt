package com.akshar.wallpaperchanger.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akshar.wallpaperchanger.data.models.Wallpaper
import com.akshar.wallpaperchanger.data.repository.WallpaperRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class WallpaperViewModel(private val repository: WallpaperRepository) : ViewModel() {

    val wallpapers: StateFlow<List<Wallpaper>> = repository.getAllWallpapers()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun addWallpaper(wallpaper: Wallpaper) {
        viewModelScope.launch {
            repository.insertWallpaper(wallpaper)
        }
    }

    fun removeWallpaper(wallpaper: Wallpaper) {
        viewModelScope.launch {
            repository.deleteWallpaper(wallpaper)
        }
    }
}
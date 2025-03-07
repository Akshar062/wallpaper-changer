package com.akshar.wallpaperchanger.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.akshar.wallpaperchanger.data.models.Wallpaper
import com.akshar.wallpaperchanger.viewmodel.WallpaperViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun WallpaperScreen(
    modifier: Modifier = Modifier,
    viewModel: WallpaperViewModel = koinViewModel()
) {
    val wallpapers by viewModel.wallpapers.collectAsState()

    Column(modifier = modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "Wallpapers Here", style = MaterialTheme.typography.headlineMedium)

        LazyColumn {
            items(wallpapers) { wallpaper ->
                WallpaperItem(wallpaper, viewModel::removeWallpaper)
            }
        }
    }
}

@Composable
fun WallpaperItem(wallpaper: Wallpaper, onRemove: (Wallpaper) -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = rememberAsyncImagePainter(wallpaper.uri),
            contentDescription = "Wallpaper",
            modifier = Modifier.size(100.dp)
        )

        Button(onClick = { onRemove(wallpaper) }) {
            Text("Remove")
        }
    }
}
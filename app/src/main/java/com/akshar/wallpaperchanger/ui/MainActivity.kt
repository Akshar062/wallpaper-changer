package com.akshar.wallpaperchanger.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.akshar.wallpaperchanger.ui.screens.WallpaperScreen
import com.akshar.wallpaperchanger.ui.theme.WallpaperChangerTheme
import com.akshar.wallpaperchanger.ui.utils.RequestImagePermission

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WallpaperChangerTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    RequestImagePermission {
                        WallpaperScreen(
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
                }
            }
        }
    }
}
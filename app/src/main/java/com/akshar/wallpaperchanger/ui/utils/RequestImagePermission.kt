package com.akshar.wallpaperchanger.ui.utils

import android.os.Build
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun RequestImagePermission(content: @Composable () -> Unit) {
    val permission = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
        android.Manifest.permission.READ_MEDIA_IMAGES
    else
        android.Manifest.permission.READ_EXTERNAL_STORAGE

    val permissionState = rememberPermissionState(permission)

    when {
        permissionState.status.isGranted -> {
            content()
        }
        permissionState.status.shouldShowRationale -> {
            Column(modifier = Modifier.height(200.dp)) {
                Text("This app needs access to your images to set wallpapers.")
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = { permissionState.launchPermissionRequest() }) {
                    Text("Grant Permission")
                }
            }
        }
        else -> {
            LaunchedEffect(Unit) {
                permissionState.launchPermissionRequest()
            }
            Text("Requesting permission...")
        }
    }
}
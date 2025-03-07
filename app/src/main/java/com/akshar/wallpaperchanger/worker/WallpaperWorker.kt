package com.akshar.wallpaperchanger.worker

import android.app.WallpaperManager
import android.content.Context
import android.net.Uri
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.akshar.wallpaperchanger.data.database.WallpaperDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.withContext
import java.io.InputStream

class WallpaperWorker(
    private val context: Context,
    params: WorkerParameters,
    private val wallpaperDao: WallpaperDao
) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
        return withContext(Dispatchers.IO) {
            try {
                // Get the next scheduled wallpaper
                val wallpapers = wallpaperDao.getAllWallpapers()
                val wallpaper = wallpapers.firstOrNull() ?: return@withContext Result.failure()

//                val uri = Uri.parse(wallpaper.)
//                setWallpaper(uri)
                Result.success()
            } catch (e: Exception) {
                e.printStackTrace()
                Result.failure()
            }
        }
    }

    private fun setWallpaper(uri: Uri) {
        val wallpaperManager = WallpaperManager.getInstance(context)
        val inputStream: InputStream? = context.contentResolver.openInputStream(uri)
        inputStream?.use {
            wallpaperManager.setStream(it)
        }
    }
}
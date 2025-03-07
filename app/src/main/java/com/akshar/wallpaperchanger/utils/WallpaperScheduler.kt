package com.akshar.wallpaperchanger.utils

import android.content.Context
import androidx.work.*
import com.akshar.wallpaperchanger.worker.WallpaperWorker
import java.util.concurrent.TimeUnit

object WallpaperScheduler {

    fun scheduleWallpaperChange(context: Context, delay: Long, repeatInterval: Long) {
        val workRequest = PeriodicWorkRequestBuilder<WallpaperWorker>(
            repeatInterval, TimeUnit.MILLISECONDS
        )
            .setInitialDelay(delay, TimeUnit.MILLISECONDS)
            .setConstraints(
                Constraints.Builder()
                    .setRequiresBatteryNotLow(true)
                    .build()
            )
            .build()

        WorkManager.getInstance(context).enqueueUniquePeriodicWork(
            "WallpaperChange",
            ExistingPeriodicWorkPolicy.UPDATE,
            workRequest
        )
    }
}
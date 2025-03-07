package com.akshar.wallpaperchanger.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wallpapers")
data class Wallpaper(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val uri: String,  // Stored as a String (Uri.toString())
    val addedAt: Long = System.currentTimeMillis(),
    val scheduleTime: Long? = null, // Time in millis for scheduled change (nullable)
    val repeatInterval: RepeatInterval = RepeatInterval.NONE, // Recurrence type
    val screenType: ScreenType = ScreenType.HOME // Home, Lock, or Both
)

/** Enum for defining wallpaper screen type */
enum class ScreenType {
    HOME, LOCK, BOTH
}

/** Enum for scheduling recurrence */
enum class RepeatInterval {
    NONE, DAILY, WEEKLY, MONTHLY, CUSTOM
}
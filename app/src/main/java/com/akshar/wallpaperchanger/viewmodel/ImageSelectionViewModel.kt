package com.akshar.wallpaperchanger.viewmodel

import android.content.Context
import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.File
import java.io.FileOutputStream

class ImageSelectionViewModel(
    private val context: Context
) : ViewModel() {

    private val _selectedImages = MutableStateFlow<List<Uri>>(emptyList())
    val selectedImages = _selectedImages.asStateFlow()

    /**
     * Copies the selected images to the app's internal storage.
     * Updates the state with copied URIs.
     */
    fun copyImagesToAppFolder(uris: List<Uri>) {
        viewModelScope.launch(Dispatchers.IO) {
            val copiedUris = uris.mapNotNull { sourceUri ->
                copyImageToAppFolder(context, sourceUri)
            }
            _selectedImages.value = copiedUris
        }
    }

    /**
     * Copies a single image from the sourceUri to the app's internal storage.
     */
    private fun copyImageToAppFolder(context: Context, sourceUri: Uri): Uri? {
        return try {
            context.contentResolver.openInputStream(sourceUri)?.use { inputStream ->
                val fileName = "wallpaper_${System.currentTimeMillis()}.jpg"
                val file = File(context.filesDir, fileName)
                FileOutputStream(file).use { outputStream ->
                    inputStream.copyTo(outputStream)
                }
                Uri.fromFile(file)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}
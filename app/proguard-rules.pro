# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

# Keep class names for debugging
-keepattributes SourceFile,LineNumberTable

# Don't remove annotations (important for libraries and reflection)
-keepattributes *Annotation*

# Keep all classes in the application package
-keep class com.akshar.wallpaperchanger.** { *; }

# Jetpack Compose (keep all classes used in UI)
-keep class androidx.compose.** { *; }
-dontwarn androidx.compose.**

# AndroidX (Keep Lifecycle, ViewModel, Room, WorkManager, etc.)
-keep class androidx.lifecycle.** { *; }
-keep class androidx.room.** { *; }
-keep class androidx.work.** { *; }
-dontwarn androidx.work.**

# Prevent obfuscation of Retrofit and Moshi models (if using them)
-keep class com.squareup.retrofit2.** { *; }
-keep class com.squareup.moshi.** { *; }
-dontwarn com.squareup.retrofit2.**

# Prevent obfuscation of Glide (if using it for image loading)
-keep class com.bumptech.glide.** { *; }
-dontwarn com.bumptech.glide.**

# Keep DI classes (Koin / Dagger-Hilt)
-keep class org.koin.** { *; }
-keep class dagger.hilt.** { *; }
-dontwarn dagger.hilt.**

# Keep WorkManager jobs (if using)
-keep class androidx.work.Worker { *; }
-keep class androidx.work.WorkManager { *; }

# Keep Room database models (if using)
-keep class androidx.room.** { *; }

# Prevent R8 from removing logging
-assumenosideeffects class android.util.Log {
    public static *** d(...);
    public static *** v(...);
    public static *** i(...);
}

# General optimizations
-optimizationpasses 5
-dontpreverify
-allowaccessmodification
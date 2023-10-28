package com.example.homeworkgallery

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

enum class Photos(@DrawableRes val image : Int , @StringRes val title : Int ) {
    FOREST_PHONE(R.drawable.img , R.string.forest_phone),
    MOUNTAINS(R.drawable.img_1 , R.string.mountains),
    SUNSET(R.drawable.img_2 , R.string.sunset)
}
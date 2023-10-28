package com.example.homeworkgallery

import android.view.View
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs

class ZoomTransformer: ViewPager2.PageTransformer {
    override fun transformPage(page: View, position: Float) {
        val scale = if (position< 0) position + 1 else abs(1 - position)

        page.scaleY = scale
        page.scaleX = scale

        page.pivotX = page.width * 0.5f
        page.pivotY = page.height * 0.5f

        page.alpha = if (position < -1 || position > 1) 0f else 1f - (scale - 1)
    }
}
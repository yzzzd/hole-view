package com.yzzzd.kelasindustri.widget

import android.graphics.Canvas

abstract class HoleDrawer(protected var mBackgroundColor: Int, protected var mHoleRadius: Int) {
    abstract fun draw(c: Canvas?, width: Int, height: Int, x: Int, y: Int)
}
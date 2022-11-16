package com.yzzzd.kelasindustri.widget

import android.graphics.*

class BitmapHoleDrawer(backgroundColor: Int, holeRadius: Int) : HoleDrawer(backgroundColor, holeRadius) {

    private var mBitmap: Bitmap? = null
    private var mWidth = 0
    private var mHeight = 0
    private var mX = 0
    private var mY = 0

    private fun prepareBitmap(width: Int, height: Int, x: Int, y: Int) {
        if (mWidth != width || mHeight != height || mX != x || mY != y) {
            mWidth = width
            mHeight = height
            mX = x
            mY = y
            mBitmap = Bitmap.createBitmap(mWidth, mHeight, Bitmap.Config.ARGB_8888)
            mBitmap?.eraseColor(Color.TRANSPARENT)
            val c = Canvas(mBitmap ?: return)
            c.drawColor(mBackgroundColor)
            val p = Paint(Paint.ANTI_ALIAS_FLAG)
            p.style = Paint.Style.FILL
            p.color = -0x1
            p.xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)
            /*c.drawCircle(mX.toFloat(), mY.toFloat(), mHoleRadius.toFloat(), p)*/

            val rect = RectF(24f, 12f, width.toFloat() - 24f, height.toFloat() - 12f)
            c.drawRoundRect(rect, mHoleRadius.toFloat(), mHoleRadius.toFloat(), p)
        }
    }

    override fun draw(c: Canvas?, width: Int, height: Int, x: Int, y: Int) {
        prepareBitmap(width, height, x, y)
        c?.drawBitmap(mBitmap ?: return, 0f, 0f, null)
    }
}
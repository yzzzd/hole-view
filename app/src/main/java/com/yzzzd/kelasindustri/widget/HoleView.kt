package com.yzzzd.kelasindustri.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import androidx.databinding.BindingAdapter

class HoleView : View {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes)

    private var mDrawer: HoleDrawer? = null

    private fun init(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) {
        setWillNotDraw(false)
    }

    fun setDrawer(drawer: HoleDrawer) {
        mDrawer = drawer
        invalidate()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        if (mDrawer != null) {
            mDrawer?.draw(canvas, width, height, width / 2, height / 2)
        }
    }

    companion object {
        @JvmStatic
        @BindingAdapter("holeRadius")
        fun holeRadius(holeDrawer: HoleView, holeRadius: Int?) {
            holeRadius?.let {
                holeDrawer.setDrawer(BitmapHoleDrawer(Color.WHITE, holeRadius))
            }
        }
    }
}
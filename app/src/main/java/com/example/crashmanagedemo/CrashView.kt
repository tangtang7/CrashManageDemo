package com.example.crashmanagedemo

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import org.jetbrains.annotations.Nullable

class CrashView : AppCompatImageView {
    constructor(context: Context): super(context) { }

    constructor(context: Context, @Nullable attrs: AttributeSet?): super(context, attrs) { }

    constructor(context: Context, @Nullable attrs: AttributeSet?, defStyleAttr: Int): super(context, attrs, defStyleAttr) { }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        throw NullPointerException("onMeasure 崩溃");
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
//        throw NullPointerException("onLayout 崩溃");
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
//        throw NullPointerException("onDraw 崩溃");
    }
}
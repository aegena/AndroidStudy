package com.campanula.study.components

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.annotation.Nullable

class InitialView @JvmOverloads constructor(
    context: Context,
    @Nullable attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val mPaint: Paint
    private val color = Color.RED

    init {
        mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        mPaint.color = color
        mPaint.strokeWidth = 1.5.toFloat()

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val paddingTop = paddingTop
        val paddingBottom = paddingBottom
        val paddingStart = paddingStart
        val paddingEnd = paddingEnd
        val width = width - paddingStart - paddingEnd
        val height = height - paddingTop - paddingBottom
        canvas?.drawRect(
            paddingStart.toFloat(),
            paddingTop.toFloat(),
            width + paddingStart.toFloat(),
            height + paddingTop.toFloat(),
            mPaint
        )
    }
}
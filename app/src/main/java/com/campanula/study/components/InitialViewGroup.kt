package com.campanula.study.components

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.VelocityTracker
import android.view.View
import android.view.ViewGroup
import android.widget.Scroller

class InitialViewGroup @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ViewGroup(context, attrs, defStyleAttr) {

    private val scroller: Scroller
    private val tracker: VelocityTracker

    init {
        scroller = Scroller(context)
        tracker = VelocityTracker.obtain()

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)

        measureChildren(widthMeasureSpec, heightMeasureSpec)

        if (childCount == 0) {
            setMeasuredDimension(0, 0)
        } else if (widthMode == MeasureSpec.AT_MOST && heightMode == MeasureSpec.AT_MOST) {
            val childView = getChildAt(0)
            val childWidth = childView.measuredWidth
            val childHeight = childView.measuredHeight

            setMeasuredDimension(
                childWidth * childCount,
                childHeight
            )
        } else if (widthMode == MeasureSpec.AT_MOST) {
            val childView = getChildAt(0)
            val childWidth = childView.measuredWidth
            setMeasuredDimension(
                childWidth * childCount,
                heightSize
            )
        } else if (heightMode == MeasureSpec.AT_MOST) {
            val childView = getChildAt(0)
            val childHeight = childView.measuredHeight
            setMeasuredDimension(widthSize, childHeight)
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        }


    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        val childCount = childCount
        var left: Int = 0
        for (index in 0 until childCount) {
            val childView = getChildAt(index)
            if (childView.visibility == View.GONE) continue
            val width = childView.measuredWidth
            childView.layout(left, 0, left + width, childView.measuredHeight)
            left += width
        }

    }

    private var lastInterceptX = 0
    private var lastInterceptY = 0
    private var lastX = 0
    private var lastY = 0


    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        return ev?.let {
            var intercept = false
            var x = it.x
            var y = it.y
            when (it.action) {
                MotionEvent.ACTION_DOWN -> {
                    intercept = false
                    if (!scroller.isFinished) {
                        scroller.abortAnimation()
                    }
                }
                MotionEvent.ACTION_MOVE -> {
                    val deltaX = x - lastInterceptX
                    val deltaY = y - lastInterceptY
                    if (Math.abs(deltaX) - Math.abs(deltaY) > 0) {
                        intercept = true
                    }
                }
                MotionEvent.ACTION_UP -> {
                    intercept = false
                }
            }
            lastInterceptX = x.toInt()
            lastInterceptY = y.toInt()

            lastX = x.toInt()
            lastY = y.toInt()

            intercept
        } ?: kotlin.run {
            super.onInterceptTouchEvent(ev)
        }

    }

    private var currentIndex = 0
    private var childWidth = 0

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        childWidth = getChildAt(0).measuredWidth
        event?.let {

            val x = it.x.toInt()
            val y = it.y.toInt()

            when (it.action) {
                MotionEvent.ACTION_DOWN -> {

                }
                MotionEvent.ACTION_MOVE -> {
                    val deltaX = x - lastX
                    scrollBy(-deltaX, 0)
                }
                MotionEvent.ACTION_UP -> {
                    val distance = scrollX - (currentIndex * childWidth)
                    if (Math.abs(distance) > childWidth / 2) {
                        if (distance > 0) {
                            currentIndex++
                        } else {
                            currentIndex--
                        }
                    } else {
                        tracker.computeCurrentVelocity(1000)
                        val xV = tracker.xVelocity
                        if (Math.abs(xV) > 50) {
                            if (xV > 0) {
                                currentIndex--
                            } else {
                                currentIndex++
                            }
                        }
                    }
                    currentIndex = when {
                        currentIndex < 0 -> {
                            0
                        }
                        currentIndex > childCount - 1 -> {
                            childCount - 1
                        }
                        else -> currentIndex
                    }
                    smoothScrollTo(currentIndex * childWidth, 0)
                    tracker.clear()
                }
            }

            lastX = x
            lastY = y

        }
        return super.onTouchEvent(event)
    }

    override fun computeScroll() {
        super.computeScroll()
        if (scroller.computeScrollOffset()) {
            scrollTo(scroller.currX, scroller.currY)
            postInvalidate()
        }
    }

    private fun smoothScrollTo(destX: Int, destY: Int) {
        scroller.startScroll(scrollX, scrollY, destX - scrollX, destY - scrollY, 1000)
        invalidate()
    }


}
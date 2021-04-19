package com.example.tmt

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PointF
import android.util.AttributeSet
import android.view.View

class LineView : View {
    private val paint = Paint()

    private var pointA: PointF? = null
    private var pointB: PointF? = null

    constructor(context: Context?) : super(context) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(
        context,
        attrs
    ) {
    }

    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int
    ) : super(context, attrs, defStyleAttr) {
    }


    override fun onDraw(canvas: Canvas) {


        paint.color = Color.GREEN
        paint.strokeWidth = 10f
        canvas.drawLine(pointA?.x!!,pointA!!.y,pointB!!.x,pointB!!.y, paint)
        super.onDraw(canvas)

    }

    fun setPointA(point: PointF) {
        pointA = point
    }

    fun setPointB(point: PointF) {
        pointB = point
    }



    // Validate the points
    fun draw() {
        invalidate()
        requestLayout()
    }
}


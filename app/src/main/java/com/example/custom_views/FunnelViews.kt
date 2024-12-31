package com.example.custom_views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class FunnelViews  @JvmOverloads constructor(ctx: Context, attrSet: AttributeSet? = null, defStyleAttr : Int = 0, defStyleRes:Int =0): View(ctx,attrSet,defStyleAttr,defStyleRes)  {
    private var path = Path()


    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.RED
        style = Paint.Style.STROKE
        strokeWidth = 10f
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        drawCup(canvas)
    }

    private fun drawCup(canvas: Canvas){
        path.addOval(RectF(0.2f * width,0.3f * height,0.8f * width,0.33f * height),Path.Direction.CW)
        path.moveTo(0.2f * width, 0.33f * height)
        path.lineTo(0.8f * width, 0.33f * height)
        path.lineTo(0.5f * width, 0.66f * height)
        path.lineTo(0.2f * width, 0.33f * height)

        canvas.drawPath(path, paint)
    }

}
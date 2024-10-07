package com.example.custom_views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

class PathViews  @JvmOverloads constructor(ctx:Context,attrSet: AttributeSet ? = null, defStyleAttr : Int = 0, defStyleRes:Int =0): View(ctx,attrSet,defStyleAttr,defStyleRes) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.RED
    }
    private val paint2 = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.RED
        style = Paint.Style.STROKE
    }

    private val path = Path()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        drawFillX(canvas)
        drawArc(canvas)
    }


    private  fun drawFillX(canvas: Canvas){
        path.moveTo(0.1f * width, 0.1f * height)
        path.lineTo(0.1f * width, 0.5f * height)
        path.lineTo(0.9f * width, 0.1f * height)
        path.lineTo(0.9f * width, 0.5f * height)
        canvas.drawPath(path, paint)
    }

    private fun drawArc(canvas: Canvas){
        canvas.drawArc(0.1f * width, 0.6f * height,0.9f * width,0.9f * height,180f,90f,true,paint)
    }

}
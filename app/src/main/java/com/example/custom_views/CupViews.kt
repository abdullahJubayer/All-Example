package com.example.custom_views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class CupViews  @JvmOverloads constructor(ctx: Context, attrSet: AttributeSet? = null, defStyleAttr : Int = 0, defStyleRes:Int =0): View(ctx,attrSet,defStyleAttr,defStyleRes)  {
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
        path.addOval(RectF(0.4f * width,0.3f * height,0.6f * width,0.34f * height),Path.Direction.CW)
        path.moveTo(0.4f * width, 0.32f * height)
        path.lineTo(0.4f * width, 0.4f * height)
        path.lineTo(0.5f * width, 0.44f * height)
        path.lineTo(0.6f * width, 0.4f * height)
        path.lineTo(0.6f * width, 0.32f * height)
        path.moveTo(0.4f * width, 0.35f * height)
        path.quadTo(0.3f * width, 0.36f * height,0.4f * width, 0.38f * height)

        path.moveTo(0.6f * width, 0.35f * height)
        path.quadTo(0.7f * width, 0.36f * height,0.6f * width, 0.38f * height)
        path.moveTo(0.45f * width, 0.36f * height)
        path.addCircle(0.45f * width, 0.37f * height, 10f, Path.Direction.CW)
        path.addCircle(0.55f * width, 0.37f * height, 10f, Path.Direction.CW)

        path.moveTo(0.5f * width, 0.36f * height)
        path.lineTo(0.5f * width, 0.39f * height)

        path.moveTo(0.45f * width, 0.38f * height)
        path.addArc(RectF(0.4f * width, 0.35f * height ,0.6f * width, 0.4f * height),60f,60f)

        canvas.drawPath(path, paint)
    }

}
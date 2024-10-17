package com.example.custom_views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.PointF
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.example.allaboutservice.R

class SunView  @JvmOverloads constructor(ctx: Context, attrSet: AttributeSet? = null, defStyleAttr : Int = 0, defStyleRes:Int =0): View(ctx,attrSet,defStyleAttr,defStyleRes)  {
    private val sunImage: Drawable? = ContextCompat.getDrawable(context, R.drawable.baseline_sunny)
    private var sunPointF = PointF()
    private var percentage = 0.0

    private val paint = Paint().apply {
        color = Color.GREEN
        style = Paint.Style.FILL
        isAntiAlias = true
        textSize = 40f
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        sunPointF=getXYofAngle(180.0, 0.4f * width)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        drawSun(canvas)
        drawText(canvas)
    }

    private fun drawSun(canvas: Canvas) {
        paint.apply {
            color = Color.GREEN
        }
        for (i in 180.. (180 + percentage).toInt()) {
            if ((i - 180) % 10 < 5) {
                val points = getXYofAngle(i.toDouble(), 0.4f * width)
                canvas.drawCircle(points.x, points.y, 5f, paint)
            }
        }

        paint.apply {
            color = Color.GRAY
        }
        for (i in (180 + percentage).toInt()..364) {
            if ((i - 180) % 10 < 5) {
                val points = getXYofAngle(i.toDouble(), 0.4f * width)
                canvas.drawCircle(points.x, points.y, 5f, paint)
            }
        }

        sunImage?.setBounds(
            sunPointF.x.toInt() - 50, sunPointF.y.toInt() - 50,
            sunPointF.x.toInt() + 50, sunPointF.y.toInt() + 50
        )
        sunImage?.draw(canvas)
    }

    private fun drawText(canvas: Canvas){
        val textBounds = Rect()
        paint.also {
            it.color = Color.GREEN
            it.textSize = 50f
            it.getTextBounds("07:09 AM", 0, "07:09 AM".length, textBounds)
        }
        var x = 0.1f * width - (textBounds.width() / 2f)
        canvas.drawText("07:09 AM",x,0.51f * height + 100f,paint)

        paint.also {
            it.color = Color.GRAY
            it.textSize = 30f
            it.getTextBounds("Sunrise", 0, "Sunrise".length, textBounds)
        }
        x = 0.1f * width - (textBounds.width() / 2f)
        canvas.drawText("Sunrise",x,0.51f * height + 150f,paint)


        paint.also {
            it.color = Color.GREEN
            it.textSize = 50f
            it.getTextBounds("07:09 AM", 0, "07:09 AM".length, textBounds)
        }
        x = 0.9f * width - (textBounds.width() / 2f)
        canvas.drawText("07:09 AM",x,0.51f * height + 100f,paint)

        paint.also {
            it.color = Color.GRAY
            it.textSize = 30f
            it.getTextBounds("Sunset", 0, "Sunset".length, textBounds)
        }
        x = 0.9f * width - (textBounds.width() / 2f)
        canvas.drawText("Sunset",x,0.51f * height + 150f,paint)
    }

    private fun getXYofAngle(angle: Double, radius: Float): PointF {
        val radians = Math.toRadians(angle)
        val x = (radius * Math.cos(radians) + width / 2f).toFloat()
        val y = (radius * Math.sin(radians) + height / 2f).toFloat()
        return PointF(x, y)
    }

    fun moveSun(progress : Int){
        percentage = 180.0 * (progress / 100.0)
        sunPointF = getXYofAngle(180.0 + percentage , 0.4f * width)
        invalidate()
    }

}
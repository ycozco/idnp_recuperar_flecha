package com.example.progreso

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat

class CustomView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint().apply {
        isAntiAlias = true
        style = Paint.Style.FILL // Cambiamos a relleno
    }

    private val colors = arrayOf(
        ContextCompat.getColor(context, R.color.color1),
        ContextCompat.getColor(context, R.color.color2),
        ContextCompat.getColor(context, R.color.color3),
        ContextCompat.getColor(context, R.color.color4),
        ContextCompat.getColor(context, R.color.color5)
    )

    private var progress = 0

    fun reiniciar() {
        progress = 0
        invalidate()
    }

    fun avanzar() {
        if (progress < colors.size) {
            progress++
            invalidate()
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val separation = 2 // Separación de 2px entre flechas
        val totalSeparation = separation * (colors.size - 1)
        val arrowWidth = (width - totalSeparation) / colors.size.toFloat()

        for (i in 0 until progress) {
            paint.color = colors[i]
            val startX = i * (arrowWidth + separation)
            drawArrow(canvas, startX, 0f, startX + arrowWidth, height.toFloat())
        }
    }


    }
}

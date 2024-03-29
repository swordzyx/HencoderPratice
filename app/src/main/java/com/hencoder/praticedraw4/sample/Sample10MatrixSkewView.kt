package com.hencoder.praticedraw4.sample

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Matrix
import android.graphics.Paint
import android.graphics.Point
import android.util.AttributeSet
import android.view.View
import androidx.annotation.Nullable
import com.hencoder.hencoderpratice.R

class Sample10MatrixSkewView : View {
  var paint = Paint(Paint.ANTI_ALIAS_FLAG)
  var bitmap: Bitmap? = null
  var point1 = Point(200, 200)
  var point2 = Point(600, 200)
  var matrix1 = Matrix()

  constructor(context: Context?) : super(context)
  constructor(context: Context?, @Nullable attrs: AttributeSet?) : super(context, attrs)
  constructor(context: Context?, @Nullable attrs: AttributeSet?, defStyleAttr: Int) : super(
    context,
    attrs,
    defStyleAttr
  )

  init {
    bitmap = BitmapFactory.decodeResource(resources, R.mipmap.maps)
  }

  override fun onDraw(canvas: Canvas) {
    super.onDraw(canvas)
    val bitmapWidth = bitmap!!.width
    val bitmapHeight = bitmap!!.height
    canvas.save()
    matrix1.reset()
    matrix1.postSkew(
      0f,
      0.5f,
      (point1.x + bitmapWidth / 2).toFloat(),
      (point1.y + bitmapHeight / 2).toFloat()
    )
    canvas.concat(matrix1)
    canvas.drawBitmap(bitmap!!, point1.x.toFloat(), point1.y.toFloat(), paint)
    canvas.restore()
    canvas.save()
    matrix1.reset()
    matrix1.postSkew(
      -0.5f,
      0f,
      (point2.x + bitmapWidth / 2).toFloat(),
      (point2.y + bitmapHeight / 2).toFloat()
    )
    canvas.concat(matrix1)
    canvas.drawBitmap(bitmap!!, point2.x.toFloat(), point2.y.toFloat(), paint)
    canvas.restore()
  }
}
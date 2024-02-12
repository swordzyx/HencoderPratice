package com.hencoder.praticedraw4.sample

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Camera
import android.graphics.Canvas
import android.graphics.Matrix
import android.graphics.Paint
import android.graphics.Point
import android.util.AttributeSet
import android.view.View
import androidx.annotation.Nullable
import com.hencoder.hencoderpratice.R

class Sample12CameraRotateFixedView : View {
  var paint = Paint(Paint.ANTI_ALIAS_FLAG)
  var bitmap: Bitmap? = null
  var point1 = Point(200, 200)
  var point2 = Point(600, 200)
  var camera = Camera()
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
    val center1X = point1.x + bitmapWidth / 2
    val center1Y = point1.y + bitmapHeight / 2
    val center2X = point2.x + bitmapWidth / 2
    val center2Y = point2.y + bitmapHeight / 2
    camera.save()
    matrix1.reset()
    camera.rotateX(30f)
    camera.getMatrix(matrix1)
    camera.restore()
    matrix1.preTranslate(-center1X.toFloat(), -center1Y.toFloat())
    matrix1.postTranslate(center1X.toFloat(), center1Y.toFloat())
    canvas.save()
    canvas.concat(matrix1)
    canvas.drawBitmap(bitmap!!, point1.x.toFloat(), point1.y.toFloat(), paint)
    canvas.restore()
    camera.save()
    matrix1.reset()
    camera.rotateY(30f)
    camera.getMatrix(matrix1)
    camera.restore()
    matrix1.preTranslate(-center2X.toFloat(), -center2Y.toFloat())
    matrix1.postTranslate(center2X.toFloat(), center2Y.toFloat())
    canvas.save()
    canvas.concat(matrix1)
    canvas.drawBitmap(bitmap!!, point2.x.toFloat(), point2.y.toFloat(), paint)
    canvas.restore()
  }
}
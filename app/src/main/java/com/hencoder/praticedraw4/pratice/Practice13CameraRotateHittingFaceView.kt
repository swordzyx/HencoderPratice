package com.hencoder.praticedraw4.pratice

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
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
import android.view.animation.LinearInterpolator
import com.hencoder.hencoderpratice.R

class Practice13CameraRotateHittingFaceView : View {
  var paint = Paint(Paint.ANTI_ALIAS_FLAG)
  var bitmap: Bitmap? = null
  var point = Point(200, 50)
  private var camera = Camera()
  private var matrix1 = Matrix()
  private var degree = 0
  private var animator: ObjectAnimator = ObjectAnimator.ofInt(this, "degree", 0, 360)

  constructor(context: Context?) : super(context)
  constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
  constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
    context,
    attrs,
    defStyleAttr
  )

  init {
    bitmap = BitmapFactory.decodeResource(resources, R.mipmap.maps)
    val scaledBitmap = Bitmap.createScaledBitmap(
      bitmap!!, bitmap!!.width * 2, bitmap!!.height * 2, true
    )
    bitmap!!.recycle()
    bitmap = scaledBitmap
    animator.duration = 5000
    animator.interpolator = LinearInterpolator()
    animator.repeatCount = ValueAnimator.INFINITE
  }

  override fun onAttachedToWindow() {
    super.onAttachedToWindow()
    animator.start()
  }

  override fun onDetachedFromWindow() {
    super.onDetachedFromWindow()
    animator.end()
  }

  @Suppress("unused")
  fun setDegree(degree: Int) {
    this.degree = degree
    invalidate()
  }

  override fun onDraw(canvas: Canvas) {
    super.onDraw(canvas)
    val bitmapWidth = bitmap!!.width
    val bitmapHeight = bitmap!!.height
    val centerX = point.x + bitmapWidth / 2
    val centerY = point.y + bitmapHeight / 2
    camera.save()
    matrix1.reset()
    camera.rotateX(degree.toFloat())
    camera.getMatrix(matrix1)
    camera.restore()
    matrix1.preTranslate(-centerX.toFloat(), -centerY.toFloat())
    matrix1.postTranslate(centerX.toFloat(), centerY.toFloat())
    canvas.save()
    canvas.concat(matrix1)
    canvas.drawBitmap(bitmap!!, point.x.toFloat(), point.y.toFloat(), paint)
    canvas.restore()
  }
}
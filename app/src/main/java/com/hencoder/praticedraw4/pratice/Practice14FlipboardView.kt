package com.hencoder.praticedraw4.pratice

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Camera
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator
import com.hencoder.hencoderpratice.R

class Practice14FlipboardView : View {
  var paint = Paint(Paint.ANTI_ALIAS_FLAG)
  var bitmap: Bitmap? = null
  private var camera = Camera()
  private var degree = 0
  private var animator: ObjectAnimator = ObjectAnimator.ofInt(this, "degree", 0, 180)

  constructor(context: Context?) : super(context)
  constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
  constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
    context,
    attrs,
    defStyleAttr
  )

  init {
    bitmap = BitmapFactory.decodeResource(resources, R.mipmap.maps)
    animator.duration = 2500
    animator.interpolator = LinearInterpolator()
    animator.repeatCount = ValueAnimator.INFINITE
    animator.repeatMode = ValueAnimator.REVERSE
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
    val centerX = width / 2
    val centerY = height / 2
    val x = centerX - bitmapWidth / 2
    val y = centerY - bitmapHeight / 2
    canvas.save()
    camera.save()
    camera.rotateX(degree.toFloat())
    canvas.translate(centerX.toFloat(), centerY.toFloat())
    camera.applyToCanvas(canvas)
    canvas.translate(-centerX.toFloat(), -centerY.toFloat())
    camera.restore()
    canvas.drawBitmap(bitmap!!, x.toFloat(), y.toFloat(), paint)
    canvas.restore()
  }
}
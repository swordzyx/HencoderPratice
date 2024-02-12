package com.hencoder.praticedraw4.sample

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.annotation.Nullable
import com.hencoder.hencoderpratice.R

class Sample01ClipRectView : View {
  var paint = Paint(Paint.ANTI_ALIAS_FLAG)
  var bitmap: Bitmap? = null

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
    val left = (width - bitmap!!.width) / 2
    val top = (height - bitmap!!.height) / 2
    canvas.save()
    canvas.clipRect(left + 50, top + 50, left + 300, top + 200)
    canvas.drawBitmap(bitmap!!, left.toFloat(), top.toFloat(), paint)
    canvas.restore()
  }
}
package com.hencoder.praticedraw5.sample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

import com.hencoder.hencoderpratice.R;

public class Sample01AfterOnDrawView extends AppCompatImageView {
    public static final boolean DEBUG = true;

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Sample01AfterOnDrawView(Context context) {
        super(context);
    }

    public Sample01AfterOnDrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Sample01AfterOnDrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        paint.setColor(Color.parseColor("#FFC107"));
        paint.setTextSize(28);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (DEBUG) {
            //获取 ImageView 具体图片信息的 Drawable
            Drawable drawable = getDrawable();
            if (drawable != null) {
                canvas.save();
                canvas.concat(getImageMatrix());
                Rect bounds = drawable.getBounds();
                canvas.drawText(getResources().getString(R.string.image_size, bounds.width(), bounds.height()), 20, 40, paint);
                canvas.restore();
            }
        }
    }
}
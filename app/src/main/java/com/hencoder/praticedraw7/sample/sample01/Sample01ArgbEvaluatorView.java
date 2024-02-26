package com.hencoder.praticedraw7.sample.sample01;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Sample01ArgbEvaluatorView extends View {

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    int color = 0xffff0000;

    public Sample01ArgbEvaluatorView(Context context) {
        super(context);
    }

    public Sample01ArgbEvaluatorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Sample01ArgbEvaluatorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
        invalidate();
    }

    @Override
    public void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();
        int height = getHeight();

        paint.setColor(color);
        canvas.drawCircle(width / 2f, height / 2f, width / 6f, paint);
    }
}

package com.hencoder.praticedraw5.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

public class Practice05AfterOnDrawForegroundView extends AppCompatImageView {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice05AfterOnDrawForegroundView(Context context) {
        super(context);
    }

    public Practice05AfterOnDrawForegroundView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice05AfterOnDrawForegroundView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        paint.setTextSize(60);
    }

    @Override
    public void onDrawForeground(Canvas canvas) {
        super.onDrawForeground(canvas);

        // 在 super.onDrawForeground() 的下方插入绘制代码，让绘制内容盖住前景
        // 由于这期的重点是绘制代码的位置而不是绘制代码本身，所以直接给出绘制代码，你只要解除注释就好
        /*paint.setColor(Color.parseColor("#f44336"));
        canvas.drawRect(0, 40, 200, 120, paint);
        paint.setColor(Color.WHITE);
        canvas.drawText("New", 20, 100, paint);*/
    }
}

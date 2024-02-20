package com.hencoder.praticedraw6.pratice;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import com.hencoder.hencoderpratice.R;

public class Practice02Rotation extends RelativeLayout {
    Button animateBt;
    ImageView imageView;

    public Practice02Rotation(Context context) {
        super(context);
    }

    public Practice02Rotation(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice02Rotation(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    int rotationState = 0;
    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        animateBt = findViewById(R.id.animateBt);
        imageView = findViewById(R.id.imageView);

        animateBt.setOnClickListener(v -> {
            // TODO 在这里处理点击事件，通过 View.animate().rotation/X/Y() 来让 View 旋转
            switch (rotationState) {
                case 0:
                    //todo: imageView 中心为轴心，旋转 180°（顺时针）
                    imageView.animate().rotation(180);
                    break;
                case 1:
                    //todo: imageView 中心为轴心，旋转到 0°（逆时针）
                    imageView.animate().rotation(0);
                    break;
                case 2:
                    //todo: 围绕中心 x 轴旋转到 180°
                    imageView.animate().rotationX(180);
                    break;
                case 3:
                    //todo: 沿中心 x 轴旋转到 0°
                    imageView.animate().rotationX(0);
                    break;
                case 4:
                    //todo: 沿中心 y 轴旋转 180°
                    imageView.animate().rotationY(180);
                    break;
                case 5:
                    //todo: 沿中心 y 轴旋转到 0°
                    imageView.animate().rotationY(0);
                    break;
                default:
                    break;
            }
            rotationState++;
            if (rotationState == 6) {
                rotationState = 0;
            }
        });
    }
}
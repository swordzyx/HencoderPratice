package com.hencoder.praticedraw6.pratice;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import com.hencoder.hencoderpratice.R;


public class Practice03Scale extends RelativeLayout {
    Button animateBt;
    ImageView imageView;

    public Practice03Scale(Context context) {
        super(context);
    }

    public Practice03Scale(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice03Scale(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    int scaleState = 0;
    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        animateBt = (Button) findViewById(R.id.animateBt);
        imageView = (ImageView) findViewById(R.id.imageView);

        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View v) {
                // TODO 在这里处理点击事件，通过 View.animate().scaleX/Y() 来让 View 放缩
                switch (scaleState) {
                    case 0:
                        //todo: 横向拉伸到原来的 1.5 倍
                        imageView.animate().scaleX(1.5f);
                        break;
                    case 1:
                        //todo: 水平拉伸到原来的 1 倍
                        imageView.animate().scaleX(1f);
                        break;
                    case 2:
                        //todo: 垂直拉伸到原来的 0.5 倍
                        imageView.animate().scaleY(0.5f);
                        break;
                    case 3:
                        //todo: 垂直拉伸到原来的 1 倍
                        imageView.animate().scaleY(1f);
                        break;
                    default:
                        break;
            }
                scaleState++;
                if (scaleState == 4) {
                    scaleState = 0;
                }
            }
        });
    }
}

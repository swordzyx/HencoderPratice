package com.hencoder.praticedraw6.pratice;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;

import com.hencoder.hencoderpratice.R;

public class Practice04Alpha extends RelativeLayout {
  Button animateBt;
  ImageView imageView;

  public Practice04Alpha(Context context) {
    super(context);
  }

  public Practice04Alpha(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  public Practice04Alpha(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  int alphaState = 0;

  @Override
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();

    animateBt = findViewById(R.id.animateBt);
    imageView = findViewById(R.id.imageView);

    animateBt.setOnClickListener(v -> {
      // TODO 在这里处理点击事件，通过 View.animate().alpha() 来改变 View 的透明度
      switch (alphaState) {
          case 0:
              //todo: 隐藏 view，透明度改为 0
              imageView.animate().alpha(0);
              break;
          case 1:
              //todo: 显示 view，透明度改为 1
              imageView.animate().alpha(1);
              break;
          default:
              break;
      }
      alphaState ^= 1;
    });
  }
}
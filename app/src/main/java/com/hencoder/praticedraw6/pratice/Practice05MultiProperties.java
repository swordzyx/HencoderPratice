package com.hencoder.praticedraw6.pratice;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.annotation.Nullable;

import com.hencoder.hencoderpratice.R;
import com.hencoder.praticedraw6.Utils;

public class Practice05MultiProperties extends ConstraintLayout {
  Button animateBt;
  ImageView imageView;

  public Practice05MultiProperties(Context context) {
    super(context);
  }

  public Practice05MultiProperties(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  public Practice05MultiProperties(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  boolean showed = false;

  @Override
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();

    animateBt = findViewById(R.id.animateBt);
    imageView = findViewById(R.id.imageView);
    imageView.setScaleX(0);
    imageView.setScaleY(0);
    imageView.setAlpha(0f);
    animateBt.setOnClickListener(v -> {
      // TODO 在这里处理点击事件，同时对多个属性做动画
      if (showed) {
        //隐藏，旋转 0 + 透明度变为 0 + x 平移到 200 的位置 + scaleX(0) + scaleY(0)
        imageView.animate().rotation(0).alpha(0).
            translationX(Utils.dpToPixel(0)).scaleX(0).scaleY(0);
      } else {
        //显示，旋转到 360° + 透明度变为 1 + x 平移到 200 的位置 + scaleX(1) + scaleY(1)
        imageView.animate().rotation(360).alpha(1).
            translationX(Utils.dpToPixel(200)).scaleX(1).scaleY(1);
      }
      showed = !showed;
    });
  }
}

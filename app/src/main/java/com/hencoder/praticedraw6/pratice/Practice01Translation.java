package com.hencoder.praticedraw6.pratice;

import static com.hencoder.praticedraw6.Utils.dpToPixel;

import android.content.Context;
import android.graphics.Outline;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;

import com.hencoder.hencoderpratice.R;

public class Practice01Translation extends RelativeLayout {
  Button animateBt;
  ImageView imageView;

  public Practice01Translation(Context context) {
    super(context);
  }

  public Practice01Translation(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  public Practice01Translation(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  @Override
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();

    animateBt = findViewById(R.id.animateBt);
    imageView = findViewById(R.id.imageView);
    // 给音乐图标加上合适的阴影
    imageView.setOutlineProvider(new MusicOutlineProvider());

    animateBt.setOnClickListener(v -> {
      // TODO 在这里处理点击事件，通过 View.animate().translationX/Y/Z() 来让 View 平移
      imageView.animate().translationX(500f);
    });
  }

  /**
   * 为音乐图标设置三角形的 Outline。
   */
  static class MusicOutlineProvider extends ViewOutlineProvider {
    Path path = new Path();

    {
      path.moveTo(0, dpToPixel(10));
      path.lineTo(dpToPixel(7), dpToPixel(2));
      path.lineTo(dpToPixel(116), dpToPixel(58));
      path.lineTo(dpToPixel(116), dpToPixel(70));
      path.lineTo(dpToPixel(7), dpToPixel(128));
      path.lineTo(0, dpToPixel(120));
      path.close();
    }

    @Override
    public void getOutline(View view, Outline outline) {
      outline.setConvexPath(path);
    }
  }
}
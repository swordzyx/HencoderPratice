package com.hencoder.praticedraw6.pratice;

import static com.hencoder.Utils.dpToPixel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.hencoder.hencoderpratice.R;

public class Practice01Translation extends RelativeLayout {
  Button animateBt;
  ImageView imageView;

  int translationState = 0;

  Path path = new Path();

  Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

  {
    //imageView 的轮廓
    path.moveTo(0, dpToPixel(10));
    path.lineTo(dpToPixel(7), dpToPixel(2));
    path.lineTo(dpToPixel(116), dpToPixel(58));
    path.lineTo(dpToPixel(116), dpToPixel(70));
    path.lineTo(dpToPixel(7), dpToPixel(128));
    path.lineTo(0, dpToPixel(120));
    path.close();

    paint.setStyle(Paint.Style.STROKE);
    paint.setStrokeWidth(dpToPixel(4));
  }


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
      switch (translationState) {
        case 0:
          //水平方向移动到 100dp
          imageView.animate().translationX(dpToPixel(100));
          break;
        case 1:
          //水平方向平移 -100dp
          imageView.animate().translationX(dpToPixel(0));
          break;
        case 2:
          //垂直方向移动到 100dp
          imageView.animate().translationY(dpToPixel(100));
          break;
        case 3:
          //垂直方向平移 -100dp
          imageView.animate().translationY(dpToPixel(0));
          break;
        case 4:
          //向外平移（z 轴） 10dp
          imageView.animate().translationZ(dpToPixel(15));
          break;
        case 5:
          //向内平移（z 轴） -10dp
          imageView.animate().translationZ(dpToPixel(0));
          break;
        default:
          break;
      }
      if (translationState == 5) {
        translationState = 0;
      } else {
        translationState ++;
      }
    });
  }

  @Override
  protected void dispatchDraw(@NonNull Canvas canvas) {
    super.dispatchDraw(canvas);
    canvas.save();
    canvas.concat(imageView.getImageMatrix());
    canvas.drawPath(path, paint);
    canvas.restore();
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
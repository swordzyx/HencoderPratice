package com.hencoder.praticedraw7.pratice;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.hencoder.hencoderpratice.R;

public class Practice05AnimatorSetLayout extends RelativeLayout {
    View view;
    Button animateBt;

    public Practice05AnimatorSetLayout(Context context) {
        super(context);
    }

    public Practice05AnimatorSetLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice05AnimatorSetLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        view = findViewById(R.id.objectAnimatorView);
        animateBt = (Button) findViewById(R.id.animateBt);

        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setTranslationX(-200f);

                ObjectAnimator animator1 = ObjectAnimator.ofFloat(view, "alpha", 0f, 1f);
                ObjectAnimator animator2 = ObjectAnimator.ofFloat(view, "translationX", -200f, 200f);
                ObjectAnimator animator3 = ObjectAnimator.ofFloat(view, "rotation", 0f, 1080f);
                animator3.setDuration(1000);

                AnimatorSet animatorSet = new AnimatorSet();
                // 用 AnimatorSet 的方法来让三个动画协作执行
                // 要求 1： animator1 先执行，animator2 在 animator1 完成后立即开始
                animatorSet.play(animator1).before(animator2);
                // 要求 2： animator2 和 animator3 同时开始
                animatorSet.play(animator2).with(animator3);
                animatorSet.start();
            }
        });
    }
}

package com.example.hsg.meterialdesignstudy.animator;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;

import com.example.hsg.meterialdesignstudy.BaseActivity;
import com.example.hsg.meterialdesignstudy.R;

public class AnimatorReveal2Activity extends BaseActivity {
    private static final String X_TAG = "x_tag";
    private static final String Y_TAG = "y_tag";


    private View rootView;

    public static void startAction(Context context, int cx, int cy) {
        Intent intent = new Intent(context, AnimatorReveal2Activity.class);
        intent.putExtra(X_TAG, cx);
        intent.putExtra(Y_TAG, cy);
        context.startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator_reveal2);
        this.rootView = findViewById(R.id.layout_content);
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.rootView.post(new Runnable() {
            @Override
            public void run() {
                startRevealAnimator(true);
            }
        });
    }

    @Override
    public void onBackPressed() {
        startRevealAnimator(false);
    }

    private void startRevealAnimator(boolean isReveal) {
        int cx = getIntent().getIntExtra(X_TAG, 0);
        int cy = getIntent().getIntExtra(Y_TAG, 0);

        float radius = (float) Math.hypot(this.rootView.getWidth(), this.rootView.getHeight());

        float startRadius = isReveal ? 0 : radius;
        float endRadius = isReveal ? radius : 0;

        Animator animator = ViewAnimationUtils.createCircularReveal(this.rootView, cx, cy, startRadius, endRadius);
        animator.setDuration(getResources().getInteger(R.integer.animator_duration));

        if (!isReveal) {
            animator.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animator) {
                }

                @Override
                public void onAnimationEnd(Animator animator) {
                    finish();
                }

                @Override
                public void onAnimationCancel(Animator animator) {
                }

                @Override
                public void onAnimationRepeat(Animator animator) {

                }
            });
        }

        animator.start();
    }
}

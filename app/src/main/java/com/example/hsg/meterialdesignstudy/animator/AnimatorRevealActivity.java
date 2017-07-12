package com.example.hsg.meterialdesignstudy.animator;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;

import com.example.hsg.meterialdesignstudy.BaseActivity;
import com.example.hsg.meterialdesignstudy.R;

public class AnimatorRevealActivity extends BaseActivity implements View.OnClickListener {

    private View actionView;


    public static void startAction(Context context) {
        Intent intent = new Intent(context, AnimatorRevealActivity.class);
        context.startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator_reveal);
        findViewById(R.id.fab_down).setOnClickListener(this);
        findViewById(R.id.fab_up).setOnClickListener(this);
        findViewById(R.id.fab_out).setOnClickListener(this);

        this.actionView = findViewById(R.id.view_action);
    }

    @Override
    public void onClick(View view) {
        int cx = (view.getLeft() + view.getRight()) / 2;
        int cy = (view.getTop() + view.getBottom()) / 2;

        switch (view.getId()) {
            case R.id.fab_up:
                startRevealAnimator(cx, cy, true);
                break;
            case R.id.fab_down:
                startRevealAnimator(cx, cy, false);
                break;
            case R.id.fab_out:
                AnimatorReveal2Activity.startAction(this, cx, cy);
                break;
        }
    }


    private void startRevealAnimator(int centerX, int centerY, boolean isReveal) {
        this.actionView.setVisibility(View.VISIBLE);
        //勾股定理 计算半径
        double radius = Math.hypot(centerX, centerY);

        float startRadius = isReveal ? 0 : (float) radius;
        float endRadius = isReveal ? (float) radius : 0;

        final Animator animator = ViewAnimationUtils.createCircularReveal(this.actionView, centerX, centerY, startRadius, endRadius);

        if (!isReveal) {
            animator.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animator) {

                }

                @Override
                public void onAnimationEnd(Animator animator) {
                    actionView.setVisibility(View.GONE);
                }

                @Override
                public void onAnimationCancel(Animator animator) {

                }

                @Override
                public void onAnimationRepeat(Animator animator) {

                }
            });
        }
        animator.setDuration(getResources().getInteger(R.integer.animator_duration)).start();
    }
}

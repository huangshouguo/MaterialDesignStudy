package com.example.hsg.meterialdesignstudy.animator;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Path;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import com.example.hsg.meterialdesignstudy.BaseActivity;
import com.example.hsg.meterialdesignstudy.R;

public class AnimatorPathActivity extends BaseActivity implements View.OnClickListener {

    private ImageView imageView;

    private float originX;
    private float originY;
    private float radius;

    private float targetX;
    private float targetY;

    private float mediumX;
    private float mediumY;

    private Button btnStart;
    private Button btnBack;
    private Toolbar toolbar;

    public static void startAction(Context context) {
        Intent intent = new Intent(context, AnimatorPathActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator_path);

        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.imageView = (ImageView) findViewById(R.id.image_view);

        this.btnStart = (Button) findViewById(R.id.btn_start);
        this.btnBack = (Button) findViewById(R.id.btn_back);

        this.btnStart.setOnClickListener(this);
        this.btnBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (this.originX == 0) {
            this.originX = this.imageView.getX();
            this.originY = this.imageView.getY();

            this.radius = this.imageView.getWidth() / 2f;

            this.targetX = 0;
            this.targetY = this.toolbar.getBottom();

            this.mediumX = this.toolbar.getRight() * 0.75f + this.radius;
            this.mediumY = (this.originY + this.targetY) / 2f;
        }

        switch (view.getId()) {
            case R.id.btn_start:
                startAnimator();
                break;
            case R.id.btn_back:
                backAnimator();
                break;
        }

    }

    private void startAnimator() {
        Path path = new Path();

        path.moveTo(this.originX, this.originY);
        path.cubicTo(this.originX, this.originY, this.mediumX, this.mediumY, this.targetX, this.targetY);

        ObjectAnimator animator = ObjectAnimator.ofFloat(this.imageView, View.X, View.Y, path);
        animator.setInterpolator(new PathInterpolator(0f, 0.1f, 1f, 1f));
        animator.setDuration(getResources().getInteger(R.integer.animator_duration));
        animator.start();
    }

    private void backAnimator() {
        Path path = new Path();

        path.moveTo(this.targetX, this.targetY);
        path.cubicTo(this.targetX, this.targetY, this.mediumX, this.mediumY, this.originX, this.originY);

        ObjectAnimator animator = ObjectAnimator.ofFloat(this.imageView, View.X, View.Y, path);
//        animator.setInterpolator(new PathInterpolator(0f, 0.1f, 1f, 1f));
//        animator.setDuration(getResources().getInteger(R.integer.animator_duration));
//        animator.start();

        ObjectAnimator animator1 = ObjectAnimator.ofFloat(this.imageView, "alpha", 0f, 1f);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animator, animator1);
        animatorSet.setInterpolator(new LinearInterpolator());
        animatorSet.setDuration(1000).start();
    }
}

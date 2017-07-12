package com.example.hsg.meterialdesignstudy.animator;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.hsg.meterialdesignstudy.BaseActivity;
import com.example.hsg.meterialdesignstudy.R;

public class AnimatorHomeActivity extends BaseActivity implements View.OnClickListener {

    public static void startAction(Context context) {
        Intent intent = new Intent(context, AnimatorHomeActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator_home);

        findViewById(R.id.btn_feedback).setOnClickListener(this);
        findViewById(R.id.btn_reveal).setOnClickListener(this);
        findViewById(R.id.btn_transition).setOnClickListener(this);
        findViewById(R.id.btn_share).setOnClickListener(this);
        findViewById(R.id.btn_path).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_feedback:
                AnimatorFeedbackActivity.startAction(this);
                break;
            case R.id.btn_reveal:
                AnimatorRevealActivity.startAction(this);
                break;
            case R.id.btn_transition:
                AnimatorTransitionActivity.startAction(this);
                break;
            case R.id.btn_share:
                AnimatorShareActivity.startAction(this, findViewById(R.id.btn_share));
                break;
            case R.id.btn_path:
                break;
        }
    }
}

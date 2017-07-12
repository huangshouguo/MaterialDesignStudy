package com.example.hsg.meterialdesignstudy.animator;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.hsg.meterialdesignstudy.BaseActivity;
import com.example.hsg.meterialdesignstudy.R;

public class AnimatorTransitionActivity extends BaseActivity implements View.OnClickListener {

    public static void startAction(Context context) {
        Intent intent = new Intent(context, AnimatorTransitionActivity.class);
        context.startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator_transition);

        findViewById(R.id.btn_fade_code).setOnClickListener(this);
        findViewById(R.id.btn_fade_xml).setOnClickListener(this);
        findViewById(R.id.btn_slide_code).setOnClickListener(this);
        findViewById(R.id.btn_slide_xml).setOnClickListener(this);
        findViewById(R.id.btn_explode_code).setOnClickListener(this);
        findViewById(R.id.btn_explode_xml).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_fade_code:
                AnimatorTransitionFadeActivity.startAction(this, false);
                break;
            case R.id.btn_fade_xml:
                AnimatorTransitionFadeActivity.startAction(this, true);
                break;
            case R.id.btn_slide_code:
                AnimatorTransitionSlideActivity.startAction(this, false);
                break;
            case R.id.btn_slide_xml:
                AnimatorTransitionSlideActivity.startAction(this, true);
                break;
            case R.id.btn_explode_code:
                AnimatorTransitionExplodeActivity.startAction(this, false);
                break;
            case R.id.btn_explode_xml:
                AnimatorTransitionExplodeActivity.startAction(this, true);
                break;
        }
    }
}

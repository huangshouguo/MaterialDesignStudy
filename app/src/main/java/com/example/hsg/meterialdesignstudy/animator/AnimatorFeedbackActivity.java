package com.example.hsg.meterialdesignstudy.animator;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.hsg.meterialdesignstudy.BaseActivity;
import com.example.hsg.meterialdesignstudy.R;

public class AnimatorFeedbackActivity extends BaseActivity {

    public static void startAction(Context context) {
        Intent intent = new Intent(context, AnimatorFeedbackActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator_feedback);
    }
}

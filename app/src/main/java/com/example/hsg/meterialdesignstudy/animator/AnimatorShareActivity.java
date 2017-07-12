package com.example.hsg.meterialdesignstudy.animator;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.hsg.meterialdesignstudy.BaseActivity;
import com.example.hsg.meterialdesignstudy.R;

public class AnimatorShareActivity extends BaseActivity {


    public static void startAction(Activity context, View view) {
        Intent intent = new Intent(context, AnimatorShareActivity.class);
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(context, view, context.getString(R.string.share_elements_name));
        context.startActivity(intent, options.toBundle());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator_share);
    }
}

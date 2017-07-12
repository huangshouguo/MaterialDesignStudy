package com.example.hsg.meterialdesignstudy.animator;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionInflater;

import com.example.hsg.meterialdesignstudy.BaseActivity;
import com.example.hsg.meterialdesignstudy.R;


public class AnimatorTransitionFadeActivity extends BaseActivity {
    private static final String ENABLE_XML_TAG = "enable_xml_tag";

    private boolean isEnableXml;

    public static void startAction(Activity context, boolean isEnableXml) {
        Intent intent = new Intent(context, AnimatorTransitionFadeActivity.class);
        intent.putExtra(ENABLE_XML_TAG, isEnableXml);
        context.startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(context).toBundle());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator_transition_fade);

        this.isEnableXml = getIntent().getBooleanExtra(ENABLE_XML_TAG, false);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setupTransitionAnimator();
    }

    private void setupTransitionAnimator() {
        Transition transition = null;
        if (this.isEnableXml) {
            transition = TransitionInflater.from(this).inflateTransition(R.transition.fade);
        } else {
            transition = new Fade();
            transition.setDuration(getResources().getInteger(R.integer.animator_duration));
        }

        getWindow().setEnterTransition(transition);
        getWindow().setExitTransition(transition);
    }
}

package com.example.hsg.meterialdesignstudy.animator;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.Gravity;

import com.example.hsg.meterialdesignstudy.BaseActivity;
import com.example.hsg.meterialdesignstudy.R;
import com.example.hsg.meterialdesignstudy.data.DataListAdapter;

public class AnimatorTransitionSlideActivity extends BaseActivity {

    private static final String ENABLE_XML_TAG = "enable_xml_tag";

    private boolean isEnableXml;

    public static void startAction(Activity context, boolean isEnableXml) {
        Intent intent = new Intent(context, AnimatorTransitionSlideActivity.class);
        intent.putExtra(ENABLE_XML_TAG, isEnableXml);
        context.startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(context).toBundle());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator_transition_slide);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new DataListAdapter());

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
            transition = TransitionInflater.from(this).inflateTransition(R.transition.slide);
        } else {
            transition = new Slide();
            ((Slide) transition).setSlideEdge(Gravity.LEFT);
            transition.setDuration(getResources().getInteger(R.integer.animator_duration));
        }

        getWindow().setEnterTransition(transition);
        getWindow().setExitTransition(transition);
    }
}

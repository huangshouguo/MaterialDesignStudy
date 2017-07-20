package com.example.hsg.meterialdesignstudy.component;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.hsg.meterialdesignstudy.BaseActivity;
import com.example.hsg.meterialdesignstudy.R;

public class ComponentHomeActivity extends BaseActivity implements View.OnClickListener {


    public static void startAction(Context context) {
        Intent intent = new Intent(context, ComponentHomeActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_component_home);
        findViewById(R.id.btn_app_bar_demo1).setOnClickListener(this);
        findViewById(R.id.btn_app_bar_demo2).setOnClickListener(this);
        findViewById(R.id.btn_app_bar_demo3).setOnClickListener(this);
        findViewById(R.id.btn_navigation).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_app_bar_demo1:
                AppBarDemo1Activity.startAction(this);
                break;
            case R.id.btn_app_bar_demo2:
                AppBarDemo2Activity.startAction(this);
                break;
            case R.id.btn_app_bar_demo3:
                AppBarDemo3Activity.startAction(this);
                break;
            case R.id.btn_navigation:
                NavigationViewActivity.startAction(this);
                break;
        }
    }
}

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

    }

    @Override
    public void onClick(View view) {
    }
}
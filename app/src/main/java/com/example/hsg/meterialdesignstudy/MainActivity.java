package com.example.hsg.meterialdesignstudy;

import android.os.Bundle;
import android.view.View;

import com.example.hsg.meterialdesignstudy.animator.AnimatorHomeActivity;
import com.example.hsg.meterialdesignstudy.apply.ApplyHomeActivity;
import com.example.hsg.meterialdesignstudy.component.ComponentHomeActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_component).setOnClickListener(this);
        findViewById(R.id.btn_animator).setOnClickListener(this);
        findViewById(R.id.btn_apply).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_component:
                ComponentHomeActivity.startAction(this);
                break;
            case R.id.btn_animator:
                AnimatorHomeActivity.startAction(this);
                break;
            case R.id.btn_apply:
                ApplyHomeActivity.startAction(this);
                break;
        }
    }
}

package com.example.hsg.meterialdesignstudy.component;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.util.Log;
import android.view.View;

import com.example.hsg.meterialdesignstudy.BaseActivity;
import com.example.hsg.meterialdesignstudy.R;

public class BottomSheetActivity extends BaseActivity implements View.OnClickListener {

    private View layoutBottomSheet;
    private BottomSheetBehavior behavior;

    public static void startAction(Context context) {
        Intent intent = new Intent(context, BottomSheetActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheet);

        findViewById(R.id.btn_bottom_sheet).setOnClickListener(this);
        findViewById(R.id.btn_bottom_sheet_dialog).setOnClickListener(this);
        findViewById(R.id.btn_bottom_sheet_dialog_fragment).setOnClickListener(this);

        this.layoutBottomSheet = findViewById(R.id.layout_bottom_sheet);
        this.behavior = BottomSheetBehavior.from(this.layoutBottomSheet);
        this.behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                Log.v(TAG, "onStateChanged() called with: newState = [" + newState + "]");
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                Log.i(TAG, "onSlide() called with: slideOffset = [" + slideOffset + "]");
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_bottom_sheet:
                if (this.behavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
                    this.behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                } else {
                    this.behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }
                break;
            case R.id.btn_bottom_sheet_dialog:
                BottomSheetDialog dialog = new BottomSheetDialog(this);
                dialog.setContentView(R.layout.bottom_sheet_dialog);
                dialog.show();
                break;
            case R.id.btn_bottom_sheet_dialog_fragment:
                new BottomSheetDialogFragmentDemo().show(getSupportFragmentManager(), "BottomSheetDialogFragmentDemo");
                break;
            default:
                break;
        }
    }
}

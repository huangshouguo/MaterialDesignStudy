package com.example.hsg.meterialdesignstudy.component;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.View;

import com.example.hsg.meterialdesignstudy.R;

/**
 * Created by hsg on 25/07/2017.
 */

public class BottomSheetDialogFragmentDemo extends BottomSheetDialogFragment {

    private BottomSheetBehavior behavior;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        BottomSheetDialog dialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);

        View view = View.inflate(getContext(), R.layout.bottom_sheet_dialog, null);
        dialog.setContentView(view);

        //java.lang.IllegalArgumentException: The view is not a child of CoordinatorLayout
        behavior = BottomSheetBehavior.from((View) view.getParent());

        return dialog;
    }

    @Override
    public void onResume() {
        super.onResume();

        this.behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
    }
}

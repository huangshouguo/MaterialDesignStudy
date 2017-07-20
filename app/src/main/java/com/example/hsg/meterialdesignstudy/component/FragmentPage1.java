package com.example.hsg.meterialdesignstudy.component;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hsg.meterialdesignstudy.R;

/**
 * Created by hsg on 20/07/2017.
 */

public class FragmentPage1 extends Fragment {

    public static FragmentPage1 getInstance() {
        return new FragmentPage1();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_page_1, container, false);
        return rootView;
    }
}

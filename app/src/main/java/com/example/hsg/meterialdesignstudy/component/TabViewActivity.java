package com.example.hsg.meterialdesignstudy.component;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.hsg.meterialdesignstudy.R;

import java.util.ArrayList;
import java.util.List;

public class TabViewActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    private List<String> titleList;
    private List<Fragment> fragmentList;
    private ViewPagerAdapter adapter;


    public static void startAction(Context context) {
        Intent intent = new Intent(context, TabViewActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_view);

        this.tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        this.viewPager = (ViewPager) findViewById(R.id.view_pager);

        this.fragmentList = new ArrayList<>();
        this.fragmentList.add(FragmentPage1.getInstance());
        this.fragmentList.add(FragmentPage2.getInstance());
        this.fragmentList.add(FragmentPage3.getInstance());

        this.titleList = new ArrayList<String>() {{
            add("Tab1");
            add("Tab2");
            add("Tab3");
        }};

        this.adapter = new ViewPagerAdapter(getSupportFragmentManager(), this.titleList, this.fragmentList);
        this.viewPager.setAdapter(this.adapter);
        this.tabLayout.setupWithViewPager(this.viewPager, true);
    }
}

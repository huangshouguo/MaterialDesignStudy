package com.example.hsg.meterialdesignstudy.data;

import com.example.hsg.meterialdesignstudy.App;
import com.example.hsg.meterialdesignstudy.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hsg on 17/07/2017.
 */

public class DataFactory {
    private static final DataBean[] dataSource = new DataBean[]{
            new DataBean(App.getContext().getDrawable(R.drawable.ic_circle_blue), "blue"),
            new DataBean(App.getContext().getDrawable(R.drawable.ic_circle_green), "green"),
            new DataBean(App.getContext().getDrawable(R.drawable.ic_circle_pink), "pink"),
            new DataBean(App.getContext().getDrawable(R.drawable.ic_circle_purple), "purple"),
            new DataBean(App.getContext().getDrawable(R.drawable.ic_circle_red), "red")
    };

    public static List<DataBean> getData(int length) {
        List<DataBean> dataBeanList = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            dataBeanList.add(dataSource[i%5]);
        }

        return dataBeanList;
    }
}

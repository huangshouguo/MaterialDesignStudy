package com.example.hsg.meterialdesignstudy;

import android.app.Application;
import android.content.Context;

/**
 * Created by hsg on 18/07/2017.
 */

public class App extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}

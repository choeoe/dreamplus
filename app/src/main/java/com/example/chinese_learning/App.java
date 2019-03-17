package com.example.chinese_learning;

import android.app.Application;
import android.content.Context;

import io.rong.imkit.RongIM;

public class App extends Application {

    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        RongIM.init(this);
        context = getApplicationContext();
    }

    public static Context getContext(){
        return context;
    }
}

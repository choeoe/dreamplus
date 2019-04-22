package com.example.chinese_learning;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.youdao.sdk.app.YouDaoApplication;

import io.rong.imkit.RongIM;

public class App extends Application {

    private static Context context;
    private static App youAppction;
    @Override
    public void onCreate() {
        super.onCreate();
        RongIM.init(this);
        context = getApplicationContext();
        if(YouDaoApplication.getApplicationContext() == null) {
            YouDaoApplication.init(this, "1b8cb73b7a069078");
        }
//        YouDaoApplication.init(this,"1b8cb73b7a069078");//创建应用，每个应用都会有一个Appid，绑定对应的翻译服务实例，即可使用
//        YouDaoApplication.init(this,"72103667078f5b93");//创建应用，每个应用都会有一个Appid，绑定对应的翻译服务实例，即可使用
        youAppction = this;
    }

    public static Context getContext(){
        return context;
    }
    public static App getInstance() {
        return youAppction;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}

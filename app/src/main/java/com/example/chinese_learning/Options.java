package com.example.chinese_learning;

import android.util.Log;
import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;

public class Options {
    public static void RongConnect(String token){
        RongIM.connect(token, new RongIMClient.ConnectCallback() {
            @Override
            public void onTokenIncorrect() {
                Log.d("rong_fail","started");
            }

            @Override
            public void onSuccess(String s) {
                Log.d("rong_success","started");
            }

            @Override
            public void onError(RongIMClient.ErrorCode errorCode) {
                Log.d("rong_error","started");
            }
        });
    }
}

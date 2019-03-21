package com.example.chinese_learning;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.UserInfo;

public class MainActivity extends BaseActivity {


    private String token = "KCydvkQ3uEqolb6dEEdbHaakbMPkWHmJrd7TosH6WThruiNq+JMmz91IaOPKazGai6c22flPDcWE4Bca1HwM/w==";

    @OnClick(R.id.button)
    public void start(){
        Map<String,Boolean> supportedConversation = new HashMap<>();
        supportedConversation.put(Conversation.ConversationType.PRIVATE.getName(),false);
        RongIM.getInstance().startConversationList(MainActivity.this,supportedConversation);
//        if (RongIM.getInstance() != null) {
//            RongIM.getInstance().startPrivateChat(MainActivity.this, "123","hello");
//        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Options.RongConnect(token);
    }


}

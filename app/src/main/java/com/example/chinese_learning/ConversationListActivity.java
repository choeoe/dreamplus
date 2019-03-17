package com.example.chinese_learning;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;
import io.rong.imkit.RongIM;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.UserInfo;

public class ConversationListActivity extends BaseActivity {
    private List<UserInfo> friendList = new ArrayList<>();

    private List<Actions> actionsList = new ArrayList<>();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.list_navi:
                    findViewById(R.id.conversation_page).setVisibility(View.GONE);
                    findViewById(R.id.list_page).setVisibility(View.VISIBLE);
                    findViewById(R.id.action_page).setVisibility(View.GONE);
                    return true;
                case R.id.conversation_navi:
                    findViewById(R.id.list_page).setVisibility(View.GONE);
                    findViewById(R.id.conversation_page).setVisibility(View.VISIBLE);
                    findViewById(R.id.action_page).setVisibility(View.GONE);
                    return true;
                case R.id.action_navi:
                    findViewById(R.id.list_page).setVisibility(View.GONE);
                    findViewById(R.id.conversation_page).setVisibility(View.GONE);
                    findViewById(R.id.action_page).setVisibility(View.VISIBLE);
                    return true;
            }
            return false;
        }
    };

    @BindView(R.id.friend_list)
    RecyclerView friendListRecyclerView;

    @BindView(R.id.action_list)
    RecyclerView actionListRecyclerView;


    @OnClick(R.id.add_action)
    public void startAddAction(){
        Intent intent = new Intent(this,AddActionActivity.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation_list);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        RongIM.setUserInfoProvider(new RongIM.UserInfoProvider() {

            @Override
            public UserInfo getUserInfo(String userId) {
                return new UserInfo("12345","Frank",Uri.parse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1551702963591&di=af106dc95e8083f71adc92ccacb6e1cf&imgtype=0&src=http%3A%2F%2Fimg4.duitang.com%2Fuploads%2Fitem%2F201407%2F19%2F20140719130553_ShUBe.thumb.700_0.jpeg"));//根据 userId 去你的用户系统里查询对应的用户信息返回给融云 SDK。
            }
        }, true);
        RongIM.getInstance().refreshUserInfoCache(new UserInfo("12345","Frank",Uri.parse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1551702963591&di=af106dc95e8083f71adc92ccacb6e1cf&imgtype=0&src=http%3A%2F%2Fimg4.duitang.com%2Fuploads%2Fitem%2F201407%2F19%2F20140719130553_ShUBe.thumb.700_0.jpeg")));
        UserInfo testUser = new UserInfo("12345","Frank",
                Uri.parse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1551702963591&di=af106dc95e8083f71adc92ccacb6e1cf&imgtype=0&src=http%3A%2F%2Fimg4.duitang.com%2Fuploads%2Fitem%2F201407%2F19%2F20140719130553_ShUBe.thumb.700_0.jpeg"));
        friendList.add(testUser);
        List<String> picture = new ArrayList<>();
        picture.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1552379805789&di=570a3ebfaeb8fd642fb464faeda75b1a&imgtype=0&src=http%3A%2F%2F00.minipic.eastday.com%2F20170411%2F20170411212923_f3b93bece00e4178f3bc684240278d9a_5.jpeg");
        picture.add("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=506455687,3587206558&fm=26&gp=0.jpg");
        Actions actions = new Actions(testUser,picture,"It's a beautiful place!");
        actionsList.add(actions);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        friendListRecyclerView.setLayoutManager(layoutManager);
        FriendsAdapter adapter = new FriendsAdapter(friendList);
        friendListRecyclerView.setAdapter(adapter);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        actionListRecyclerView.setLayoutManager(manager);
        ActionsAdapter actionsAdapter = new ActionsAdapter(actionsList);
        actionListRecyclerView.setAdapter(actionsAdapter);
    }
}

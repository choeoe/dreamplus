package com.example.chinese_learning;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Message;
import android.renderscript.Script;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

import io.rong.imkit.RongIM;
import io.rong.imlib.model.UserInfo;

public class FriendsAdapter extends RecyclerView.Adapter<FriendsAdapter.ViewHolder> {
    private List<UserInfo> mFriendList;
    private String targetID;
    private ImageView bitMapImage;
    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView friendPortrait;
        TextView friendName;
        TextView friendId;
        public ViewHolder(View view){
            super(view);
            friendPortrait = view.findViewById(R.id.friend_portrait);
            friendName = view.findViewById(R.id.friend_name);
            friendId = view.findViewById(R.id.friend_id);
        }
    }
    public FriendsAdapter(List<UserInfo> friendList){
        mFriendList = friendList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        final View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.friend_item,viewGroup,false);
        final ViewHolder holder = new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RongIM.getInstance().startPrivateChat(view.getContext(), targetID,"");
            }
        });
        return holder;
    }

    public android.os.Handler mHandler = new android.os.Handler(){
        @Override
        public void handleMessage(Message msg) {
            Bitmap bitmap = (Bitmap)msg.obj;
            bitMapImage.setImageBitmap(bitmap);
        }
    };

    public void setImageU(final String image_url){

        new Thread(){

            public void run() {

                try {
                    URL url = new URL(image_url);
                    InputStream inputStream = url.openStream();
                    Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                    Message msg = mHandler.obtainMessage(1,bitmap);
                    mHandler.sendMessage(msg);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }.start();

    }



    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
       final UserInfo userInfo = mFriendList.get(i);
       viewHolder.friendName.setText(userInfo.getName());
       viewHolder.friendId.setText(userInfo.getUserId());
       targetID = userInfo.getUserId();
       bitMapImage = viewHolder.friendPortrait;
       Glide.with(App.getContext()).load(userInfo.getPortraitUri()).into(viewHolder.friendPortrait);
//                try {
//                    URL url = new URL(userInfo.getPortraitUri().toString());
//                    setImageU(url.toString());
//                } catch (MalformedURLException e) {
//                    e.printStackTrace();
//                }
    }

    @Override
    public int getItemCount() {
        return mFriendList.size();
    }
}

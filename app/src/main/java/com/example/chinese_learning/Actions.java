package com.example.chinese_learning;

import java.util.List;

import io.rong.imlib.model.UserInfo;

public class Actions {
    private UserInfo userInfo;
    private List<String> pictureList;
    private String content;
    public Actions(UserInfo user,List<String> picture, String mContent){
        userInfo = user;
        pictureList = picture;
        content = mContent;
    }

    public String getContent() {
        return content;
    }

    public List<String> getPictureList() {
        return pictureList;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }
}

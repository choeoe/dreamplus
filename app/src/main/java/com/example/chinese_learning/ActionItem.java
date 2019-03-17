package com.example.chinese_learning;

import android.widget.TextView;

import java.util.List;

public class ActionItem {

    private List<TextView> pictures;

    private String content;

    public ActionItem(List<TextView> list,String mContent){
        pictures = list;
        content = mContent;
    }
    public List<TextView> getPictures(){
        return pictures;
    }
    public String getContent(){
        return content;
    }

}

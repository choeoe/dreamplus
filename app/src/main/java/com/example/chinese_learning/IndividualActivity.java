package com.example.chinese_learning;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;

public class IndividualActivity extends BaseActivity {

    @BindView(R.id.circle_portrait)
    CircleImageView circleImageView;

    @BindView(R.id.my_name)
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual);
        Glide.with(App.getContext()).load(Uri.parse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1553739821&di=63c556b5e35da2d4cb04f3dc4196ccf7&imgtype=jpg&er=1&src=http%3A%2F%2Fimg4.duitang.com%2Fuploads%2Fitem%2F201412%2F17%2F20141217005427_mcu8x.thumb.700_0.jpeg")).into(circleImageView);
        textView.setText("me");
    }
}

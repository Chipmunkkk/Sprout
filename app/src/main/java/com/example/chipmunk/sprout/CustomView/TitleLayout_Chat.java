package com.example.chipmunk.sprout.CustomView;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.chipmunk.sprout.R;

/**
 * Created by Chipmunk on 2017/5/30.
 * 用于创建聊天界面的标题栏
 */

public class TitleLayout_Chat extends RelativeLayout {

    private ImageView ImgView_back;
    public TitleLayout_Chat(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title_chat,this);
        ImgView_back = (ImageView) findViewById(R.id.TitleImgView_Back);
        ImgView_back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)getContext()).finish();
            }
        });
    }
}

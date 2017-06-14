package com.example.chipmunk.sprout.CustomView;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.chipmunk.sprout.MainPage;
import com.example.chipmunk.sprout.MessageView.Message_Notice;
import com.example.chipmunk.sprout.R;

/**
 * Created by Chipmunk on 2017/5/29.
 * 用于创建主界面标题栏控件
 */

public class TitleLayout_Common extends RelativeLayout implements View.OnClickListener {

    private ImageView ImgView_Notice;
    private Intent intent;

    public TitleLayout_Common(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title_common, this);
        ImgView_Notice = (ImageView) findViewById(R.id.TitleImgView_Notice);
        ImgView_Notice.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        intent = new Intent();
        switch (v.getId()) {
            case R.id.TitleImgView_Notice:
                MainPage mainPage = (MainPage) getContext();
                mainPage.goToNotice(getContext());
                break;
            case R.id.TitleImgView_Me:
                intent.setClass(getContext(), Message_Notice.class);
                break;
        }

    }
}

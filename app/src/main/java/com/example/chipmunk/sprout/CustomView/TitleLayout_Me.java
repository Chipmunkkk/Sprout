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
 * Created by Chipmunk on 2017/6/1.
 */

public class TitleLayout_Me extends RelativeLayout {

    private ImageView Title_me_Back;
    public TitleLayout_Me(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title_me,this);
        Title_me_Back = (ImageView) findViewById(R.id.id_Title_me_Back);
        Title_me_Back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)getContext()).finish();
            }
        });
    }
}

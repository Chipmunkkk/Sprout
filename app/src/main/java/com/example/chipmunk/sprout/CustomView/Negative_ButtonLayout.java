package com.example.chipmunk.sprout.CustomView;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import com.example.chipmunk.sprout.R;

/**
 * Created by Chipmunk on 2017/5/29.
 * 用于创建自定义底部导航栏控件
 */

public class Negative_ButtonLayout extends RelativeLayout {

    public Negative_ButtonLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.negative_button,this);
    }
}

package com.example.chipmunk.sprout.CustomView;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import com.example.chipmunk.sprout.R;

/**
 * Created by Chipmunk on 2017/5/30.
 */

public class InputBox_Chat extends RelativeLayout {
    public InputBox_Chat(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.inputbox_chat,this);
    }
}

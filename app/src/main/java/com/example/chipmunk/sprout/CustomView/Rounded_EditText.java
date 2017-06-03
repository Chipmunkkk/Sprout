package com.example.chipmunk.sprout.CustomView;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.example.chipmunk.sprout.R;

/**
 * Created by Chipmunk on 2017/6/1.
 */

public class Rounded_EditText extends LinearLayout {
    public Rounded_EditText(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.search_edittext,this);

    }
}

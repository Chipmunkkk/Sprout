package com.example.chipmunk.sprout.CustomView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.chipmunk.sprout.Discover.*;
import com.example.chipmunk.sprout.Me.*;
import com.example.chipmunk.sprout.R;

/**
 * Created by Chipmunk on 2017/6/1.
 */

public class TitleLayout_Me extends RelativeLayout implements View.OnClickListener {

    private ImageView Title_me_Back;
    private ImageView Title_me_Notice;

    public TitleLayout_Me(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title_me,this);
        Title_me_Back = (ImageView) findViewById(R.id.id_Title_me_Back);
        Title_me_Notice = (ImageView) findViewById(R.id.id_Title_me_Notice);
        Title_me_Back.setOnClickListener(this);
        Title_me_Notice.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String contextName = getContext().toString();
        contextName = contextName.substring(0,contextName.indexOf("@"));
        switch (v.getId()){
            case R.id.id_Title_me_Back:
                ((Activity)getContext()).finish();
                break;
            case R.id.id_Title_me_Notice:
//                try {
//                    ((Discovery_circelFriend) getContext()).goToNotice(getContext());
//                    Log.d("11111", "onClick: " + contextName);
//                } catch (Exception e){
//                    Log.d("111111", "onClick: " + getContext().toString());
//                }

                switch (contextName){
                    case "com.example.chipmunk.sprout.Discover.Discovery_circelFriend":
                        ((Discovery_circelFriend) getContext()).goToNotice(getContext());
                        break;
                    case "com.example.chipmunk.sprout.Me.MyPage":
                        ((MyPage) getContext()).goToNotice(getContext());
                        break;
                    case "com.example.chipmunk.sprout.Me.MyCareer":
                        ((MyCareer) getContext()).goToNotice(getContext());
                        break;
                    case "com.example.chipmunk.sprout.Discover.Discovery_learnBook":
                        ((Discovery_learnBook) getContext()).goToNotice(getContext());
                    default:break;
                }

                break;
            default:break;
        }
    }
}

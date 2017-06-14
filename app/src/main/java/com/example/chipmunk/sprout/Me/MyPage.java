package com.example.chipmunk.sprout.Me;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.chipmunk.sprout.MessageView.Message_Notice;
import com.example.chipmunk.sprout.R;

public class MyPage extends Activity implements View.OnClickListener{

    private Intent intent;

    private LinearLayout career;
    private LinearLayout my_page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.my_page);

        my_page  = (LinearLayout) findViewById(R.id.id_myInformation_Entrance);
        career = (LinearLayout) findViewById(R.id.id_career_Entrance);

        career.setOnClickListener(this);
        my_page.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.id_career_Entrance://进入生涯纪录
                intent = new Intent(MyPage.this,MyCareer.class);
                break;
            case R.id.id_myInformation_Entrance://进入详细资料
                intent = new Intent(MyPage.this,MyInformation.class);
                break;
            default:break;
        }
        startActivity(intent);
    }

    public void goToNotice(Context context) {
        intent = new Intent(context, Message_Notice.class);
        startActivity(intent);
    }
}

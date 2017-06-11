package com.example.chipmunk.sprout.Login_Register;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.chipmunk.sprout.ActivityCollector;
import com.example.chipmunk.sprout.R;
import com.example.chipmunk.sprout.MainPage;

public class Login extends AppCompatActivity {

    private Button Btn_login;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("手机号登录");
        setContentView(R.layout.login);

        Btn_login = (Button) findViewById(R.id.btn_login);
        Btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent();
                intent.setClass(Login.this,MainPage.class);
                ActivityCollector.addActivity(Login.this);
                startActivity(intent);
            }
        });
    }
}

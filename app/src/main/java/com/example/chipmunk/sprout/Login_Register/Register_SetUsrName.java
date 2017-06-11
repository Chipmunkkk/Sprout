package com.example.chipmunk.sprout.Login_Register;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.chipmunk.sprout.ActivityCollector;
import com.example.chipmunk.sprout.R;
import com.example.chipmunk.sprout.MainPage;

public class Register_SetUsrName extends AppCompatActivity {

    private Button Btn_SetUsrName;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_set_usrname);

        Btn_SetUsrName = (Button) findViewById(R.id.btn_SetUsrName);
        Btn_SetUsrName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent();
                intent.setClass(Register_SetUsrName.this,MainPage.class);
                ActivityCollector.addActivity(Register_SetUsrName.this);
                startActivity(intent);
            }
        });
    }
}

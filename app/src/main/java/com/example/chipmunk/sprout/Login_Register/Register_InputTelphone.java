package com.example.chipmunk.sprout.Login_Register;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.chipmunk.sprout.R;

public class Register_InputTelphone extends AppCompatActivity {

    private Button Btn_InputTel;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("手机号注册");
        setContentView(R.layout.register_input_telphone);
        Btn_InputTel = (Button) findViewById(R.id.btn_InputTel);
        Btn_InputTel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent();
                intent.setClass(Register_InputTelphone.this,Register_InputVerificationCode.class);
                startActivity(intent);
            }
        });
    }
}

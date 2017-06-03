package com.example.chipmunk.sprout.Login_Register;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.chipmunk.sprout.R;

public class Register_InputVerificationCode extends AppCompatActivity {

    private Button Btn_InputVerificationCode;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("输入验证码");
        setContentView(R.layout.register_input_verificationcode);
        Btn_InputVerificationCode = (Button) findViewById(R.id.btn_InputVerificationCode);
        Btn_InputVerificationCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent();
                intent.setClass(Register_InputVerificationCode.this,Register_SetUsrName.class);
                startActivity(intent);
            }
        });
    }
}

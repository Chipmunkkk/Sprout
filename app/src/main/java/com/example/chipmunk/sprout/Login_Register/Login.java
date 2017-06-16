package com.example.chipmunk.sprout.Login_Register;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chipmunk.sprout.Utils.ActivityCollector;
import com.example.chipmunk.sprout.R;
import com.example.chipmunk.sprout.MainPage;

public class Login extends AppCompatActivity {

    private Button Btn_login;
    private Intent intent;

    private TextView usrTelephone;
    private TextView usrPassword;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private CheckBox rememberPass;

    public static final String PREFERENCE_NAME = "SaveSetting";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("手机号登录");
        setContentView(R.layout.login);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        usrTelephone = (TextView) findViewById(R.id.usrTelephone);
        usrPassword = (TextView) findViewById(R.id.usrPassword);
        rememberPass = (CheckBox) findViewById(R.id.id_rememberPass);

        boolean isRemember = sharedPreferences.getBoolean("Remember_Password", false);
        if (isRemember) {
            String telephone = sharedPreferences.getString("Telephone", "");
            String password = sharedPreferences.getString("Password", "");

            usrTelephone.setText(telephone);
            usrPassword.setText(password);

            rememberPass.setChecked(true);
        }

        Btn_login = (Button) findViewById(R.id.btn_login);
        Btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String telephone = usrTelephone.getText().toString();
                String password = usrPassword.getText().toString();
                if (telephone.equals("15566403160") && password.equals("123456")) {
                    editor = sharedPreferences.edit();
                    if (rememberPass.isChecked()) {
                        editor.putBoolean("Remember_Password", true);
                        editor.putString("Telephone", telephone);
                        editor.putString("Password", password);
                    } else {
                        editor.clear();
                    }
                    editor.commit();
                    intent = new Intent();
                    intent.setClass(Login.this, MainPage.class);
                    ActivityCollector.addActivity(Login.this);
                    startActivity(intent);
                } else {
                    Toast.makeText(Login.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

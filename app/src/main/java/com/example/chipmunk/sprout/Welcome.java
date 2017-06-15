package com.example.chipmunk.sprout;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.chipmunk.sprout.Login_Register.Login;
import com.example.chipmunk.sprout.Login_Register.Register_InputTelphone;
import com.example.chipmunk.sprout.Utils.ActivityCollector;
import com.example.chipmunk.sprout.Utils.StatusBarUtil;
import com.readystatesoftware.systembartint.SystemBarTintManager;

public class Welcome extends Activity implements View.OnClickListener{

    private Button btn_welcome_login;
    private Button btn_welcome_register;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.welcome);

        btn_welcome_login = (Button) findViewById(R.id.btn_welcome_login);
        btn_welcome_register = (Button) findViewById(R.id.btn_welcome_register);
        btn_welcome_login.setOnClickListener(this);
        btn_welcome_register.setOnClickListener(this);

//        //透明状态栏(沉浸式状态栏,测试中.....)
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            Window window = getWindow();
//            // Translucent status bar
//            window.setFlags(
//                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
//                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        }
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            getWindow().getDecorView().setSystemUiVisibility( View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
//        }
//        //透明状态栏
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        SystemBarTintManager tintManager = new SystemBarTintManager(this);
//        // enable status bar tint
//        tintManager.setStatusBarTintEnabled(true);
////        tintManager.setTintColor(Color.argb(255, 255, 255, 255));
    }

    @Override
    public void onClick(View v) {
        intent = new Intent();
        switch (v.getId()){
            case R.id.btn_welcome_login:
                intent.setClass(Welcome.this,Login.class);
                break;
            case R.id.btn_welcome_register:
                intent.setClass(Welcome.this,Register_InputTelphone.class);
                break;
            default:break;
        }
        ActivityCollector.addActivity(Welcome.this);
        startActivity(intent);
    }
}

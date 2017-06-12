package com.example.chipmunk.sprout;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;

import com.example.chipmunk.sprout.Discover.DiscoveryPage;
import com.example.chipmunk.sprout.Me.MyPage;
import com.example.chipmunk.sprout.MessageView.Message;
import com.example.chipmunk.sprout.MessageView.Message_Notice;
import com.example.chipmunk.sprout.MySchool.MyCollege;
import com.example.chipmunk.sprout.Utils.ActivityCollector;

public class MainPage extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener {

    private Intent intent;

    private RadioButton message;
    private RadioButton home;
    private RadioButton find;

    private Fragment HomePage;
    private Fragment Message;
    private Fragment Discovery;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    Drawable topDrawable_Message_normal;
    Drawable topDrawable_School_normal;
    Drawable topDrawable_Find_normal;
    Drawable topDrawable_Message_selected;
    Drawable topDrawable_School_selected;
    Drawable topDrawable_Find_selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slide_bar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        initView();
        setButton();
        setSelect(1);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            ActivityCollector.finishAll();
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.slide_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.id_nav_homepage) {
            intent = new Intent(this, MyPage.class);
            startActivity(intent);
        } else if (id == R.id.id_nav_notice) {
            intent = new Intent(this, Message_Notice.class);
            startActivity(intent);
        } else if (id == R.id.id_nav_collection) {

        } else if (id == R.id.id_nav_friends) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void hideFragemnt(FragmentTransaction fragmentTransaction) {
        if (HomePage != null) {
            fragmentTransaction.hide(HomePage);
        }
        if (Message != null) {
            fragmentTransaction.hide(Message);
        }
        if (Discovery != null){
            fragmentTransaction.hide(Discovery);
        }
    }

    public void initView() {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        message = (RadioButton) findViewById(R.id.radio_message);
        home = (RadioButton) findViewById(R.id.radio_home);
        find = (RadioButton) findViewById(R.id.radio_find);

        Message = new Message();
        HomePage = new MyCollege();
        Discovery = new DiscoveryPage();

        fragmentTransaction.add(R.id.id_FrameLayout_Main, Message);
        fragmentTransaction.add(R.id.id_FrameLayout_Main, HomePage);
        fragmentTransaction.add(R.id.id_FrameLayout_Main, Discovery);
        hideFragemnt(fragmentTransaction);
        fragmentTransaction.commit();
    }

    public void setButton() {
        message.setOnClickListener(this);
        home.setOnClickListener(this);
        find.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        setImg_normal();
        switch (v.getId()) {
            case R.id.radio_message:
                setSelect(0);
                break;
            case R.id.radio_home:
                setSelect(1);
                break;
            case R.id.radio_find:
                setSelect(2);
                break;
            default:
                break;
        }
    }

    public void setSelect(int i) {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        switch (i) {
            case 0:
                hideFragemnt(fragmentTransaction);
                if (Message == null) {
                    Message = new Message();
                    fragmentTransaction.add(R.id.id_FrameLayout_Main, Message);
                } else {
                    fragmentTransaction.show(Message);
                }
                setImg_selected(0);
                break;
            case 1:
                hideFragemnt(fragmentTransaction);
                if (HomePage == null) {
                    HomePage = new MyCollege();
                    fragmentTransaction.add(R.id.id_FrameLayout_Main, HomePage);
                } else {
                    fragmentTransaction.show(HomePage);
                }
                setImg_selected(1);
                break;
            case 2:
                hideFragemnt(fragmentTransaction);
                if (Discovery == null) {
                    Discovery = new DiscoveryPage();
                    fragmentTransaction.add(R.id.id_FrameLayout_Main, Discovery);
                } else {
                    fragmentTransaction.show(Discovery);
                }
                setImg_selected(2);
            default:
                break;
        }
        fragmentTransaction.commit();
    }

    private void setImg_normal() {
        topDrawable_Message_normal = getResources().getDrawable(R.drawable.message_normal);
        topDrawable_School_normal = getResources().getDrawable(R.drawable.school_normal);
        topDrawable_Find_normal = getResources().getDrawable(R.drawable.find_normal);
        topDrawable_Message_normal.setBounds(0, 0, topDrawable_Message_normal.getMinimumWidth(), topDrawable_Message_normal.getMinimumHeight());
        topDrawable_School_normal.setBounds(0, 0, topDrawable_School_normal.getMinimumWidth(), topDrawable_School_normal.getMinimumHeight());
        topDrawable_Find_normal.setBounds(0, 0, topDrawable_Find_normal.getMinimumWidth(), topDrawable_Find_normal.getMinimumHeight());
        message.setCompoundDrawables(null, topDrawable_Message_normal, null, null);
        home.setCompoundDrawables(null, topDrawable_School_normal, null, null);
        find.setCompoundDrawables(null, topDrawable_Find_normal, null, null);
    }

    private void setImg_selected(int i) {
        switch (i){
            case 0:
                topDrawable_Message_selected = getResources().getDrawable(R.drawable.message_selected);
                topDrawable_Message_selected.setBounds(0, 0, topDrawable_Message_selected.getMinimumWidth(), topDrawable_Message_selected.getMinimumHeight());
                message.setCompoundDrawables(null, topDrawable_Message_selected, null, null);
                break;
            case 1:
                topDrawable_School_selected = getResources().getDrawable(R.drawable.school_selected);
                topDrawable_School_selected.setBounds(0, 0, topDrawable_School_selected.getMinimumWidth(), topDrawable_School_selected.getMinimumHeight());
                home.setCompoundDrawables(null, topDrawable_School_selected, null, null);
                break;
            case 2:
                topDrawable_Find_selected = getResources().getDrawable(R.drawable.find_selected);
                topDrawable_Find_selected.setBounds(0, 0, topDrawable_Find_selected.getMinimumWidth(), topDrawable_Find_selected.getMinimumHeight());
                find.setCompoundDrawables(null, topDrawable_Find_selected, null, null);
                break;
            default:break;
        }
    }
}

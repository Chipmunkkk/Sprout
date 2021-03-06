package com.example.chipmunk.sprout.Me;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.chipmunk.sprout.MessageView.Message_Notice;
import com.example.chipmunk.sprout.R;

import java.io.File;
import java.util.List;

public class MyCareer extends Activity {

    private ListView ListView_RP;
    private ListView ListView_Career;

    private Button btn_generate;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.my_career);

        RP_Adapter rp = new RP_Adapter(this);
        Career_Adapter career = new Career_Adapter(this);
        ListView_Career = (ListView) findViewById(R.id.id_career);
        ListView_RP = (ListView) findViewById(R.id.id_career_RP);

        ListView_RP.setAdapter(rp);
        ListView_Career.setAdapter(career);
        btn_generate = (Button) findViewById(R.id.id_btn_generate);
        btn_generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDIR();
                newPackage();
            }
        });
    }

    public void goToNotice(Context context) {
        intent = new Intent(context, Message_Notice.class);
        startActivity(intent);
    }

    public class RP_Adapter extends BaseAdapter{

        Context context;
        String[] RP = {"2015-2016年读书大赛一等奖","2015-2016年ACM编程大赛三等奖"};

        public RP_Adapter (Context context){
            this.context = context;
        }

        @Override
        public int getCount() {
            return RP.length;
        }

        @Override
        public Object getItem(int position) {
            return RP[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            View RP_item = layoutInflater.inflate(R.layout.career_listview_item,null);
            
            TextView RP_context = (TextView) RP_item.findViewById(R.id.id_career_ListView_item);

            RP_context.setText(RP[position]);
            return RP_item;
        }
    }
    public class Career_Adapter extends BaseAdapter{

        Context context;
        String[] career = {"2015至今学年担任班长","2016-2017担任学生会部长"};

        public Career_Adapter (Context context){
            this.context = context;
        }

        @Override
        public int getCount() {
            return career.length;
        }

        @Override
        public Object getItem(int position) {
            return career[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            View RP_item = layoutInflater.inflate(R.layout.career_listview_item,null);

            TextView Career_context = (TextView) RP_item.findViewById(R.id.id_career_ListView_item);

            Career_context.setText(career[position]);
            return RP_item;
        }
    }

    public void getDIR(){
        String sdpath = Environment.getExternalStorageDirectory().toString();
        AlertDialog.Builder build = new AlertDialog.Builder(this);
        build.setMessage(sdpath).show();
    }
    public void newPackage(){
        String mkdir = Environment.getExternalStorageDirectory()+"/Sprout/test.txt";
        File file = new File(mkdir);
        AlertDialog.Builder build = new AlertDialog.Builder(this);
        if(file.exists()){
            build.setMessage("文件夹已存在").show();
        }else{
            file.mkdirs();
            build.setMessage("新建成功").show();
        }
    }
}

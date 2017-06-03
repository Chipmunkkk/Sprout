package com.example.chipmunk.sprout.Me;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.chipmunk.sprout.R;

import java.util.List;

public class MyCareer extends Activity {

    private ListView ListView_RP;
    private ListView ListView_Career;

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
    }

    public class RP_Adapter extends BaseAdapter{

        Context context;
        String[] RP = {"三好学生","三好学生","三好学生","三好学生","三好学生"};

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
        String[] career = {"三好1学生","三好1学生","三好1学生","三好1学生"};

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
}

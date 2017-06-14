package com.example.chipmunk.sprout.Discover;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.chipmunk.sprout.MessageView.Message_Notice;
import com.example.chipmunk.sprout.R;
import com.sackcentury.shinebuttonlib.ShineButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Discovery_circelFriend extends Activity {
    private ListView listView1;
    private List<Map<String, Object>> list1 = new ArrayList<>();
    private Map<String, Object> map = new HashMap<String, Object>();

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.discovery_circelfriend_listview);
        listView1 = (ListView) findViewById(R.id.listView1);

        map.put("uesrName", "李四");
        map.put("content", "沉迷于诸葛亮的颜值无法自拔");
        list1.add(map);
        map = new HashMap<String, Object>();
        map.put("uesrName", "王五");
        map.put("content", "寝室零食店开业了，快来参观吧....");
        list1.add(map);
        map = new HashMap<String, Object>();
        map.put("uesrName", "张三");
        map.put("content", "最近烦心事好多好烦啊！！");
        list1.add(map);
        map = new HashMap<String, Object>();
        map.put("uesrName", "XXX");
        map.put("content", "xxxxxxxxxxxxxxxxxxxx");
        list1.add(map);
        mySimpleAdapter mySimpleAdapter = new mySimpleAdapter(this, list1, R.layout.discovery_circelfriend_item,
                new String[]{"uesrName", "content"},new int[]{R.id.userName, R.id.content});
        listView1.setAdapter(mySimpleAdapter);
    }

    public void goToNotice(Context context){
        intent = new Intent(context, Message_Notice.class);
        startActivity(intent);
    }

    public class mySimpleAdapter extends SimpleAdapter {

        View view;

        public mySimpleAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to) {
            super(context, data, resource, from, to);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            view = super.getView(position, convertView, parent);
            ShineButton shineButton_heart = (ShineButton) view.findViewById(R.id.id_shineButton_heart);
            ShineButton shineButton_forward = (ShineButton) view.findViewById(R.id.id_shineButton_forward);
            shineButton_heart.init(Discovery_circelFriend.this);
            shineButton_forward.init(Discovery_circelFriend.this);
            return view;
        }
    }


}

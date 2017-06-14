package com.example.chipmunk.sprout.Discover;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.chipmunk.sprout.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Discovery_circelFriend extends Activity {
    private ListView listView1;
    private List<Map<String,Object>> list1=new ArrayList<>();
    private Map<String, Object> map = new HashMap<String, Object>();
    boolean change= true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.discovery_circelfriend_listview);
        listView1=(ListView)findViewById(R.id.listView1);

        map.put("uesrName", "李四");
        map.put("content", "沉迷于诸葛亮的颜值无法自拔");
        map.put("heart", R.drawable.heart);
        list1.add(map);
        map=new HashMap<String, Object>();
        map.put("uesrName", "王五");
        map.put("content", "寝室零食店开业了，快来参观吧....");
        map.put("heart", R.drawable.whiteheart);
        list1.add(map);
        map=new HashMap<String, Object>();
        map.put("uesrName", "张三");
        map.put("content", "最近烦心事好多好烦啊！！");
        map.put("heart", R.drawable.whiteheart);
        list1.add(map);
        map=new HashMap<String, Object>();
        map.put("uesrName", "XXX");
        map.put("content", "xxxxxxxxxxxxxxxxxxxx");
        map.put("heart", R.drawable.heart);
        list1.add(map);
        SimpleAdapter sa1 = new SimpleAdapter(this, list1, R.layout.discovery_circelfriend_item,
                new String[]{"uesrName", "content","heart"},
                new int[]{R.id.userName, R.id.content,R.id.heart});
        listView1.setAdapter(sa1);
    }




}

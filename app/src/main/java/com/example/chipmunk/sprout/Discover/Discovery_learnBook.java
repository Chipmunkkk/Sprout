package com.example.chipmunk.sprout.Discover;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.chipmunk.sprout.MessageView.Message_Notice;
import com.example.chipmunk.sprout.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Discovery_learnBook extends Activity {
    ListView listView1;
    List<Map<String,Object>> list1=new ArrayList<>();

    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.discovery_learnbook_listview);
        listView1=(ListView)findViewById(R.id.listView1);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("user", R.drawable.head);
        map.put("name", "知心学姐");
        map.put("time", "37分钟前");
        map.put("content", "许多同学为怎么过四、六级而发愁，学姐...");
        map.put("file1", "附件：四六级语法强化知识.zip");
        map.put("file2", "四六级历年真题附模拟试题.7z");
        map.put("date", "05/13");
        map.put("read", "阅读141");
        map.put("response", "回复36");
        list1.add(map);
        map = new HashMap<String, Object>();
        map.put("user", R.drawable.head);
        map.put("name", "帅气学长");
        map.put("time", "14小时前");
        map.put("content", "毕业了留给学弟学妹一些书，有看上的请私我..。");
        map.put("file1", "附件：C++ Primer中文版（第五版）");
        map.put("file2", "Photoshop设计入门到精通");
        map.put("date", "05/13");
        map.put("read", "阅读141");
        map.put("response", "回复36");
        list1.add(map);



        SimpleAdapter sa1=new SimpleAdapter(this,list1,R.layout.discovery_learnbook_item,
                new String[]{"user","name","time","content","file1","file2","date","read","response"},
                new int[]{R.id.user,R.id.name,R.id.time,R.id.content,R.id.file1,R.id.file2,R.id.date,R.id.read,R.id.response});
        SimpleAdapter sa2=new SimpleAdapter(this,list1,R.layout.discovery_learnbook_item,
                new String[]{"user","name"},
                new int[]{R.id.user,R.id.name});
        listView1.setAdapter(sa1);

    }

    public void goToNotice(Context context){
        intent = new Intent(context, Message_Notice.class);
        startActivity(intent);
    }
}

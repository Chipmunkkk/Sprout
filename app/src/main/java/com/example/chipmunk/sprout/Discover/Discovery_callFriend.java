package com.example.chipmunk.sprout.Discover;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

import com.example.chipmunk.sprout.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Discovery_callFriend extends Activity {
    private String[] name1={"不限","关羽","张飞","曹操",};
    private ArrayAdapter<String> adapter1;
    private ListView listView2;
    private List<Map<String,Object>> list1=new ArrayList<>();
    private Map<String, Object> map = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.discovery_callfriend_listview);
        //实现条件选择
        Spinner spinner1 = (Spinner) findViewById(R.id.callfriend1);
        Spinner spinner2 = (Spinner) findViewById(R.id.callfriend2);
        Spinner spinner3 = (Spinner) findViewById(R.id.callfriend3);
        Spinner spinner4 = (Spinner) findViewById(R.id.callfriend4);
        Spinner spinner5 = (Spinner) findViewById(R.id.callfriend5);
        Spinner spinner6 = (Spinner) findViewById(R.id.callfriend6);
        Spinner spinner7 = (Spinner) findViewById(R.id.callfriend7);
        //将可选内容与ArrayAdapter连接起来，simple_spinner_item是android系统自带样式
        adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,name1);
        //设置下拉列表的风格,simple_spinner_dropdown_item是android系统自带的样式，等会自定义修改
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //将adapter 添加到spinner中
        spinner1.setAdapter(adapter1);
        spinner2.setAdapter(adapter1);
        spinner3.setAdapter(adapter1);
        spinner4.setAdapter(adapter1);
        spinner5.setAdapter(adapter1);
        spinner6.setAdapter(adapter1);
        spinner7.setAdapter(adapter1);

        //实现标签页
        ListView listView2= (ListView) findViewById(R.id.listView2);
        map=new HashMap<String, Object>();
        map.put("title","东软广播台");
        list1.add(map);
        map=new HashMap<String, Object>();
        map.put("title","java社团");
        list1.add(map);
        map=new HashMap<String, Object>();
        map.put("title","软工");
        list1.add(map);
        map=new HashMap<String, Object>();
        map.put("title","网络");
        list1.add(map);
        SimpleAdapter sa2=new SimpleAdapter(this,list1,R.layout.discovery_callfriend_item2,
                new String[]{"title"},
                new int[]{R.id.title});

        listView2.setAdapter(sa2);

    }


}

package com.example.chipmunk.sprout.Me;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.example.chipmunk.sprout.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyInformation extends Activity {

    GridView GridView_Basic;
    GridView GridView_School;
    GridView GridView_Personal;

    List<Map<String,String>> DataList_Basic;
    List<Map<String,String>> DataList_School;
    List<Map<String,String>> DataList_Personal;

    SimpleAdapter simpleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.my_information);

        GridView_Basic = (GridView) findViewById(R.id.id_GridView_Basic);
        GridView_School = (GridView) findViewById(R.id.id_GridView_School);
        GridView_Personal = (GridView) findViewById(R.id.id_GridView_Personal);

        DataList_Basic = new ArrayList<>();
        DataList_School = new ArrayList<>();
        DataList_Personal = new ArrayList<>();
        getData_Basic();
        getData_School();
        getData_Personal();

        String[] from = {"dataName","dataValues"};
        int[] to = {R.id.id_GridItem_DataName,R.id.id_GridItem_DataValue};

        simpleAdapter = new SimpleAdapter(this,DataList_Basic,R.layout.gridview_item,from,to);
        GridView_Basic.setAdapter(simpleAdapter);
        simpleAdapter = new SimpleAdapter(this,DataList_School,R.layout.gridview_item,from,to);
        GridView_School.setAdapter(simpleAdapter);
        simpleAdapter = new SimpleAdapter(this,DataList_Personal,R.layout.gridview_item,from,to);
        GridView_Personal.setAdapter(simpleAdapter);
    }

    public List<Map<String,String>> getData_Basic(){
        String[] DataName = {"昵称","性别","生日","所在地","真实姓名"};
        String[] DataValues = {"Null","男","1997-01-01","辽宁 大连","(未填写)"};
        for(int i = 0;i<DataName.length;i++){
            Map<String,String> Data = new HashMap<String,String>();
            Data.put("dataName",DataName[i]);
            Data.put("dataValues",DataValues[i]);
            DataList_Basic.add(Data);
        }
        return DataList_Basic;
    }

    public List<Map<String,String>> getData_School(){
        String[] DataName = {"学校","院系","专业","学历","入学年份"};
        String[] DataValues = {"大连东软信息学院","软件工程系","(未填写)","本科","2015年"};
        for(int i = 0;i<DataName.length;i++){
            Map<String,String> Data = new HashMap<String,String>();
            Data.put("dataName",DataName[i]);
            Data.put("dataValues",DataValues[i]);
            DataList_School.add(Data);
        }
        return DataList_School;
    }

    public List<Map<String,String>> getData_Personal(){
        String[] DataName = {"个性签名","兴趣爱好","近期动向"};
        String[] DataValues = {"请输入个性签名","(未填写)","(未填写)"};
        for(int i = 0;i<DataName.length;i++){
            Map<String,String> Data = new HashMap<String,String>();
            Data.put("dataName",DataName[i]);
            Data.put("dataValues",DataValues[i]);
            DataList_Personal.add(Data);
        }
        return DataList_Personal;
    }

}

package com.example.chipmunk.sprout.Discover;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import com.example.chipmunk.sprout.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiscoveryPage extends Fragment {
    private ListView listView1, listView2, listView3;
    private List<Map<String, Object>> list1 = new ArrayList<>();
    private List<Map<String, Object>> list2 = new ArrayList<>();
    private List<Map<String, Object>> list3 = new ArrayList<>();
    private Map<String, Object> map = new HashMap<String, Object>();
    private SimpleAdapter simpleAdapter = null; // 进行数据的转换操作

    private View view;
    private Intent intent;

    public DiscoveryPage(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.activity_discovery_listview, null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listView1 = (ListView) view.findViewById(R.id.listView1);
        listView2 = (ListView) view.findViewById(R.id.listView2);
        listView3 = (ListView) view.findViewById(R.id.listView3);

        map.put("img", R.drawable.circle_friends);
        map.put("text", "校友圈");
        list1.add(map);

        map = new HashMap<String, Object>();
        map.put("img", R.drawable.learning_book);
        map.put("text", "学习宝典");
        list2.add(map);
        map = new HashMap<String, Object>();
        map.put("img", R.drawable.schedule);
        map.put("text", "课程表");
        list2.add(map);

        map = new HashMap<String, Object>();
        map.put("img", R.drawable.nearby_people);
        map.put("text", "附近的人");
        list3.add(map);
        map = new HashMap<String, Object>();
        map.put("img", R.drawable.call_teammate);
        map.put("text", "召唤队友");
        list3.add(map);


        SimpleAdapter sa1 = new SimpleAdapter(getActivity(), list1, R.layout.activity_discovery_item, new String[]{"img", "text"}, new int[]{R.id.circleFriendsImg, R.id.circleFriendsText});
        SimpleAdapter sa2 = new SimpleAdapter(getActivity(), list2, R.layout.activity_discovery_item, new String[]{"img", "text"}, new int[]{R.id.circleFriendsImg, R.id.circleFriendsText});
        SimpleAdapter sa3 = new SimpleAdapter(getActivity(), list3, R.layout.activity_discovery_item, new String[]{"img", "text"}, new int[]{R.id.circleFriendsImg, R.id.circleFriendsText});
        listView1.setAdapter(sa1);
        listView2.setAdapter(sa2);
        listView3.setAdapter(sa3);

        listView1.setOnItemClickListener(new OnItemClickListenerImp1());
        listView2.setOnItemClickListener(new OnItemClickListenerImp2());
        listView3.setOnItemClickListener(new OnItemClickListenerImp3());
    }

    private class OnItemClickListenerImp1 implements AdapterView.OnItemClickListener {
        @SuppressWarnings("unchecked")
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            if(position==0) {
                intent = new Intent();
                intent.setClass(getActivity(),Discovery_circelFriend.class);
                startActivity(intent);
                Log.i("aafadfdfdfdsfdsfds", "onItemClick: ");
            }
        }
    }
    private class OnItemClickListenerImp2 implements AdapterView.OnItemClickListener {


        @SuppressWarnings("unchecked")
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            if(position==0) {
                intent = new Intent();
                intent.setClass(getActivity(),Discovery_learnBook.class);
                startActivity(intent);
            }
        }
    }
    private class OnItemClickListenerImp3 implements AdapterView.OnItemClickListener {


        @SuppressWarnings("unchecked")
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            if(position==1) {
                intent = new Intent();
                intent.setClass(getActivity(),Discovery_callFriend.class);
                startActivity(intent);
            }
        }
    }

}


package com.example.chipmunk.sprout.MySchool;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.chipmunk.sprout.CustomView.MyListView;
import com.example.chipmunk.sprout.R;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Callback;
import okhttp3.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyCollege extends Fragment {

    private RollPagerView rollPagerView;
    private MyListView myListView_campus;
    private MyListView myListView_department;
    private View view;
    private noticeAdapter noticeAdapter;
    List<String> Notice_title_campus = new ArrayList<>();
    List<String> Notice_time_campus = new ArrayList<>();

    List<String> Notice_time_deparment = new ArrayList<>();
    List<String> Notice_title_deparment = new ArrayList<>();

    String NoticeTime = "";
    String NoticeTitle = "";

    public MyCollege() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.homepage, container, false);
        initView();//获取对应控件
        rollPagerViewSet();

        sendRequestWithOkHttp_campus();
        sendRequestWithOkHttp_department();

        //setData_campus();
        noticeAdapter = new noticeAdapter(getContext(), Notice_time_campus, Notice_title_campus);
        myListView_campus.setAdapter(noticeAdapter);
        //setData_department();
        noticeAdapter = new noticeAdapter(getContext(), Notice_time_deparment, Notice_title_deparment);
        myListView_department.setAdapter(noticeAdapter);

        return view;
    }

    private void sendRequestWithOkHttp_campus() {
        OkHttpClient client = new OkHttpClient();
        Request.Builder builder = new Request.Builder();

        Request request = builder.get().url("http://169.254.170.244:8080/ch06/campus_notice.json").build();
        Call call = client.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseData_campus = response.body().string();
                parseJSONWithJSONObject_campus(responseData_campus);
            }
        });
    }
    private void sendRequestWithOkHttp_department() {
        OkHttpClient client = new OkHttpClient();
        Request.Builder builder = new Request.Builder();

        Request request = builder.get().url("http://169.254.170.244:8080/ch06/department_notice.json").build();
        Call call = client.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseData_campus = response.body().string();
                parseJSONWithJSONObject_department(responseData_campus);
            }
        });
    }

    private void rollPagerViewSet() {
        rollPagerView.setPlayDelay(3000);//*播放间隔
        rollPagerView.setAnimationDurtion(500);//透明度
        rollPagerView.setAdapter(new rollViewpagerAdapter());//配置适配器
        rollPagerView.setHintView(new ColorPointHintView(getContext(), Color.argb(255, 139, 212, 193), Color.WHITE));
    }

    private void initView() {
        rollPagerView = (RollPagerView) view.findViewById(R.id.rollViewpager);
        myListView_campus = (MyListView) view.findViewById(R.id.id_listView_campusNotice);
        myListView_department = (MyListView) view.findViewById(R.id.id_listView_departmentNotice);
    }


    private class rollViewpagerAdapter extends StaticPagerAdapter {

        private int[] res = {R.drawable.banner_1
                , R.drawable.banner_2,
                R.drawable.banner_3,
                R.drawable.banner_4};

        @Override
        public View getView(ViewGroup container, int position) {
            ImageView imageView = new ImageView(container.getContext());
            imageView.setImageResource(res[position]);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            return imageView;
        }

        @Override
        public int getCount() {
            return res.length;
        }
    }

    private class noticeAdapter extends BaseAdapter {

        Context context;

        List<String> noticeTitle = new ArrayList<>();
        List<String> noticeTime = new ArrayList<>();

        public noticeAdapter(Context context, List<String> noticeTime, List<String> noticeTitle) {
            this.context = context;
            this.noticeTime = noticeTime;
            this.noticeTitle = noticeTitle;
        }

        @Override
        public int getCount() {
            return noticeTime.size();
        }

        @Override
        public Object getItem(int position) {
            return noticeTime.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            View NoticeListViewItem = layoutInflater.inflate(R.layout.notice_listitem_home, null);

            TextView time = (TextView) NoticeListViewItem.findViewById(R.id.id_notice_time_home);
            TextView title = (TextView) NoticeListViewItem.findViewById(R.id.id_notice_title_home);

            time.setText(noticeTime.get(position));
            title.setText(noticeTitle.get(position));

            return NoticeListViewItem;
        }
    }

    private void parseJSONWithJSONObject_campus(String jsonData_campus) {
        try {
            JSONArray jsonArray_campus = new JSONArray(jsonData_campus);
            for (int i = 0; i < jsonArray_campus.length(); i++) {
                JSONObject jsonObject_campus = jsonArray_campus.getJSONObject(i);
                this.NoticeTime = jsonObject_campus.getString("time");
                this.NoticeTitle = jsonObject_campus.getString("title");
                Notice_time_campus.add(NoticeTime);
                Notice_title_campus.add(NoticeTitle);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parseJSONWithJSONObject_department(String jsonData_department) {
        try {
            JSONArray jsonArray_department = new JSONArray(jsonData_department);
            for (int i = 0; i < jsonArray_department.length(); i++) {
                JSONObject jsonObject_department = jsonArray_department.getJSONObject(i);
                this.NoticeTime = jsonObject_department.getString("time");
                this.NoticeTitle = jsonObject_department.getString("title");
                Notice_time_deparment.add(NoticeTime);
                Notice_title_deparment.add(NoticeTitle);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

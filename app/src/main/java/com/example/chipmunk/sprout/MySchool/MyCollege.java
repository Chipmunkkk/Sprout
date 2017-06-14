package com.example.chipmunk.sprout.MySchool;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
        setData_campus();
        noticeAdapter = new noticeAdapter(getContext(),Notice_time_campus,Notice_title_campus);
        myListView_campus.setAdapter(noticeAdapter);
        setData_department();
        noticeAdapter = new noticeAdapter(getContext(),Notice_time_deparment,Notice_title_deparment);
        myListView_department.setAdapter(noticeAdapter);
        return view;
    }

    public void setData_campus(){
        Notice_time_campus.add("06-07");
        Notice_time_campus.add("06-06");
        Notice_time_campus.add("06-05");
        Notice_time_campus.add("06-05");
        Notice_time_campus.add("06-05");

        Notice_title_campus.add("我校学生在第七届全国大学生计算机应用大赛");
        Notice_title_campus.add("数字艺术系举行第七届数字春天及第二届");
        Notice_title_campus.add("第一届\"古韵东软\"传统文化嘉年华举行");
        Notice_title_campus.add("我校成为多家辽宁省校企联盟会员单位");
        Notice_title_campus.add("伊藤忠商一行来校参观");
    }

    public void setData_department(){
        Notice_time_deparment.add("06-12");
        Notice_time_deparment.add("06-06");
        Notice_time_deparment.add("06-06");
        Notice_time_deparment.add("06-06");
        Notice_time_deparment.add("06-06");

        Notice_title_deparment.add("2017年Google移动应用软件开发(Android)课程建设研讨会");
        Notice_title_deparment.add("\"对话世界-TALK TO THE WORLD\"系列活动的通知");
        Notice_title_deparment.add("祝贺我系学子在第七届全国大学生计算机应用能力与信息素养大赛中喜获佳绩");
        Notice_title_deparment.add("[亿达信息技术有限公司职位]招聘,6月13日 17:20在A3-221宣讲");
        Notice_title_deparment.add("第八期\"青马培训\"颁奖典礼暨第八届\"加油团支部!\"--班风班貌风采展示大赛邀请函");
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

    private class noticeAdapter extends BaseAdapter{

        Context context;

        List<String> noticeTitle = new ArrayList<>();
        List<String> noticeTime = new ArrayList<>();

        public noticeAdapter(Context context,List<String> noticeTime,List<String> noticeTitle){
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

}

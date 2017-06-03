package com.example.chipmunk.sprout.MessageView;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.chipmunk.sprout.R;

public class Message_Notice extends Activity {

    private ListView Message_Notice_listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.message_notice);
        Message_Notice_listView = (ListView) findViewById(R.id.Message_Notice_listView);
        Message_Notice_listView.setAdapter(new Message_Notice_listAdapter(Message_Notice.this));
    }

    class Message_Notice_listAdapter extends BaseAdapter{

        Context context;
        String[] NoticeTitle = {"zhangsirou@neusoft.edu.cn","DNUI-软件工程系","软件15002班班级群"};
        String[] NoticeSummary = {"转发: 关于开展2017年走读工作通知","我愿为你记录下这一刻,只因它是属于你的盛景","@全体成员"};
        int[] NotcieIcon = {R.drawable.email,R.drawable.weibo,R.drawable.qq};
        String[] NoticeTime = {"5月11日","5月11日","5月11日"};

        public Message_Notice_listAdapter(Context context){
            this.context = context;
        }

        @Override
        public int getCount() {
            return NoticeTitle.length;
        }

        @Override
        public Object getItem(int position) {
            return NoticeTitle[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            View NoticeListViewItem = layoutInflater.inflate(R.layout.notice_listitem,null);

            ImageView View_NoticeIcon = (ImageView) NoticeListViewItem.findViewById(R.id.NoticeListItem_NoticeIcon);
            TextView View_NoticeTitle = (TextView) NoticeListViewItem.findViewById(R.id.NoticeListItem_NoticeTitle);
            TextView View_NoticeSummary = (TextView) NoticeListViewItem.findViewById(R.id.NoticeListItem_NoticeSummary);
            TextView View_NoticeTime = (TextView) NoticeListViewItem.findViewById(R.id.NoticeListItem_NoticeTime);

            View_NoticeIcon.setImageResource(NotcieIcon[position]);
            View_NoticeTitle.setText(NoticeTime[position]);
            View_NoticeSummary.setText(NoticeSummary[position]);
            View_NoticeTime.setText(NoticeTime[position]);
            return NoticeListViewItem;
        }
    }
}

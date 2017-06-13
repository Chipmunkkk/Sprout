package com.example.chipmunk.sprout.MessageView;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chipmunk.sprout.R;
import com.example.chipmunk.sprout.Utils.MyDatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class Message_Notice extends Activity {

    private ListView Message_Notice_listView;
    private MyDatabaseHelper databaseHelper;

    List<String> Notice_title = new ArrayList<>();
    List<String> Notice_summary = new ArrayList<>();
    List<Integer> Notice_icon = new ArrayList<>();
    List<String> Notice_time = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.message_notice);
        databaseHelper = new MyDatabaseHelper(this, "Notice.db", null, 1);
        databaseHelper.getWritableDatabase();
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        Cursor cursor = db.query("Notice", null, null, null, null, null, null);
        int i = 0;
        if (cursor.moveToFirst()) {
            do {
                Notice_title.add(cursor.getString(cursor.getColumnIndex("Notice_title")));
                Notice_summary.add(cursor.getString(cursor.getColumnIndex("Notice_summary")));
                Notice_icon.add(cursor.getInt(cursor.getColumnIndex("Notice_icon")));
                Notice_time.add(cursor.getString(cursor.getColumnIndex("Notice_time")));
                i++;
            } while (cursor.moveToNext());
        }
        cursor.close();

        Message_Notice_listView = (ListView) findViewById(R.id.Message_Notice_listView);
        Message_Notice_listView.setAdapter(new Message_Notice_listAdapter(Message_Notice.this, Notice_title, Notice_summary, Notice_icon, Notice_time));

    }

    class Message_Notice_listAdapter extends BaseAdapter {

        Context context;

        List<String> Notice_title = new ArrayList<>();
        List<String> Notice_summary = new ArrayList<>();
        List<Integer> Notice_icon = new ArrayList<>();
        List<String> Notice_time = new ArrayList<>();

        public Message_Notice_listAdapter(Context context, List<String> Notice_title, List<String> Notice_summary, List<Integer> Notice_icon, List<String> Notice_time) {
            this.context = context;
            this.Notice_title = Notice_title;
            this.Notice_summary = Notice_summary;
            this.Notice_icon = Notice_icon;
            this.Notice_time = Notice_time;
        }

        @Override
        public int getCount() {
            return Notice_title.size();
        }

        @Override
        public Object getItem(int position) {
            return Notice_title.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            View NoticeListViewItem = layoutInflater.inflate(R.layout.notice_listitem, null);

            ImageView View_NoticeIcon = (ImageView) NoticeListViewItem.findViewById(R.id.NoticeListItem_NoticeIcon);
            TextView View_NoticeTitle = (TextView) NoticeListViewItem.findViewById(R.id.NoticeListItem_NoticeTitle);
            TextView View_NoticeSummary = (TextView) NoticeListViewItem.findViewById(R.id.NoticeListItem_NoticeSummary);
            TextView View_NoticeTime = (TextView) NoticeListViewItem.findViewById(R.id.NoticeListItem_NoticeTime);

            View_NoticeIcon.setImageResource(Notice_icon.get(position));
            View_NoticeTitle.setText(Notice_title.get(position));
            View_NoticeSummary.setText(Notice_summary.get(position));
            View_NoticeTime.setText(Notice_time.get(position));
            return NoticeListViewItem;
        }
    }
}

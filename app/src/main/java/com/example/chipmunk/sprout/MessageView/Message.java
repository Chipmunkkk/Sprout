package com.example.chipmunk.sprout.MessageView;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.chipmunk.sprout.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Message extends Fragment {

    private View view;
    private ListView MessageListView;
    private Intent intent;


    public Message() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.message, null);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        MessageListView = (ListView) view.findViewById(R.id.Message_listView);
        MessageListView.setAdapter(new MessageListAdapter(getActivity()));
        MessageListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                intent = new Intent();
                intent.setClass(getActivity(),Message_Chat.class);
                startActivity(intent);
            }
        });
    }
    public class MessageListAdapter extends BaseAdapter {
        Context context;

        //测试样例,最后从本地或数据库中读取
        String[] MessageItem_UsrName = {"李四","王五"};
        int[] MessageItem_Icon = {R.drawable.sprout,R.drawable.sprout};
        String[] MessageItem_Message = {"今天有空么????","A5怎么走?"};
        String[] MessageItem_Time = {"08:21","昨天"};

        public MessageListAdapter(Context context){
            this.context = context;
        }

        @Override
        public int getCount() {
            return MessageItem_UsrName.length;
        }

        @Override
        public Object getItem(int position) {
            return MessageItem_UsrName[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            View MessageListViewItem = layoutInflater.inflate(R.layout.message_listitem,null);

            //获取listview中各元素
            ImageView UsrIcon = (ImageView) MessageListViewItem.findViewById(R.id.MessageListItem_UsrIcon);
            TextView UsrName = (TextView) MessageListViewItem.findViewById(R.id.MessageListItem_UsrName);
            TextView MessageContext = (TextView) MessageListViewItem.findViewById(R.id.MessageListItem_Message);
            TextView MessageTime = (TextView) MessageListViewItem.findViewById(R.id.MessageListItem_Time);

            //为各元素设置属性
            UsrIcon.setImageResource(MessageItem_Icon[position]);
            UsrName.setText(MessageItem_UsrName[position]);
            MessageContext.setText(MessageItem_Message[position]);
            MessageTime.setText(MessageItem_Time[position]);
            return MessageListViewItem;
        }
    }
}

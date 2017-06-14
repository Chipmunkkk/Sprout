package com.example.chipmunk.sprout.MessageView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chipmunk.sprout.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Message extends Fragment {

    private View view;
    private ListView MessageListView;
    private Intent intent;

    MessageListAdapter messageListAdapter;

    List<String> MessageItem_UsrName = new ArrayList<String>();
    List<Integer> MessageItem_Icon = new ArrayList<Integer>();
    List<String> MessageItem_Message = new ArrayList<String>();
    List<String> MessageItem_Time = new ArrayList<String>();

    public Message() {
        // Required empty public constructor
    }

    public void setData(){
        MessageItem_UsrName.add("李四");
        MessageItem_UsrName.add("王五");

        MessageItem_Icon.add(R.drawable.sprout);
        MessageItem_Icon.add(R.drawable.sprout);

        MessageItem_Message.add("今天有空么????");
        MessageItem_Message.add("A5怎么走?");

        MessageItem_Time.add("08:21");
        MessageItem_Time.add("昨天");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.message, null);
        return view;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, 0, Menu.NONE, "删除");
        menu.add(0, 1, Menu.NONE, "置顶");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item
                .getMenuInfo();
        switch (item.getItemId()) {
            case 0:
                Toast.makeText(getActivity(), "1", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(getActivity(), "2", Toast.LENGTH_SHORT).show();
                break;
            default:
                return super.onContextItemSelected(item);
        }
        messageListAdapter.notifyDataSetChanged();
        return true;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setData();
        MessageListView = (ListView) view.findViewById(R.id.Message_listView);
        messageListAdapter = new MessageListAdapter(getActivity(),MessageItem_UsrName,MessageItem_Icon,MessageItem_Message,MessageItem_Time);
        MessageListView.setAdapter(messageListAdapter);
        MessageListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                intent = new Intent();
                intent.setClass(getActivity(), Message_Chat.class);
                String name = MessageItem_UsrName.get(position);
                intent.putExtra("usrName",name);
                startActivity(intent);
            }
        });
        registerForContextMenu(MessageListView);
    }

    public class MessageListAdapter extends BaseAdapter {
        Context context;

        //测试样例,最后从本地或数据库中读取
        List<String> MessageItem_UsrName = new ArrayList<String>();
        List<Integer> MessageItem_Icon = new ArrayList<Integer>();
        List<String> MessageItem_Message = new ArrayList<String>();
        List<String> MessageItem_Time = new ArrayList<String>();

        public MessageListAdapter(Context context, List<String> MessageItem_UsrName, List<Integer> MessageItem_Icon, List<String> MessageItem_Message, List<String> MessageItem_Time) {
            this.context = context;
            this.MessageItem_UsrName = MessageItem_UsrName;
            this.MessageItem_Icon = MessageItem_Icon;
            this.MessageItem_Message = MessageItem_Message;
            this.MessageItem_Time = MessageItem_Time;
        }

        @Override
        public int getCount() {
            return MessageItem_UsrName.size();
        }

        @Override
        public Object getItem(int position) {
            return MessageItem_UsrName.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            View MessageListViewItem = layoutInflater.inflate(R.layout.message_listitem, null);

            //获取listview中各元素
            ImageView UsrIcon = (ImageView) MessageListViewItem.findViewById(R.id.MessageListItem_UsrIcon);
            TextView UsrName = (TextView) MessageListViewItem.findViewById(R.id.MessageListItem_UsrName);
            TextView MessageContext = (TextView) MessageListViewItem.findViewById(R.id.MessageListItem_Message);
            TextView MessageTime = (TextView) MessageListViewItem.findViewById(R.id.MessageListItem_Time);

            //为各元素设置属性
            UsrIcon.setImageResource(MessageItem_Icon.get(position));
            UsrName.setText(MessageItem_UsrName.get(position));
            MessageContext.setText(MessageItem_Message.get(position));
            MessageTime.setText(MessageItem_Time.get(position));
            return MessageListViewItem;
        }
    }
}

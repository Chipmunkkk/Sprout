package com.example.chipmunk.sprout.MessageView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.chipmunk.sprout.Data.Chat;
import com.example.chipmunk.sprout.R;

import java.util.ArrayList;
import java.util.List;

public class Message_Chat extends Activity {

    private ListView Message_Chat_listView;
    private EditText InputMessage;
    private Button sendMessage;
    private Message_ChatAdapter message_chatAdapter;
    private List<Chat> messageList = new ArrayList<Chat>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_chat);
        initMessages();
        Intent intent = getIntent();
        if(intent!=null){
            String name = intent.getStringExtra("usrName");
            TextView messageResource = (TextView) findViewById(R.id.TitleTxtView_MessageResource);
            Log.d("111111", "onCreate: "+messageResource.getText().toString());
            messageResource.setText(name);
        }
        message_chatAdapter = new Message_ChatAdapter(Message_Chat.this,R.layout.chat_listitem,messageList);
        InputMessage = (EditText) findViewById(R.id.InputMessage);
        sendMessage = (Button) findViewById(R.id.Btn_SendMessage);
        Message_Chat_listView = (ListView) findViewById(R.id.Message_Chat_listView);
        Message_Chat_listView.setAdapter(message_chatAdapter);
        sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = InputMessage.getText().toString();
                if(!"".equals(content)){
                    Chat chat = new Chat(content,Chat.TYPE_SENT);
                    messageList.add(chat);
                    message_chatAdapter.notifyDataSetChanged();
                    Message_Chat_listView.setSelection(messageList.size());
                    InputMessage.setText("");
                }
            }
        });
    }

    private void initMessages(){
        Chat chat_1 = new Chat("Hello guy.",Chat.TYPE_RECEIVED);
        Chat chat_2 = new Chat("Hello.Who is that.",Chat.TYPE_SENT);
        Chat chat_3 = new Chat("This is Tom.Nice talking to you.",Chat.TYPE_RECEIVED);
        messageList.add(chat_1);
        messageList.add(chat_2);
        messageList.add(chat_3);

    }

    public class Message_ChatAdapter extends ArrayAdapter<Chat>{
        private int resourceId;

        public Message_ChatAdapter(Context context,int textViewResourceId, List<Chat> objects){
            super(context,textViewResourceId,objects);
            resourceId = textViewResourceId;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            Chat chat = getItem(position);
            View view;
            ViewHolder viewHolder;
            if(convertView == null){
                view = LayoutInflater.from(getContext()).inflate(resourceId,null);
                viewHolder = new ViewHolder();
                viewHolder.leftLayout = (LinearLayout) view.findViewById(R.id.Chat_LeftLayout);
                viewHolder.rightLayout = (LinearLayout) view.findViewById(R.id.Chat_RightLayout);

                viewHolder.leftMessage = (TextView) view.findViewById(R.id.Chat_LeftMessage);
                viewHolder.rightMessage = (TextView) view.findViewById(R.id.Chat_RightMessage);
                view.setTag(viewHolder);
            }else {
                view = convertView;
                viewHolder = (ViewHolder)view.getTag();
            }

            if(chat.getType() == Chat.TYPE_RECEIVED){
                viewHolder.leftLayout.setVisibility(View.VISIBLE);
                viewHolder.rightLayout.setVisibility(View.GONE);
                viewHolder.leftMessage.setText(chat.getContent());
            }else if(chat.getType() == Chat.TYPE_SENT){
                viewHolder.leftLayout.setVisibility(View.GONE);
                viewHolder.rightLayout.setVisibility(View.VISIBLE);
                viewHolder.rightMessage.setText(chat.getContent());
            }
            return view;
        }

        class ViewHolder{
            LinearLayout leftLayout;
            LinearLayout rightLayout;

            TextView leftMessage;
            TextView rightMessage;
        }
    }

}

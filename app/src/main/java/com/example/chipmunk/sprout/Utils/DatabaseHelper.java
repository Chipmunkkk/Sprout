package com.example.chipmunk.sprout.Utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Chipmunk on 2017/5/31.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String CREATE_CHAT_MESSAGE = "create table Chat_Message("
            + "id_message integer primary key autoincrement"
            + "sender_name text"
            + "receiver_name text"
            + "message_content text"
            + "message_date text)";

    private Context context;

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_CHAT_MESSAGE);
        Toast.makeText(context,"Created Succeeded",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

package com.example.alexf.ifsp.banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MessageOpenHelper extends SQLiteOpenHelper {
    public static final String TABLE_MESSAGES = "messages";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_AUTHOR = "author";
    public static final String COLUMN_MESSAGE = "message";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "messages.db";
    private static final String DATABASE_CREATE = "create table "
            + TABLE_MESSAGES + "(" + COLUMN_ID + " integer primary key autoincrement, "
            + COLUMN_AUTHOR + " text not null" + COLUMN_MESSAGE + " text not null);";


    public MessageOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This implementation will destroy all the old data, which // probably isn't what you want to do in a real application.
        db.execSQL("drop table if exists " + TABLE_MESSAGES);
        onCreate(db);
    }
}
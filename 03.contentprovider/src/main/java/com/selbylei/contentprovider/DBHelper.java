package com.selbylei.contentprovider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by selbylei on 17/1/20.
 */

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "atguigu.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建表person
        Log.i("TAG", "onCreate()... ");
        db.execSQL("create table person(_id integer primary key autoincrement, name varchar)");
        //插入初始化数据
        db.execSQL("insert into person (name) values('Tom')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

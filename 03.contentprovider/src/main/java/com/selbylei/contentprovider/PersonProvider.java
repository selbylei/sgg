package com.selbylei.contentprovider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by selbylei on 17/1/20.
 * PersonProvider
 */

public class PersonProvider extends ContentProvider {

    private DBHelper dbHelper;
    private static final String TAG = PersonProvider.class.getSimpleName();

    //定义一个存放uri的一个容器
    private static UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);

    /**
     * 保存一些合法的uri
     * content://com.selbylei.contentprovider.PersonProvider/person   不根据id操作
     * content://com.selbylei.contentprovider.PersonProvider/person/#  根据id操作
     */

    static {
        matcher.addURI("com.selbylei.contentprovider.PersonProvider", "/person", 1);
        matcher.addURI("com.selbylei.contentprovider.PersonProvider", "/person/#", 2);//匹配任意数据
    }

    public PersonProvider() {
        Log.i(TAG, "PersonProvider()");
    }

    @Override
    public boolean onCreate() {
        Log.i(TAG, "onCreate()");
        dbHelper = new DBHelper(getContext());
        return false;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        Log.i(TAG, "query()");

        //得到连接对象
        SQLiteDatabase database = dbHelper.getReadableDatabase();

        /**
         * 1.匹配uri,返回code
         * 如果合法，进行查询
         * 如果不正常，抛出异常
         */
        int code = matcher.match(uri);

        if (code == 1) {//不根据id查询
            return database.query("person", projection, selection, selectionArgs, null, null, null);
        } else if (code == 2) {//根据id查询
            //得到id
            long id = ContentUris.parseId(uri);
            //执行查询语句
            return database.query("person", projection, "_id=?", new String[]{id + ""}, null, null, null);

        } else {
            throw new RuntimeException("查询的uri不合法");
        }
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        Log.i(TAG, "getType()");
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        Log.i(TAG, "insert()");
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        Log.i(TAG, "delete()");
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        Log.i(TAG, "update()");
        return 0;
    }
}

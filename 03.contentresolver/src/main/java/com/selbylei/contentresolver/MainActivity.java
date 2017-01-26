package com.selbylei.contentresolver;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.icu.text.DateFormat;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private ContentResolver mResolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mResolver = getContentResolver();
    }

    /**
     * 根据Id查询
     *
     * @param view
     */
    public void queryById(View view) {

        Uri uri = Uri.parse("content://com.selbylei.contentprovider.PersonProvider/person/1");
        Cursor cursor = mResolver.query(uri, null, null, null, null);

        if (cursor != null) {
            //取出cursor中的数据
            if (cursor.moveToNext()) {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                Toast.makeText(this, id + ":" + name, Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "数据查询失败", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 无id查询
     * @param view
     */
    public void queryNoneId(View view) {
        List<Person> personList = new ArrayList<>();
        Uri uri = Uri.parse("content://com.selbylei.contentprovider.PersonProvider/person");
//        Cursor cursor = mResolver.query(uri, null, "name=?", new String[]{"sebylei"}, null);
        Cursor cursor = mResolver.query(uri, null,  "name=?",new String[]{"selbylei"}, null);
        if (cursor != null) {
            if (cursor.moveToNext()) {
                Person person = new Person();
                person.set_id(cursor.getInt(0));
                person.setName(cursor.getString(1));
                personList.add(person);
                Toast.makeText(this,person.toString(),Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "数据查询失败", Toast.LENGTH_SHORT).show();
            }
        }
    }

    /**
     * 插入
     * @param view
     */
    public void insert(View view) {
        Uri uri = Uri.parse("content://com.selbylei.contentprovider.PersonProvider/person");
        ContentValues cv = new ContentValues();
        cv.put("name","selbylei");
        uri = mResolver.insert(uri,cv);
    }
}

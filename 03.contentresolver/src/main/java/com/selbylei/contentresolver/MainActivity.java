package com.selbylei.contentresolver;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 查询
     *
     * @param view
     */
    public void query(View view) {
        ContentResolver resolver = getContentResolver();
        Uri uri = Uri.parse("content://com.selbylei.contentprovider.PersonProvider/person/1");
        Cursor cursor = resolver.query(uri, null, null, null, null);

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
}

package com.selbylei.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;

public class Demo2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo2);
    }


    //分发
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        Log.i("TAG", "Demo2Activity dispatchKeyEvent() "+event.getKeyCode()+" "+event.getAction());
        return super.dispatchKeyEvent(event);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.i("TAG", "Demo2Activity onKeyDown() "+event.getKeyCode()+" "+event.getAction());
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        Log.i("TAG", "Demo2Activity onKeyUp() "+event.getKeyCode()+" "+event.getAction());
        return super.onKeyUp(keyCode, event);
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        Log.i("TAG", "Demo2Activity onKeyLongPress() "+event.getKeyCode()+" "+event.getAction());
        return super.onKeyLongPress(keyCode, event);
    }
}

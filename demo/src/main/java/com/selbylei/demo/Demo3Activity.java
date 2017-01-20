package com.selbylei.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

public class Demo3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        //设置id为Content的布局的子View

        /**
         * 1.setContentView(Int layoutId)
         * 2.setContentView(View view)
         *   2.1 动态加载布局文件得到视图对象
         *   2.2 动态创建视图对象
         */
//        setContentView(R.layout.activity_demo3);

        //动态加载布局文件得到视图对象
//        View view = View.inflate(this, R.layout.activity_demo3, null);
//        setContentView(view);


        //代码动态创建对象
        TextView tv = new TextView(this);
        tv.setText(Demo3Activity.class.getSimpleName());
        setContentView(tv);


        Window window = getWindow();
        View decorView = window.getDecorView();
        Log.e("TAG", decorView.toString());
        Log.e("TAG", decorView.getClass().getSuperclass().getName());
    }
}

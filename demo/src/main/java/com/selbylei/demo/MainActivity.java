package com.selbylei.demo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.selbylei.demo.Demo1.Demo1Activity;
import com.selbylei.demo.Demo2.Demo2Activity;
import com.selbylei.demo.Demo3.Demo3Activity;
import com.selbylei.demo.Demo4.Demo4Activity;
import com.selbylei.demo.Demo5.Demo5Activity;
import com.selbylei.demo.Demo6.Demo6Activity;
import com.selbylei.demo.adapter.MyAdapter;
import com.selbylei.demo.demo_youku_menu.YoukuMenuActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {


    @BindView(R.id.rv)
    RecyclerView rv;


    private LinearLayoutManager mLayoutManager;
    private List<String> mDataList;
//    private long lastPressBackTime = 0;
    private boolean exit = false; //标识是否退出


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
        initView();
    }


    private void initView() {
        rv.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(mLayoutManager);
        MyAdapter adapter = new MyAdapter(mDataList);
        adapter.setmOnItemClickListener(new MyAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, String str) {
                if (str.equals(Constant.DEMO1)) {
                    Intent intent = new Intent(MainActivity.this, Demo1Activity.class);
                    startActivity(intent);
                } else if (str.equals(Constant.DEMO2)) {
                    Intent intent = new Intent(MainActivity.this, Demo2Activity.class);
                    startActivity(intent);
                } else if (str.equals(Constant.DEMO3)) {
                    Intent intent = new Intent(MainActivity.this, Demo3Activity.class);
                    startActivity(intent);
                } else if (str.equals(Constant.DEMO4)) {
                    Intent intent = new Intent(MainActivity.this, Demo4Activity.class);
                    startActivity(intent);
                } else if (str.equals(Constant.DEMO5)) {
                    Intent intent = new Intent(MainActivity.this, Demo5Activity.class);
                    startActivity(intent);
                } else if (str.equals(Constant.DEMO6)) {
                    Intent intent = new Intent(MainActivity.this, Demo6Activity.class);
                    startActivity(intent);
                } else if (str.equals(Constant.DEMO7)){
                    Intent intent = new Intent(MainActivity.this, YoukuMenuActivity.class);
                    startActivity(intent);
                }
            }
        });

        rv.setAdapter(adapter);
    }

    private void initData() {
        mDataList = new ArrayList<>();
        mDataList.add(Constant.DEMO1);
        mDataList.add(Constant.DEMO2);
        mDataList.add(Constant.DEMO3);
        mDataList.add(Constant.DEMO4);
        mDataList.add(Constant.DEMO5);
        mDataList.add(Constant.DEMO6);
        mDataList.add(Constant.DEMO7);
    }


//    /**
//     * 点击两次退出
//     *  方法一
//     *
//     * @param keyCode
//     * @param event
//     * @return
//     */
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        //监听返回按钮
//        if (keyCode == KeyEvent.KEYCODE_BACK) {
//            //当前时间
//            long currentTime = System.currentTimeMillis();
//            if (lastPressBackTime == 0) { //第一次按
//                lastPressBackTime = currentTime;
//            } else {
//                if (currentTime - lastPressBackTime <= 500) { //如果相差500ms
//                    new AlertDialog.Builder(this)
//                            .setMessage("你确定退出吗？")
//                            .setPositiveButton("退出", new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialog, int which) {
//                                    finish();
//                                }
//                            })
//                            .setNegativeButton("再看看", null).show();
//                }
//                lastPressBackTime = currentTime;
//            }
//            return true;
//        }
//        return super.onKeyDown(keyCode, event);
//    }


    //将exit赋值为false；
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                exit = false;
            }
        }
    };

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (!exit) {
                exit = true;
                Toast.makeText(this, "再按一次退出应用", Toast.LENGTH_SHORT).show();
                handler.sendEmptyMessageDelayed(1, 2000);
                return true;
            }
        }
        return super.onKeyUp(keyCode, event);
    }
}

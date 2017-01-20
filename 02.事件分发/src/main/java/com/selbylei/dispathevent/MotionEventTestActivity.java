package com.selbylei.dispathevent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MotionEventTestActivity extends AppCompatActivity {

    private final static String TAG = MotionEventTestActivity.class.getSimpleName();

    @BindView(R.id.iv_level3)
    MyImageView ivLevel3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motion_event_test);
        ButterKnife.bind(this);
        setListen();
    }

    private void setListen() {
        ivLevel3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.i("TAG", "ivLevel3.setOnTouchListener " + event.getAction());
                return false;
            }
        });
    }

    /**
     * activity事件分发监听函数
     *
     * @param ev
     * @return
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i("TAG", "activity dispatchTouchEvent()" + ev.getAction());
        return super.dispatchTouchEvent(ev);
    }

    /**
     * activity事件处理监听函数
     *
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("TAG", "activity onTouchEvent()" + event.getAction());
        return super.onTouchEvent(event);
    }


}

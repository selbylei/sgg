package com.selbylei.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.selbylei.demo.view.CustomView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class Demo4Activity extends AppCompatActivity {

    private static final String TAG = Demo4Activity.class.getSimpleName();
    private CustomView customView;
    @BindView(R.id.cv)
    CustomView cv;
    @BindView(R.id.btn)
    Button btn;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        1.new一个新的自定义ui对象
//        CustomView customView = new CustomView(this);
//        customView.setText("CustomView");
//        setContentView(customView);

        LinearLayout linearLayout = (LinearLayout) View.inflate(this, R.layout.activity_demo4, null);
        //根据下表找到子view
        customView = (CustomView) linearLayout.getChildAt(0);

        setContentView(linearLayout);
        ButterKnife.bind(this);
    }


    @Override
    protected void onResume() {
        super.onResume();
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            Log.i(TAG, "Left:" + cv.getLeft());
        }
        return super.onTouchEvent(event);
    }


    @OnClick(R.id.btn)
    public void onClick() {
        customView.requestLayout();
        Toast.makeText(this, "customView.requestLayout();", Toast.LENGTH_SHORT).show();
    }
}

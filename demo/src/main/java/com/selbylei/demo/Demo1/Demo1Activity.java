package com.selbylei.demo.Demo1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.selbylei.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Demo1Activity extends AppCompatActivity {

    private int lastX;
    private int lastY;
    private int maxRight;
    private int maxBottom;
    private RelativeLayout parentView;


    /**
     * 原坐标:lastX,lastY
     * 移动后的坐标eventX,eventY
     * 使用layout()绘制图像
     * <p>
     * down时
     * lastX=eventX
     * lastY = eventY
     * move时
     * dx = eventX-lastX
     * dy= eventY-lastY
     * left=imageview.getleft()+dx
     * top = imageView.getTop +dy
     * right=imageview.getRight+dx;
     * bottom=imageview.getbottom+dy;
     * imageView.layout(left,top,right,bottom);
     * lastX=eventX
     * lastY=eventY
     */


    @BindView(R.id.iv)
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        //隐藏标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //隐藏状态栏
        //定义全屏参数
        int flag= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        //设置当前窗体为全屏显示
        window.setFlags(flag, flag);
        setContentView(R.layout.activity_demo1);
        ButterKnife.bind(this);
        parentView = (RelativeLayout) iv.getParent();

        iv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                int eventX = (int) event.getRawX();
                int eventY = (int) event.getRawY();


                switch (event.getAction()) {

                    case MotionEvent.ACTION_DOWN:
                        if (maxRight == 0) {
                            maxRight = parentView.getRight();
                            maxBottom = parentView.getBottom();
                        }
                        lastX = eventX;
                        lastY = eventY;
                        break;
                    case MotionEvent.ACTION_MOVE:
                        //计算事件的偏移
                        int dx = eventX - lastX;
                        int dy = eventY - lastY;
                        //计算偏移量
                        int left = v.getLeft() + dx;
                        int top = v.getTop() + dy;
                        int right = v.getRight() + dx;
                        int bottom = v.getBottom() + dy;
                        //限制left
                        if (left < 0) {
                            right = right - left;
                            left = 0;
                        }
                        //限制right
                        if (right > maxRight) {
                            left -= right - maxRight;
                            right = maxRight;
                        }

                        //限制topt
                        if (top < 0) {
                            bottom = bottom - top;
                            top = 0;
                        }

                        if (bottom > maxBottom) {
                            top -= bottom - maxBottom;
                            bottom = maxBottom;
                        }
                        v.layout(left, top, right, bottom);//重新绘制
                        lastX = eventX;
                        lastY = eventY;
                        break;
                }
                //将touch事件传递给view
                return true;
            }
        });
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event);
    }
}

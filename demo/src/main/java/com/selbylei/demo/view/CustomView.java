package com.selbylei.demo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;


/**
 * Created by selbylei on 17/1/20.
 */

public class CustomView extends TextView {

    private static final String TAG = CustomView.class.getSimpleName();

    //new创建对象
    public CustomView(Context context) {
        super(context);
        Log.i(TAG, "CustomView(Context context)");
    }

    //布局文件创建对象
    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Log.i(TAG, "CustomView(Context context, AttributeSet attrs)");
    }

    /**
     *  使用布局文件创建对象的时候才会调用这个回调函数
     *  重写它：用于得到子View对象
     *
     *
     */


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        Log.i(TAG, "onFinishInflate()");
    }

    /**
     * 关联到window的回调函数
     * 重写它：用于得到子View对象
     *
     */

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.i(TAG, "onAttachedToWindow()");
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Log.i(TAG, "onMeasure:() widthMeasureSpec="+ widthMeasureSpec+" heightMeasureSpec="+heightMeasureSpec);
        int measureWidth = this.getMeasuredWidth();     //测量的宽度
        int measureHeight = this.getMeasuredHeight();    //测量的高度
        Log.i(TAG, "onMeasure:() measureWidth="+ measureWidth+" measureHeight="+measureHeight);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }


    //一般不会重写此方法
    @Override
    public void layout(int l, int t, int r, int b) {
        Log.i(TAG, "layout:() l="+ l+" t="+t+" r="+r+" b="+b);
        super.layout(l, t, r, b);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        Log.i(TAG, "onLayout:() l="+ left+" t="+top+" r="+right+" b="+bottom+" changed="+changed);
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    public void requestLayout() {
        Log.i(TAG, "requestLayout()");
        super.requestLayout();
    }
}

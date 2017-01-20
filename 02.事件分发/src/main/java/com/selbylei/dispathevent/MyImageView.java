package com.selbylei.dispathevent;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;




/**
 * 自定义imageview
 * Created by selbylei on 17/1/19.
 *
 */

public class MyImageView extends ImageView {


    private static final String TAG = MyImageView.class.getSimpleName();

    public MyImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * myImageView的
     * @param event
     * @return
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.i("TAG", "MyImageView dispatchTouchEvent()"+event.getAction());
        return super.dispatchTouchEvent(event);
    }


    /**
     * 执行
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("TAG", "MyImageView onTouchEvent()"+event.getAction());
//        return super.onTouchEvent(event);
        return true;
    }
}

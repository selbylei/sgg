package com.hlingsoft.sgg.fragment;

import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.hlingsoft.sgg.base.BaseFragment;


/**
 * Created by selbylei on 16/12/7.
 */

public class OtherFragment extends BaseFragment {

    public static final String TAG = OtherFragment.class.getSimpleName();

    private TextView textView;

    @Override
    protected View initView() {
         textView = new TextView(mContext);
        textView.setGravity(Gravity.CENTER);
        textView.setText("其他页面");
        return textView;
    }


    @Override
    protected void initData() {
        super.initData();
        Log.e(TAG, "其他Fragment数据初始化了.." );
        textView.setText("其他");
    }
}

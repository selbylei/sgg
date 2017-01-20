package com.hlingsoft.sgg.fragment;

import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.hlingsoft.sgg.base.BaseFragment;


/**
 * Created by selbylei on 16/12/7.
 */

public class CustomFragment extends BaseFragment {

    public static final String TAG = CustomFragment.class.getSimpleName();

    private TextView textView;

    @Override
    protected View initView() {
        textView = new TextView(mContext);
        textView.setGravity(Gravity.CENTER);
        textView.setText("自定义");
         return textView;
    }


    @Override
    protected void initData() {
        super.initData();
        Log.e(TAG, "常用框架Fragment数据初始化了.." );
        textView.setText("自定义控件");
    }
}

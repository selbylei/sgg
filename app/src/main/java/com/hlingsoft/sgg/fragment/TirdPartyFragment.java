package com.hlingsoft.sgg.fragment;

import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.hlingsoft.sgg.base.BaseFragment;


/**
 * Created by selbylei on 16/12/7.
 */

public class TirdPartyFragment extends BaseFragment {

    public static final String TAG = TirdPartyFragment.class.getSimpleName();

    private TextView textView;

    @Override
    protected View initView() {
        textView = new TextView(mContext);
        textView.setText("第三方框架");
        textView.setGravity(Gravity.CENTER);
        return textView;
    }


    @Override
    protected void initData() {
        super.initData();
        Log.e(TAG, "第三方Fragment数据初始化了..");
        textView.setText("第三方");
    }
}

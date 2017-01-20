package com.hlingsoft.sgg.fragment;

import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.hlingsoft.sgg.R;
import com.hlingsoft.sgg.adapter.CommonFragmentAdapter;
import com.hlingsoft.sgg.base.BaseFragment;


/**
 * Created by selbylei on 16/12/7.
 */

public class CommonFragment extends BaseFragment {

    public static final String TAG = CommonFragment.class.getSimpleName();

    private ListView mListView;
    private String[] datas;

    private CommonFragmentAdapter mAdapter;

    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.fragment_common_frame, null);
        mListView = (ListView) view.findViewById(R.id.lv);
        return view;
    }


    @Override
    protected void initData() {
        super.initData();
        Log.e(TAG, "常用框架Fragment数据初始化了..");
        //设置适配器
        datas = new String[]{
                "OKHttp", "xUtils3", "Retrofit2", "Fresco", "Glide", "greenDao", "RxJava", "volley", "Gson", "FastJson", "picasso", "evenBus", "jcvideoplayer", "pulltorefresh", "Expandablelistview", "UniversalVideoView", "....."
        };
        mAdapter = new CommonFragmentAdapter(mContext, datas);
        mListView.setAdapter(mAdapter);
    }
}

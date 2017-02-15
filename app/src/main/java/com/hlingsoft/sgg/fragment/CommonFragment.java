package com.hlingsoft.sgg.fragment;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.hlingsoft.sgg.butterknife.ButterKnifeActivity;
import com.hlingsoft.sgg.R;
import com.hlingsoft.sgg.tablaylout.TabLayoutActivity;
import com.hlingsoft.sgg.adapter.CommonFragmentAdapter;
import com.hlingsoft.sgg.base.BaseFragment;
import com.hlingsoft.sgg.okhttp.OkHttpActivity;
import com.hlingsoft.sgg.xUtils3.xUtils3Activity;


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
        //设置适配器
        datas = new String[]{
                "OKHttp", "xUtils3", "ButterKnife", "Retrofit2", "Fresco", "Glide", "greenDao", "RxJava", "volley", "Gson", "FastJson", "picasso", "evenBus", "jcvideoplayer", "pulltorefresh", "Expandablelistview", "UniversalVideoView", "TabLayout", "....."
        };
        mAdapter = new CommonFragmentAdapter(mContext, datas);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (datas[position].equals("OKHttp")) {
                    Intent intent = new Intent(mContext, OkHttpActivity.class);
                    startActivity(intent);
                } else if (datas[position].equals("xUtils3")) {
                    Intent intent = new Intent(mContext, xUtils3Activity.class);
                    startActivity(intent);
                } else if (datas[position].equals("ButterKnife")) {
                    Intent intent = new Intent(mContext, ButterKnifeActivity.class);
                    startActivity(intent);

                } else if (datas[position].equals("TabLayout")) {
                    Intent intent = new Intent(mContext, TabLayoutActivity.class);
                    startActivity(intent);
                }

            }
        });
    }

}

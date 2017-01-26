package com.hlingsoft.sgg.adapter;


import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hlingsoft.sgg.R;
import com.hlingsoft.sgg.util.ViewHolder;

import static com.hlingsoft.sgg.R.id.tv_name;

/**
 * Created by selbylei on 16/12/7.
 * 常用框架的adapter
 */

public class CommonFragmentAdapter extends BaseAdapter {

    private Context mContext;
    private String[] mDatas;

    public CommonFragmentAdapter(Context context, String[] datas) {
        this.mContext = context;
        this.mDatas = datas;
    }

    @Override
    public int getCount() {
        return mDatas.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.common_fragment_adpater, null);
        }
        TextView name = ViewHolder.get(convertView,R.id.tv_name);
        name.setText(mDatas[position]);
        name.setPadding(20,20,0,10);
        name.setTextSize(20);
        return convertView;
    }
}

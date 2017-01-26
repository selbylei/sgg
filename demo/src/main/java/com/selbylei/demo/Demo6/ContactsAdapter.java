package com.selbylei.demo.Demo6;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.selbylei.demo.R;
import com.selbylei.demo.util.ViewHolder;

import java.util.List;

/**
 * Created by selbylei on 17/1/26.
 */
public class ContactsAdapter extends BaseAdapter {

    private Context mContext;
    private List<User> mUserList;

    public ContactsAdapter(Context context, List<User> userList) {
        mContext = context;
        this.mUserList = userList;
    }

    @Override
    public int getCount() {
        return mUserList.size();
    }

    @Override
    public Object getItem(int position) {
        return mUserList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.adapter_contacts, null);
        }
        TextView name = ViewHolder.get(convertView, R.id.tv_name);
        name.setText(mUserList.get(position).getName());
        TextView phone = ViewHolder.get(convertView, R.id.tv_phone);
        phone.setText(mUserList.get(position).getPhone());

        return convertView;
    }


}

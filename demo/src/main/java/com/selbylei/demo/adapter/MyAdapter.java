package com.selbylei.demo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.selbylei.demo.R;

import java.util.List;


/**
 * Created by selbylei on 17/1/19.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> implements View.OnClickListener,View.OnLongClickListener {

    private List<String> mData;

    public MyAdapter(List<String> data) {
        mData = data;
    }


    private OnRecyclerViewItemClickListener mOnItemClickListener = null;



    private OnRecyclerViewItemLongClickListener mOnTemLongClickListener=null;


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_my_adapter, parent, false);
        ViewHolder vh = new ViewHolder(view);
        view.setOnClickListener(this);
        view.setOnLongClickListener(this);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView.setText(mData.get(position));
        holder.itemView.setTag(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemClick(v, (String) v.getTag());
        }
    }

    @Override
    public boolean onLongClick(View v) {
        if (mOnTemLongClickListener!=null){
            mOnTemLongClickListener.onItemLongClick(v, (String) v.getTag());
        }
        return false;
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        TextView mTextView;

        ViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.tv);
        }
    }


    //设置item点击监听
    public void setmOnItemClickListener(OnRecyclerViewItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    //设置item长按监听
    public void setmOnTemLongClickListener(OnRecyclerViewItemLongClickListener mOnTemLongClickListener) {
        this.mOnTemLongClickListener = mOnTemLongClickListener;
    }

    //定义一个接口
    public interface OnRecyclerViewItemClickListener {
        void onItemClick(View view, String str);
    }

    //item长按
    public interface OnRecyclerViewItemLongClickListener{
        void onItemLongClick(View view, String str);
    }

}

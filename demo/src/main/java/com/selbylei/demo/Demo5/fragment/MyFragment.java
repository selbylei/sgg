package com.selbylei.demo.Demo5.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.selbylei.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by selbylei on 17/1/20.
 */

public class MyFragment extends Fragment {

    @BindView(R.id.tv_content)
    TextView tvContent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        tvContent.setText("MyFragment");
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

}

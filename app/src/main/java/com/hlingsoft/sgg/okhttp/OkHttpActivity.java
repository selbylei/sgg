package com.hlingsoft.sgg.okhttp;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

import com.hlingsoft.sgg.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OkHttpActivity extends FragmentActivity {

    @BindView(R.id.tv_titile)
    TextView tvTitile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http);
        ButterKnife.bind(this);

        tvTitile.setText("OkHttp");
    }
}

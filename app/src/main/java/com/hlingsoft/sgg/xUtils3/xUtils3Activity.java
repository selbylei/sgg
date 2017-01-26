package com.hlingsoft.sgg.xUtils3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.hlingsoft.sgg.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class xUtils3Activity extends AppCompatActivity {

    @BindView(R.id.tv_titile)
    TextView tvTitile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_x_utils3);
        ButterKnife.bind(this);

        initData();
    }

    private void initData() {
        tvTitile.setText("xUtils3");
    }

}

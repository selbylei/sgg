package com.selbylei.dispathevent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_me)
    Button btnMe;
    @BindView(R.id.btn_ke)
    Button btnKe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_me})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_me:
                Intent intent = new Intent(MainActivity.this, MotionEventTestActivity.class);
                startActivity(intent);
                break;

        }
    }

    @OnLongClick(R.id.btn_ke)
    public boolean l(View view) {
        switch (view.getId()) {
            case R.id.btn_ke:
                Intent i = new Intent(MainActivity.this, KeyEventTestActivity.class);
                startActivity(i);
                break;
        }

        return true;
    }

}

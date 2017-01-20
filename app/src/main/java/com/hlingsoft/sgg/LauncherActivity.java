package com.hlingsoft.sgg;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



public class LauncherActivity extends AppCompatActivity {

    public static final String TAG = LauncherActivity.class.getSimpleName();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laucher);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startMainActivity();
            }
        },2000);
    }


    private void startMainActivity(){
        Intent intent = new Intent(LauncherActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }

}

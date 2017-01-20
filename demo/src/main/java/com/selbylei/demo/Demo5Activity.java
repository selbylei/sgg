package com.selbylei.demo;


import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.selbylei.demo.fragment.MyFragment;

public class Demo5Activity extends AppCompatActivity {

    private FragmentTransaction mFt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo5);
        mFt = getFragmentManager().beginTransaction();
        mFt.replace(R.id.activity_demo5_content, new MyFragment()).addToBackStack(null).commit();
    }
}

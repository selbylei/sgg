package com.hlingsoft.sgg;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import com.hlingsoft.sgg.base.BaseFragment;
import com.hlingsoft.sgg.fragment.CommonFragment;
import com.hlingsoft.sgg.fragment.CustomFragment;
import com.hlingsoft.sgg.fragment.OtherFragment;
import com.hlingsoft.sgg.fragment.TirdPartyFragment;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends FragmentActivity {

    private RadioGroup rg_main;
    List<BaseFragment> mFragmentList = null;
    private int position;  //选择的tab对应的位置
    private Fragment mFragment;  //当前显示fragment

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView(); //初始化view
        initFragment(); //舒适化fragment
        setListener();  //设置监听

    }

    private void initView() {
        setContentView(R.layout.activity_main);
        rg_main = (RadioGroup) findViewById(R.id.rg_main);
    }

    private void setListener() {
        rg_main.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_common_frame:     //常用框架
                        position = 0;
                        break;
                    case R.id.rb_thirdparty_frame:  //第三方
                        position = 1;
                        break;
                    case R.id.rb_video_frame:       //自定义
                        position = 2;
                        break;
                    case R.id.rb_netvideo_frame:    //其他
                        position = 3;
                        break;
                    default:
                        position = 0;
                        break;
                }
                //根据position获取fragment
                BaseFragment to = getFragment();
                //fragment替换
                switchFragment(mFragment,to);
            }
        });
        //这个很重用，radio button的初始化一定要放到onCheckedChanged定义之后才能生效。否则无用
        rg_main.check(R.id.rb_common_frame);
    }

    /**
     * from 当前显示的
     * to   将要显示的
     *
     * @param from
     * @param to
     */
    private void switchFragment(Fragment from, Fragment to) {
        if (from != to) {
            mFragment = to;
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            //判断有没有被添加
            if (!to.isAdded()) {
                if (from != null) {
                    ft.hide(from);
                }
                ft.add(R.id.fl_content, to).commit();
            } else {
                if (from != null) {
                    ft.hide(from);
                }
                ft.show(to).commit();
            }
        }
    }

    //根据position获取对应的fragment
    private BaseFragment getFragment() {
        return mFragmentList.get(position);
    }

    private void initFragment() {
        mFragmentList = new ArrayList<BaseFragment>();
        mFragmentList.add(new CommonFragment());
        mFragmentList.add(new TirdPartyFragment());
        mFragmentList.add(new CustomFragment());
        mFragmentList.add(new OtherFragment());
    }


}

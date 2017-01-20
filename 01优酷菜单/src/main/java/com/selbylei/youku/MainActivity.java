package com.selbylei.youku;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.icon_search)
    ImageView iconSearch;
    @BindView(R.id.icon_menu)
    ImageView iconMenu;
    @BindView(R.id.icon_myyouku)
    ImageView iconMyyouku;
    private boolean isShowLeave1 = true; //是否显示第一个圆环
    private boolean isShowLeave2 = true; //是否显示第二个圆环
    private boolean isShowLeave3 = true; //是否显示第三个圆环

    @BindView(R.id.channel1)
    ImageView channel1;
    @BindView(R.id.channel2)
    ImageView channel2;
    @BindView(R.id.channel7)
    ImageView channel7;
    @BindView(R.id.channel6)
    ImageView channel6;
    @BindView(R.id.level3)
    RelativeLayout level3;
    @BindView(R.id.level2)
    RelativeLayout level2;
    @BindView(R.id.level1)
    RelativeLayout level1;
    @BindView(R.id.activity_main)
    RelativeLayout activityMain;
    @BindView(R.id.icon_home)
    ImageView iconHome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.channel1, R.id.channel2, R.id.channel7, R.id.channel6, R.id.level3, R.id.level2, R.id.level1, R.id.icon_home, R.id.icon_menu, R.id.icon_myyouku})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.channel1:
                break;
            case R.id.channel2:
                break;
            case R.id.channel7:
                break;
            case R.id.channel6:
                break;
            case R.id.level3:
                break;
            case R.id.level2:
                break;
            case R.id.level1:
                break;
            case R.id.icon_home:
                //如果三级菜单和二级菜单是显示的，都设置隐藏
                if (isShowLeave2) {
                    isShowLeave2 = false;
                    Tools2.hideView(level2);
                    if (isShowLeave3) {
                        isShowLeave3 = false;
                        Tools2.hideView(level3, 200);
                    }
                } else {
                    isShowLeave2 = true;
                    Tools2.showView(level2);
                }

                break;
            case R.id.icon_search:
                break;
            case R.id.icon_menu:
                if (isShowLeave3) {//隐藏
                    isShowLeave3 = false;
                    Tools2.hideView(level3);
                } else {
                    isShowLeave3 = true;
                    Tools2.showView(level3);
                }
                break;
            case R.id.icon_myyouku:
                break;
        }
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_MENU) {
            //如果1，2，3级菜单隐藏
            if (isShowLeave1) {
                isShowLeave1 = false;
                Tools2.hideView(level1);
                if (isShowLeave2) {
                    isShowLeave2 = false;
                    Tools2.hideView(level2, 200);
                    if (isShowLeave3) {
                        isShowLeave3 = false;
                        Tools2.hideView(level3, 400);
                    }
                }
            } else {
                //如果1，2菜单隐藏，就显示
                isShowLeave1 = true;
                Tools2.showView(level1);
                isShowLeave2 = true;
                Tools2.showView(level2, 200);
            }
            return true;
        }

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Toast.makeText(getApplicationContext(),"点了home按钮",Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onKeyDown(keyCode, event);

    }
}

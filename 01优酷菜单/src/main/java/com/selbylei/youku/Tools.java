package com.selbylei.youku;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;

/**
 * Created by selbylei on 17/1/18.
 * 通过补间动画实现功能
 * 做隐藏时需要把viewGroup的子元素都设置成为enable防止出发点击事件
 *
 */
public class Tools {
    public static void hideView(ViewGroup view) {
        hideView(view, 0);
    }

    public static void showView(ViewGroup view) {
        showView(view, 0);
    }

    public static void hideView(ViewGroup view, int i) {
        RotateAnimation ra = new RotateAnimation(0, 180, view.getWidth() / 2, view.getHeight());
        ra.setDuration(500);        //动画持续时间
        ra.setStartOffset(i);     //设置延迟执行
        ra.setFillAfter(true);      //状态
        view.startAnimation(ra);

        //设置子元素不可点击
        view.setEnabled(false);
        for (i = 0; i < view.getChildCount(); i++) {
            View children = view.getChildAt(i);
            children.setEnabled(false);
        }

    }

    public static void showView(ViewGroup view, int i) {
        RotateAnimation ra = new RotateAnimation(180, 360, view.getWidth() / 2, view.getHeight());
        ra.setDuration(500);        //动画持续时间
        ra.setFillAfter(true);      //状态
        ra.setStartOffset(i);
        view.startAnimation(ra);
        view.setEnabled(true);

        //设置子元素不可点击
        view.setEnabled(false);
        for (i = 0; i < view.getChildCount(); i++) {
            View children = view.getChildAt(i);
            children.setEnabled(false);
        }

    }
}

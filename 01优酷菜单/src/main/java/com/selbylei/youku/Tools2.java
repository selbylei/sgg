package com.selbylei.youku;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;

/**
 * Created by selbylei on 17/1/18.
 * 属性动画实现效果
 */
public class Tools2 {
    public static void hideView(ViewGroup view) {
        hideView(view, 0);
    }

    public static void showView(ViewGroup view) {
        showView(view, 0);
    }

    public static void hideView(ViewGroup view, int startOffset) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "rotation", 0, 180);
        animator.setDuration(500);
        animator.setStartDelay(startOffset);
        animator.start();

        //单独设置中心点击
        view.setPivotX(view.getWidth() / 2);
        view.setPivotY(view.getHeight());
    }

    public static void showView(ViewGroup view, int startOffset) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(view,"rotation",180,360);
        animator.setDuration(500);
        animator.setStartDelay(startOffset);
        animator.start();

        //单独设置中心点击
        view.setPivotX(view.getWidth() / 2);
        view.setPivotY(view.getHeight());

    }
}

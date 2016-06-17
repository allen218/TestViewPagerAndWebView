package com.example.mac.testviewpagerandwebview;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by allen on 16/6/16.
 */
public class CustomViewPager extends ViewPager {
    private int num;   //当前页面数量

    public CustomViewPager(Context context) {
        super(context);
    }

    public CustomViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        return true;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }

    public void setPagerNum(int num) {
        this.num = num;
    }

    /**
     * 获取当前页面总数
     *
     * @return
     */
    public int getPagerNum() {
        return num;
    }
}

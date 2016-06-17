package com.example.mac.testviewpagerandwebview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.webkit.WebView;

/**
 * Created by allen on 16/6/16.
 */
public class CustomWebView extends WebView {
    public CustomWebView(Context context) {
        super(context);
    }

    public CustomWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

        getParent().requestDisallowInterceptTouchEvent(true);

        return false;
    }

    private float downX;
    private float downY;

    private boolean isY;
    private boolean isRightMove;


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                downX = event.getX();
                downY = event.getY();
                return super.onTouchEvent(event);


            case MotionEvent.ACTION_MOVE:
                return super.onTouchEvent(event);


            case MotionEvent.ACTION_UP:
                float upX = event.getX();
                float upY = event.getY();

                //判断是上滑还是下滑
                if (Math.abs(upX - downX) < Math.abs(upY - downY)) {
                    isY = true;
                } else {
                    isY = false;
                }

                //判断是左滑还是右滑
                if (upX - downX > 0) {
                    isRightMove = false;
                } else {
                    isRightMove = true;
                }
                break;
        }

        //如果当前是下滑或者是webview页面内部的左滑就让事件正常传递
        if ("1".equals(JSActionInterface.currrentState) || isY) {
            return super.onTouchEvent(event);
        }

        //到这边说明需要让viewpager去做处理,这里模拟viewpager来消费事件
        ViewParent parent = getParent().getParent();
        if (parent instanceof CustomViewPager) {
            CustomViewPager customViewPager = (CustomViewPager) parent;

            //获取当前viewpager的页数
            int pagerNum = customViewPager.getPagerNum();
            if (pagerNum == 0) {
                throw new RuntimeException("请在创建完viewpager后,设置相应需要显示的页面数");
            }

            if (isRightMove) {
                customViewPager.setCurrentItem((customViewPager.getCurrentItem() + 1) % pagerNum);
            } else {
                customViewPager.setCurrentItem((customViewPager.getCurrentItem() - 1) % pagerNum);

            }
        }

        //还原
        JSActionInterface.currrentState = "0";

        return false;
    }
}




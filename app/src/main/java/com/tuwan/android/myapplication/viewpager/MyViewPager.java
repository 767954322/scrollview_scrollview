package com.tuwan.android.myapplication.viewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by gumenghao on 2018/5/14.
 */

public class MyViewPager extends ViewPager {
    public MyViewPager(Context context) {
        super(context);
    }

    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        int curPosition;

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //由孩子拦截触摸事件
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_MOVE:
                curPosition = this.getCurrentItem();
                int count = this.getAdapter().getCount();
                if (curPosition == (count - 1) || curPosition == 0) {
                    // 当当前页面在最后一页和第0页的时候，由父亲拦截触摸事件
                    getParent().requestDisallowInterceptTouchEvent(false);
                } else {
                    //其他情况，由孩子拦截触摸事件
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                break;
        }
        return super.dispatchTouchEvent(event);
    }

}

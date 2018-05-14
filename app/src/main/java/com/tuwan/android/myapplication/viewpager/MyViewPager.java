package com.tuwan.android.myapplication.viewpager;

import android.content.Context;
import android.graphics.PointF;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by gumenghao on 2018/5/14.
 */

public class MyViewPager extends ViewPager {

    //滑动内部viewpager不给父类
//    /** 触摸时按下的点 **/
//    PointF downP = new PointF();
//    /** 触摸时当前的点 **/
//    PointF curP = new PointF();
//
//    public MyViewPager(Context context, AttributeSet attrs) {
//        super(context, attrs);
//        // TODO Auto-generated constructor stub
//    }
//
//    public MyViewPager(Context context) {
//        super(context);
//        // TODO Auto-generated constructor stub
//    }
//    @Override
//    public boolean onTouchEvent(MotionEvent arg0) {
//        // TODO Auto-generated method stub
//        //每次进行onTouch事件都记录当前的按下的坐标
//        if(getChildCount()<=1)
//        {
//            return super.onTouchEvent(arg0);
//        }
//        curP.x = arg0.getX();
//        curP.y = arg0.getY();
//
//        if(arg0.getAction() == MotionEvent.ACTION_DOWN)
//        {
//
//            //记录按下时候的坐标
//            //切记不可用 downP = curP ，这样在改变curP的时候，downP也会改变
//            downP.x = arg0.getX();
//            downP.y = arg0.getY();
//            //此句代码是为了通知他的父ViewPager现在进行的是本控件的操作，不要对我的操作进行干扰
//            getParent().requestDisallowInterceptTouchEvent(true);
//        }
//
//        if(arg0.getAction() == MotionEvent.ACTION_MOVE){
//            //此句代码是为了通知他的父ViewPager现在进行的是本控件的操作，不要对我的操作进行干扰
//            getParent().requestDisallowInterceptTouchEvent(true);
//        }
//
//        if(arg0.getAction() == MotionEvent.ACTION_UP || arg0.getAction() == MotionEvent.ACTION_CANCEL){
//            //在up时判断是否按下和松手的坐标为一个点
//            //如果是一个点，将执行点击事件，这是我自己写的点击事件，而不是onclick
//            getParent().requestDisallowInterceptTouchEvent(false);
//            if(downP.x==curP.x && downP.y==curP.y){
//
//                return true;
//            }
//        }
//        super.onTouchEvent(arg0); //注意这句不能 return super.onTouchEvent(arg0); 否则触发parent滑动
//        return true;
//    }


    //跟随滑动
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

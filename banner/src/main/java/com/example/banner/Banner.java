package com.example.banner;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import java.util.Timer;
import java.util.TimerTask;

public class Banner extends FrameLayout implements ViewPager.OnPageChangeListener, View.OnTouchListener {
    private final String TAG = "test_banner";
    private ViewPager viewPager;
    private Handler handler;
    private int c_viewpager_postion = 1;
    private Timer timer;
    private int item_count = 0;
    private int width, height;
    private int nav_color;
    private boolean isCarousel = true;
    private int time;


    public Banner(Context context) {
        super(context);
        initViews();
        initHandler();
        if(isCarousel){
            setTimer();
        }
    }

    public Banner(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews();
        initHandler();
        if(isCarousel){
            setTimer();
        }
    }

    public Banner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViews();
        initHandler();
        if(isCarousel){
            setTimer();
        }
    }

    @SuppressLint("NewApi")
    public Banner(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initViews();
        initHandler();
        setTimer();
    }

    public void setAdapter(PagerAdapter adapter) {
        viewPager.setAdapter(adapter);
        item_count = adapter.getCount();
    }

    private void initViews() {
        viewPager = new ViewPager(getContext());
        ViewGroup.LayoutParams lp = new ViewPager.LayoutParams();
        lp.width = ViewGroup.LayoutParams.MATCH_PARENT;
        lp.height = ViewGroup.LayoutParams.MATCH_PARENT;
        viewPager.setLayoutParams(lp);
        viewPager.addOnPageChangeListener(this);
        addView(viewPager);
        viewPager.setOnTouchListener(this);
        viewPager.setCurrentItem(1);
        nav_color = Color.WHITE;
        time = 5000;
    }

    @Override
    public void onDrawForeground(Canvas canvas) {
        super.onDrawForeground(canvas);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.GRAY);
        paint.setDither(true);
        paint.setAntiAlias(true);
        float start_postion = 27.5f;
        for (int i = 0; i < 4; i++) {
            start_postion = 27.5f - 15 * i;
            canvas.drawCircle(width / 2 - dip2px(start_postion), height - dip2px(20), dip2px(2.5f), paint);
        }

//        canvas.drawCircle(width/2  - dip2px(12.5f),height - dip2px(20),dip2px(2.5f),paint);
//        canvas.drawCircle(width/2  + dip2px(2.5f),height - dip2px(20),dip2px(2.5f),paint);
//        canvas.drawCircle(width/2  + dip2px(17.5f),height - dip2px(20),dip2px(2.5f),paint);
        paint.setColor(nav_color);
        float cr_position = 27.5f;
        cr_position = 27.5f - 15 * (c_viewpager_postion - 1);
        canvas.drawCircle(width / 2 - dip2px(cr_position), height - dip2px(20), dip2px(2.5f), paint);
    }

    @SuppressLint("HandlerLeak")
    private void initHandler() {
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case 1001:
                        viewPager.setCurrentItem(++c_viewpager_postion);
                        break;
                    case 1002:
                        viewPager.setCurrentItem(item_count - 2, false);
                        break;
                    case 1003:
                        viewPager.setCurrentItem(1, false);
                        break;
                }
            }
        };
    }

    public void setTime(int time){
        this.time = time;
        timer.cancel();
        timer = null;
        setTimer();
    }

    private void setTimer() {
        if (timer == null) {
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    handler.sendEmptyMessage(1001);
                }
            }, 1000, time);
        }
    }

    public boolean IsCarousel(){
        return isCarousel;
    }

    public void setCarousel(boolean isCarousel){
        this.isCarousel = isCarousel;
        if(isCarousel){
            setTimer();
        }else{
            timer.cancel();
            timer = null;
        }
    }

    public void setNavPointColor(int color){
       nav_color =  color;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = MeasureSpec.getSize(widthMeasureSpec);
        height = MeasureSpec.getSize(heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }


    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {
        // Log.i(TAG, "onPageScrolled: v: " + v);
    }

    @Override
    public void onPageSelected(int i) {
        if (i == 0) {
            handler.sendEmptyMessageDelayed(1002, 350);
            c_viewpager_postion = item_count - 2;
        } else if (i == item_count - 1) {
            handler.sendEmptyMessageDelayed(1003, 350);
            c_viewpager_postion = 1;
        } else {
            c_viewpager_postion = i;
        }
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if(timer != null){
                    timer.cancel();
                    timer = null;
                }
                //Log.i(TAG, "onTouch: ");
                break;
            case MotionEvent.ACTION_UP:
                if(isCarousel){
                    setTimer();
                }
                break;
        }
        return false;
    }

    private int dip2px(float dipValue) {
        final float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    private int px2dip(float pxValue) {
        final float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}

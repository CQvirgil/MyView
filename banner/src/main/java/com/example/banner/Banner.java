package com.example.banner;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
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


    public Banner(Context context) {
        super(context);
        initViews();
        initHandler();
        setTimer();
    }

    public Banner(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews();
        initHandler();
        setTimer();
    }

    public Banner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViews();
        initHandler();
        setTimer();
    }

    @SuppressLint("NewApi")
    public Banner(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initViews();
        initHandler();
        setTimer();
    }

    public void setAdapter(PagerAdapter adapter){
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
    }

    @Override
    public void onDrawForeground(Canvas canvas) {
        super.onDrawForeground(canvas);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setDither(true);
        paint.setAntiAlias(true);
        canvas.drawCircle(width/2 - dip2px(27.5f),height - dip2px(20),dip2px(2.5f),paint);
        canvas.drawCircle(width/2  - dip2px(12.5f),height - dip2px(20),dip2px(2.5f),paint);
        canvas.drawCircle(width/2  + dip2px(2.5f),height - dip2px(20),dip2px(2.5f),paint);
        canvas.drawCircle(width/2  + dip2px(17.5f),height - dip2px(20),dip2px(2.5f),paint);
        paint.setColor(Color.WHITE);
        switch (c_viewpager_postion){
            case 1:
                canvas.drawCircle(width/2 - dip2px(27.5f),height - dip2px(20),dip2px(2.5f),paint);
                break;
            case 2:
                canvas.drawCircle(width/2  - dip2px(12.5f),height - dip2px(20),dip2px(2.5f),paint);
                break;
            case 3:
                canvas.drawCircle(width/2  + dip2px(2.5f),height - dip2px(20),dip2px(2.5f),paint);
                break;
            case 4:
                canvas.drawCircle(width/2  + dip2px(17.5f),height - dip2px(20),dip2px(2.5f),paint);
                break;
        }
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

    private void setTimer() {
        if (timer == null) {
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    handler.sendEmptyMessage(1001);
                }
            }, 1000, 3000);
        }
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
                timer.cancel();
                timer = null;
                //Log.i(TAG, "onTouch: ");
                break;
            case MotionEvent.ACTION_UP:
                setTimer();
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

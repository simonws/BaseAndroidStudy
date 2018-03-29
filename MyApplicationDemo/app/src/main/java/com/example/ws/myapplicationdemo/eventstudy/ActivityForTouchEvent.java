package com.example.ws.myapplicationdemo.eventstudy;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.print.PrintAttributes;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.ws.myapplicationdemo.R;
import com.example.ws.myapplicationdemo.stickylike.StickyLikeActivity;

/**
 * Created by ws on 18-2-2.
 */

public class ActivityForTouchEvent extends Activity {
    private String TAG = "ActivityFor_TouchEvent";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_study_layout);
        TextView textView = (TextView) findViewById(R.id.text_id);
        textView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                startActivity(new Intent(ActivityForTouchEvent.this, StickyLikeActivity.class));
                return true;
            }
        });

        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relative_id);
        relativeLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });

        MyThread thread = new MyThread();
        thread.start(); // 开启线程
//        thread.cancel(); // 中断线程
        Log.d(TAG, "onCreate InterruptedException " + thread.isInterrupted() + " == "
                + Thread.currentThread().getState());

        ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        int memClass = activityManager.getMemoryClass();

    }

    class MyThread extends Thread {
        public void run() {
            int i = 0;
            try {
                while (!Thread.currentThread().isInterrupted()) { // 如果线程没有被中断就继续运行
                    // 阻塞代码：sleep,wait等
                    // 当其他线程，调用此线程的interrupt()方法时，会给此线程设置一个中断标志
                    // sleep,wait等方法会检测这个标志位，同时会抛出InterruptedException，并清除线程的中断标志
                    // 因此在异常段调用Thread.currentThread().isInterrupted()返回为false
                    if (i > 1) {
                        interrupt();
                    }
                    Log.d(TAG, "run InterruptedException 22 " + " == " + Thread.currentThread().getState());
                    Thread.currentThread().sleep(2000);
                    Log.d(TAG, "run InterruptedException 33 " + " == " + Thread.currentThread().getState());
                    i++;
                }
            } catch (InterruptedException e) {
                // 由于阻塞库函数，如：Object.wait,Thread.sleep除了抛出异常外，还会清除线程中断状态，因此可能在这里要保留线程的中断状态
                Log.d(TAG, "run InterruptedException 00 " + isInterrupted() + " == "
                        + Thread.currentThread().getState());
                Thread.currentThread().interrupt();// 从新设置线程的中断标志
            }

            Log.d(TAG, "run InterruptedException 11 " + isInterrupted() + " == "
                    + Thread.currentThread().getState());
        }

        public void cancel() {
            interrupt(); // 中断线程
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}

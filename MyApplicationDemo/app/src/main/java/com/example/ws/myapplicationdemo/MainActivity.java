package com.example.ws.myapplicationdemo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ActionMode;
import android.view.View;

import com.example.ws.myapplicationdemo.bitmap.BitMapActivity;
import com.example.ws.myapplicationdemo.delegate.TestProxyActivity;
import com.example.ws.myapplicationdemo.eventstudy.ActivityForTouchEvent;
import com.example.ws.myapplicationdemo.exception.ExceptionActivity;
import com.example.ws.myapplicationdemo.listviewdemo.ListViewDemoActivity;
import com.example.ws.myapplicationdemo.service.ServiceBindActivity;
import com.example.ws.myapplicationdemo.stickylike.StickyLikeActivity;
import com.example.ws.myapplicationdemo.threadstudy.ThreadStudyDemo;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = "Main_Activity";
    private Thread mThread = new Thread(new Runnable() {
        @Override
        public void run() {
            mThread = null;
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String cacheDir = getCacheDir().getAbsolutePath();
//        showNormalDialog();
        mThread.start();

        String ss = "5555555";
        changeString(ss);
        int tt = 5555;
        changeInt(tt);
        char[] cc = {'a', 'b', 'c'};
        changeChar(cc);
        Log.d(TAG, "oncreate " + ss + " " + tt + "" + cc);
    }

    private void changeChar(char[] cc) {
        cc[1] = 'c';
    }

    private void changeString(String ss) {
        ss = "changed";
    }

    private void changeInt(int ss) {
        ss = 666;
    }

    @Override
    protected void onStart() {
        super.onStart();
//        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void showNormalDialog() {
        /* @setIcon 设置对话框图标
         * @setTitle 设置对话框标题
         * @setMessage 设置对话框消息提示
         * setXXX方法返回Dialog对象，因此可以链式设置属性
         */
        final AlertDialog.Builder normalDialog = new AlertDialog.Builder(MainActivity.this);
        normalDialog.setIcon(R.drawable.delete_bg);
        normalDialog.setTitle("我是一个普通Dialog");
        normalDialog.setMessage("你要点击哪一个按钮呢?");
        normalDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // ...To-do
            }
        });
        normalDialog.setNegativeButton("关闭", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // ...To-do
            }
        });
        // 显示
        normalDialog.show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sticky_btn:
                startActivity(new Intent(this, StickyLikeActivity.class));
                break;
            case R.id.click_event:
                startActivity(new Intent(this, ActivityForTouchEvent.class));
                break;
            case R.id.thread_study:
                startActivity(new Intent(this, ThreadStudyDemo.class));
                break;
            case R.id.service_study:
                startActivity(new Intent(this, ServiceBindActivity.class));
                break;
            case R.id.bitmap_study:
                startActivity(new Intent(this, BitMapActivity.class));
                break;
            case R.id.exception_study:
                startActivity(new Intent(this, ExceptionActivity.class));
                break;
            case R.id.proxy_study:
                startActivity(new Intent(this, TestProxyActivity.class));
                break;
            case R.id.list_study:
                startActivity(new Intent(this, ListViewDemoActivity.class));
                break;
            default:
                break;
        }
    }

    @Override
    public void onActionModeStarted(ActionMode mode) {
        super.onActionModeStarted(mode);
    }
}

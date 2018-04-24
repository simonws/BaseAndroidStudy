package com.example.ws.myapplicationdemo.exception;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.ws.myapplicationdemo.R;

/**
 * Created by ws on 18-3-20.
 */

public class ExceptionActivity extends Activity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.content_main);
        super.onCreate(savedInstanceState);

        TestException testException1 = new TestException();
        try {
            testException1.testEx();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        testError();
    }

    private void testError() {

        try {
            deadMethod();
        } catch (Error e) {
            e.printStackTrace();
        }
    }

    private void deadMethod() {
        deadMethod();
    }
}

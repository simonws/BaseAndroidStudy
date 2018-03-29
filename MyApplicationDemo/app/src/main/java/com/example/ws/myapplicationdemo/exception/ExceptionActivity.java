package com.example.ws.myapplicationdemo.exception;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import com.example.ws.myapplicationdemo.R;

/**
 * Created by ws on 18-3-20.
 */

public class ExceptionActivity extends Activity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        setContentView(R.layout.content_main);
        super.onCreate(savedInstanceState, persistentState);

        TestException testException1 = new TestException();
        try {
            testException1.testEx();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

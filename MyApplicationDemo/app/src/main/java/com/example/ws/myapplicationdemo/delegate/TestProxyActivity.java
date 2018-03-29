package com.example.ws.myapplicationdemo.delegate;

import android.app.Activity;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.ws.myapplicationdemo.R;

import java.lang.reflect.Proxy;

/**
 * Created by ws on 18-3-14.
 */

public class TestProxyActivity extends Activity {
    private static final String TAG = "TestProxy_Activity";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        setContentView(R.layout.event_study_layout);
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    protected void onResume() {
        super.onResume();

        TestProxyImpl proxy = new TestProxyImpl();
        TestProxyInterface proxyInterface = (TestProxyInterface) Proxy.newProxyInstance(proxy.getClass()
            .getClassLoader(), proxy.getClass().getInterfaces(), new ProxyHandleImpl(proxy));
        Log.d(TAG, "onResume " + proxyInterface.getClass().getName());
        proxyInterface.sayHello();
    }
}

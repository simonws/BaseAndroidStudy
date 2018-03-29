package com.example.ws.myapplicationdemo.delegate;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by ws on 18-3-14.
 */

public class ProxyHandleImpl implements InvocationHandler {
    private Object mObject;

    public ProxyHandleImpl(Object o) {
        mObject = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long startTRime = System.currentTimeMillis();
        Object object = method.invoke(mObject, args);
        long endTime = System.currentTimeMillis();

        return object;
    }
}

package com.example.ws.myapplicationdemo.listviewdemo;

import android.content.Context;
import android.support.annotation.Px;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by ws on 18-4-4.
 */

public class MyListView extends ListView {
    public MyListView(Context context) {
        super(context);
    }

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void scrollListBy(int y) {
        super.scrollListBy(y);
    }

    @Override
    public void scrollBy(@Px int x, @Px int y) {
        super.scrollBy(x, y);
    }

    @Override
    public void scrollTo(@Px int x, @Px int y) {
        super.scrollTo(x, y);
    }
}

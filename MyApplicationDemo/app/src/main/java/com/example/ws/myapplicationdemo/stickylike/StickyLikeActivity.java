package com.example.ws.myapplicationdemo.stickylike;

import android.app.Activity;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ws.myapplicationdemo.MainActivity;
import com.example.ws.myapplicationdemo.R;
import com.example.ws.myapplicationdemo.eventstudy.ActivityForTouchEvent;

/**
 * Created by ws on 18-1-23.
 */

public class StickyLikeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sticky_like_layout);
        ListView listView = (ListView) findViewById(R.id.list_id);
        listView.setAdapter(new ListAdapter() {
            @Override
            public boolean areAllItemsEnabled() {
                return false;
            }

            @Override
            public boolean isEnabled(int i) {
                return true;
            }

            @Override
            public void registerDataSetObserver(DataSetObserver dataSetObserver) {

            }

            @Override
            public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

            }

            @Override
            public int getCount() {
                return 20;
            }

            @Override
            public Object getItem(int i) {
                return i;
            }

            @Override
            public long getItemId(int i) {
                return 1;
            }

            @Override
            public boolean hasStableIds() {
                return false;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                TextView textView = new TextView(StickyLikeActivity.this);
                if (i < 5) {
                    textView.setText("hello world  " + i);
                } else {
                    textView.setText("text " + i);
                }

                return textView;
            }

            @Override
            public int getItemViewType(int i) {
                return 0;
            }

            @Override
            public int getViewTypeCount() {
                return 1;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }
        });

        final ImageView imgView = (ImageView) findViewById(R.id.top_id);
        imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StickyLikeActivity.this, ActivityForTouchEvent.class));
            }
        });

        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount,
                    int totalItemCount) {
                if (firstVisibleItem >= 4 && view.getChildAt(0) != null) {
                    View firstView = view.getChildAt(0);
                    int tralateY = -((firstVisibleItem - 4) * firstView.getMeasuredHeight())
                            + firstView.getTop();
                    imgView.setTranslationY(tralateY);
                } else {
                    imgView.setTranslationY(0);
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        super.onStop();
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
    protected void onPause() {
        super.onPause();
    }
}

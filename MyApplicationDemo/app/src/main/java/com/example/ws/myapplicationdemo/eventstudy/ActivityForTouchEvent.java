package com.example.ws.myapplicationdemo.eventstudy;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.ws.myapplicationdemo.R;

/**
 * Created by ws on 18-2-2.
 */

public class ActivityForTouchEvent extends Activity {
    private String TAG = "ActivityFor_TouchEvent";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_study_layout);
        TextView textView1 = (TextView) findViewById(R.id.text_id1);
//        textView1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d(TAG, "onClick text1");
//            }
//        });

        TextView textView2 = (TextView) findViewById(R.id.text_id2);
//        textView2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d(TAG, "onClick text2");
//            }
//        });

        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relative_id);
//        relativeLayout.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                Log.d(TAG, "onTouch " + event);
//                if (event.getAction() == MotionEvent.ACTION_MOVE) {
//                    return true;
//                }
//                return false;
//            }
//        });

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

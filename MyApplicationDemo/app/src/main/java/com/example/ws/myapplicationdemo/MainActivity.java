package com.example.ws.myapplicationdemo;

import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ws.myapplicationdemo.stickylike.StickyLikeActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = "Main_Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sticky_like_btn:
                startActivity(new Intent(this, StickyLikeActivity.class));
                break;
            default:
                break;
        }

    }
}

package com.example.ws.myapplicationdemo.service;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ws.myapplicationdemo.R;

/**
 * Created by ws on 18-3-2.
 */

public class ServiceBindActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.service_layout);
        Button startService = (Button) findViewById(R.id.start_service);
        startService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(ServiceBindActivity.this, DemoService.class));
            }
        });

        Button stopService = (Button) findViewById(R.id.stop_serice);
        stopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(ServiceBindActivity.this, DemoService.class));
            }
        });

        final ServiceConnection serviceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {

            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };

        Button bindService = (Button) findViewById(R.id.bind_serice);
        bindService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindService(new Intent(ServiceBindActivity.this, DemoService.class), serviceConnection,
                        Context.BIND_ABOVE_CLIENT);
            }
        });

        Button unbindService = (Button) findViewById(R.id.unbind_serice);
        unbindService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unbindService(serviceConnection);
            }
        });
        super.onCreate(savedInstanceState);
    }

}

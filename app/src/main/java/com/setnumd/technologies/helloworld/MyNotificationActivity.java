package com.setnumd.technologies.helloworld;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MyNotificationActivity extends AppCompatActivity {

    private TextView textViewTitle, textViewMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        Toolbar toolbar = findViewById(R.id.toolBar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        textViewTitle = findViewById(R.id.textViewTitle);
        textViewMessage = findViewById(R.id.textViewMessage);


       // LocalBroadcastManager.getInstance(this).registerReceiver(mHandler, new IntentFilter("com.setnumd.technologies.helloworld"));

        if (getIntent().getExtras() != null) {
            for (String keys : getIntent().getExtras().keySet()) {
                if (keys.equals("title")) {
                    textViewTitle.setText(getIntent().getExtras().getString(keys));
                } else if (keys.equals("message")) {
                    textViewMessage.setText(getIntent().getExtras().getString(keys));
                }
            }

        }

    }

    public void ClckMe(View view) {
        startActivity(new Intent(MyNotificationActivity.this, MyNotificationActivity.class));
    }

    private BroadcastReceiver mHandler = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String title = intent.getStringExtra("title");
            String message = intent.getStringExtra("message");
            textViewTitle.setText(title);
            textViewMessage.setText(message);

        }
    };


    @Override
    protected void onPause() {
        super.onPause();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mHandler);
    }
}
package com.setnumd.technologies.helloworld;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textViewTitle,textViewMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewTitle = findViewById(R.id.textViewTitle);
        textViewMessage = findViewById(R.id.textViewMessage);
//        LocalBroadcastManager.getInstance(this).registerReceiver(mHandler,new IntentFilter("com.setnumd.technologies.helloworld"));
//
//        if (getIntent().getExtras() != null){
//            for (String keys : getIntent().getExtras().keySet()){
//                if (keys.equals("title")){
//                    textViewTitle.setText(getIntent().getExtras().getString(keys));
//                }
//                else if (keys.equals("message")){
//                    textViewMessage.setText(getIntent().getExtras().getString(keys));
//                }
//            }
//
//        }

    }

    public void ClckMe(View view) {
        startActivity(new Intent(MainActivity.this, MyNotificationActivity.class));
    }

//    private BroadcastReceiver  mHandler = new BroadcastReceiver() {
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            String title = intent.getStringExtra("title");
//            String message = intent.getStringExtra("message");
//            textViewTitle.setText(title);
//            textViewMessage.setText(message);
//
//        }
//    };

//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        LocalBroadcastManager.getInstance(this).unregisterReceiver(mHandler);
//    }
}

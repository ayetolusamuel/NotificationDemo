package com.setnumd.technologies.helloworld;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;


public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = MyFirebaseMessagingService.class.getSimpleName();
    private static final String CHANNEL_ID = "CHANNEL_ID";
    private static final int NOTIFICATION_ID = 123;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        Log.d(TAG, "From: " + remoteMessage.getFrom());



        if (remoteMessage.getNotification() != null) {
            sendNotification(remoteMessage.getNotification().getTitle(),remoteMessage.getNotification().getBody());
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());

            String title = remoteMessage.getData().get("title");
            String message = remoteMessage.getData().get("message");
            System.out.println("From "+remoteMessage.getFrom());
            System.out.println("Title "+title);
            System.out.println("Message "+message);
            System.out.println("Time "+remoteMessage.getSentTime());
            Intent intent = new Intent(this,MyNotificationActivity.class);
            intent.putExtra("title",title);
            intent.putExtra("message",message);
           // LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this);
           // localBroadcastManager.sendBroadcast(intent);




        }
    }

    private void sendNotification(String title,String body) {
  Intent resultIntent = new Intent(getApplicationContext(), MyNotificationActivity.class);
        resultIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_CLEAR_TASK);

 TaskStackBuilder stackBuilder = TaskStackBuilder.create(getApplicationContext());
        stackBuilder.addNextIntentWithParentStack(resultIntent);


  PendingIntent notifyPendingIntent = stackBuilder.getPendingIntent(123,PendingIntent.FLAG_UPDATE_CURRENT
        );

        
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID);
        builder.setContentText(body)
                .setContentTitle(title)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentIntent(notifyPendingIntent);




        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getApplicationContext());
        notificationManager.notify(NOTIFICATION_ID, builder.build());




    }

    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);
        System.out.println("Token" + s);
    }


//4uemd9dA8:APA91bENouZD4RS0BwIOvwUZVVnZSE4q-qeDjsyVxVG4JFZsZvvLIsASOQPnyE2j5RhaV91jVbSlvgmoQDuinZbWRvY5jEcQkRsh3JzZZ5_bBffH8EuDnMfbYTe2KfnihkBikcs6ANSU
}
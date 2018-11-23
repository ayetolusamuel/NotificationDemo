package com.setnumd.technologies.helloworld;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;


public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = MyFirebaseMessagingService.class.getSimpleName();

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        Log.d(TAG, "From: " + remoteMessage.getFrom());

        if (remoteMessage.getNotification() != null) {
            sendNotification(remoteMessage.getNotification().getBody());
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
        }
    }

    private void sendNotification(String body) {

        Notification.Builder mBuilder =
                new Notification.Builder(this)
                        .setSmallIcon(R.drawable.ic_launcher_background)
                        .setContentTitle(getString(R.string.notification))
                        .setContentText(body);

        Intent resultIntent = new Intent(this,

                MyNotificationActivity.class);
        resultIntent.setAction(Intent.ACTION_MAIN);
        resultIntent.addCategory(Intent.CATEGORY_LAUNCHER);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
                resultIntent, 0);

        mBuilder.setContentIntent(pendingIntent);
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mNotificationManager.notify(1, mBuilder.build());
        }

    }

    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);
        System.out.println("Token" + s);
    }



}
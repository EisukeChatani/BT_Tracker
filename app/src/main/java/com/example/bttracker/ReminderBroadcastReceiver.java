package com.example.bttracker;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import android.util.Log;
public class ReminderBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String TAG = "onReceive";
        Intent notificationIntent = new Intent(context, LogActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0,
                notificationIntent, 0);
        Log.d(TAG, "start building notification");
        NotificationCompat.Builder builder = new
                NotificationCompat.Builder(context,"BTTrackerChannel")
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentTitle("Notification from BT Tracker")
                .setContentText("Please log your body temperature now")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true)
                .setContentIntent(contentIntent);
        Log.d(TAG, "finish building notification");
        NotificationManagerCompat notificationManager =
                NotificationManagerCompat.from(context);
        Log.d(TAG, "start firing notification");
        notificationManager.notify(200, builder.build());
        Log.d(TAG, "notification fired");
    }
}
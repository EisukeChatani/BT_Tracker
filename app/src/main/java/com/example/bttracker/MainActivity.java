package com.example.bttracker;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createNotificationChannel();
    }

    public void goToLogActivity(View view) {
        Intent toLog = new Intent(this,LogActivity.class);
        startActivity(toLog);
    }

    public void goToNormalActivity(View view) {
        Intent toNormal = new Intent(this, NormalActivity.class);
        startActivity(toNormal);
    }

    public void goToMechanismActivity(View view) {
        Intent toMechanism = new Intent( this, MechanismActivity.class);
        startActivity(toMechanism);
    }

    public void openHandlingFeverWebsite(View view) {
        Intent tolink = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.healthline.com/health/how-to-break-a-fever"));

        startActivity(tolink);
    }

    @SuppressLint("ShortAlarm")
    public void setReminder(View view) {
            Toast.makeText(this, "Reminder set!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, ReminderBroadcastReceiver.class);
            PendingIntent pd = PendingIntent.getBroadcast(this, 0, intent, 0);
            AlarmManager alarmManager=
                    (AlarmManager)getSystemService(ALARM_SERVICE);
        assert alarmManager != null;
        long interval = 1000 * 6;
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                    System.currentTimeMillis(), interval, pd);
        }
    private void createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            String channelID = "BT_Tracker_Channel";
            String channelName = "BTTrackerReminderChannel";
            String channelDescription = "Channel for BT Tracker reminder";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(channelID,
                    channelName, importance);
            channel.setDescription(channelDescription);
            NotificationManager notificationManager =
                    getSystemService(NotificationManager.class);
            assert notificationManager != null;
            notificationManager.createNotificationChannel(channel);
        }
    }
}


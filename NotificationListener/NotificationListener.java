package com.example.minh.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.support.annotation.RequiresApi;
import android.util.Log;

@SuppressLint("OverrideAbstract")
public class NotificationListener extends NotificationListenerService {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("TAGG", "start");
        return super.onStartCommand(intent, flags, startId);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        String title = sbn.getNotification().extras.getString("android.title");
        String text = sbn.getNotification().extras.getString("android.text");
        String package_name = sbn.getPackageName();
        Log.d("TAGG", "Notification title is:" + title);
        Log.d("TAGG", "Notification text is:" + text);
        Log.d("TAGG", "Notification Package Name is:" + package_name);
        super.onNotificationPosted(sbn);
        Log.d("TAGG", "noti");
    }

    @Override
    public void onListenerConnected() {
        super.onListenerConnected();
        Log.d("TAGG", "connect");
    }
}
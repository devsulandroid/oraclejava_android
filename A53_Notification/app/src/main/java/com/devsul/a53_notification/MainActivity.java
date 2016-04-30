package com.devsul.a53_notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBtnClick(View v){
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("TITLE");
        builder.setContentText("TEXT");
        builder.setSubText("SubTEXT");
        builder.setSmallIcon(R.mipmap.ic_launcher);

        Notification notification = builder.build();
        notificationManager.notify(1234, notification);
    }
}

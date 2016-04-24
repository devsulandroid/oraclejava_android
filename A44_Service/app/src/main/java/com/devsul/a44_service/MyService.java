package com.devsul.a44_service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.Random;

public class MyService extends Service {
    MyBinder myBinder = new MyBinder();

    public MyService() {

    }

    public class MyBinder extends Binder{
        public MyService getService() {
            return MyService.this;
        }
    }

    //serviceConnection onServiceConnected 의 IBinder 로 넘어간다
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        //throw new UnsupportedOperationException("Not yet implemented");
        return myBinder;
    }

    private Random random = new Random();

    public int getRandom(){
        return random.nextInt(100);
    }





    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}

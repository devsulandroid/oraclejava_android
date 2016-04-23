package com.devsul.a09_thread;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                // Thread 동작
                for (int i=0; i<100; i++){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        throw new RuntimeException("에러");
                    }
                    Log.d("thread","count : " + i);
                }
            }
        });
        th.start();


    }
}

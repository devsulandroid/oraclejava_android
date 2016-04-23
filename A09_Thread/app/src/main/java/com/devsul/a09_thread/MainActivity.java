package com.devsul.a09_thread;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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
                    Thread.sleep(100);
                }
            }
        });
        th.start();


    }
}

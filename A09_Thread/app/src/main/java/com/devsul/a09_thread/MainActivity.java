package com.devsul.a09_thread;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private static final int Log_COUNT = 1;
    TextView textView;
    ProgressBar pgBar;

    class MyThread extends Thread{
        @Override
        public void run() {
            for (int i=0; i<100; i++){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    throw new RuntimeException("에러");
                }

                //Handler 이용
                Message msg = new Message();
                msg.what = Log_COUNT;
                msg.arg1 = i;
                handler.sendMessage(msg);
            }
        }
    };

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            if(msg.what == Log_COUNT){
                textView.setText("count : " + msg.arg1);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pgBar = (ProgressBar)findViewById(R.id.pgBar) ;
        textView = (TextView)findViewById(R.id.textView) ;

        /**
        Runnable r = new Runnable() {
            @Override
            public void run() {

            }
        };
         **/

        // Thread
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
                    //Thread는 UI에 직업 접근 할 수 없다
                    //Handler를 통해 처리를 진행한다
                    //-> 불가능 textView.setText("Count : " + i);


                    //Handler 이용
                    Message msg = new Message();
                    msg.what = Log_COUNT;
                    msg.arg1 = i;
                    handler.sendMessage(msg);
                }
            }
        });

        // Thread 실행
        //th.start();

        MyThread th2 = new MyThread();
        th2.start();


    }
}

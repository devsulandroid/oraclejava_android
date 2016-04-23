package com.devsul.a10_asyctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    // Thread + Handler
    class MyTask extends AsyncTask<Integer, Float, String>{

        @Override
        protected void onProgressUpdate(Float... values) {
            super.onProgressUpdate(values);
        }

        //Thread에 해당
        @Override
        protected String doInBackground(Integer... params) {
            int max = params[0];
            //int a = params[1];
            //int b = params[2];
            for (int i=0 ; i < max ; i++){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.d("async", "count:"+i);

                // 직접 접근할 수 없다
                //textView.setText("Cont : " + i );

                publishProgress((float)i);
            }
            return null;

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView);

        MyTask mytask = new MyTask();
        mytask.execute(100, 200, 300);
    }
}

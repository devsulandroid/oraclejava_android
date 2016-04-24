package com.devsul.a42_brcast2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            Toast.makeText(context, "action : " + action, Toast.LENGTH_LONG).show();
            if(action.equals(intent.ACTION_BATTERY_CHANGED)) {
                int level = intent.getIntExtra("level", 0);
                Toast.makeText(context, "batt : " + level, Toast.LENGTH_LONG).show();
            }else if(action.equals(intent.ACTION_BATTERY_LOW)){
                Toast.makeText(context, "batt LOW!!!! ", Toast.LENGTH_LONG).show();
            }else if(action.equals("btnAction")){
                Toast.makeText(context, "btnAction", Toast.LENGTH_LONG).show();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        IntentFilter filter = new IntentFilter();


        //여러 이벤트를 받을때
        filter.addAction(Intent.ACTION_BATTERY_CHANGED);
        filter.addAction(Intent.ACTION_BATTERY_LOW);
        filter.addAction("btnAction");
        registerReceiver(receiver, filter);

    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(receiver);
    }

    public void onMybtnClick(View v){
        Intent intent = new Intent("btnAction");
        sendBroadcast(intent);
    }
}

package com.devsul.a08_customlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    class MyData{
        String title;
        String desc;
        int icon;

        public MyData(String title, String desc, int icon) {
            this.title = title;
            this.desc = desc;
            this.icon = icon;
        }
    }

    ArrayList<MyData> list = new ArrayList<MyData>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int icon = 0;
        for(int i = 0 ; i < 30 ; i++){
            switch(i%4){
                case 0: icon = android.R.drawable.ic_dialog_email;
                    break;
                case 1: icon = android.R.drawable.ic_lock_idle_alarm;
                    break;
                case 2: icon = android.R.drawable.ic_btn_speak_now;
                    break;
                case 3: icon = android.R.drawable.ic_lock_power_off;
                    break;
            }

            MyData data = new MyData("data"+i, "desc"+i , icon);
            list.add(data);
        }

    }
}

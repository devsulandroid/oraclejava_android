package com.devsul.a08_media01;

import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

     MediaPlayer mp = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPLay = (Button)findViewById(R.id.btnPlay);
        Button btnStop = (Button)findViewById(R.id.btnStop);


        //Click Start
        btnPLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String path = Environment.getExternalStorageDirectory()+"/Download/TWICE.mp3";

                //미디어 플레이어 준비
                mp = new MediaPlayer();
                try {
                    mp.setDataSource(path);
                    mp.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        //Click Stop
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}

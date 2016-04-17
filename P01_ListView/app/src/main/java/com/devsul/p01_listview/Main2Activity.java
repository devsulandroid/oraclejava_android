package com.devsul.p01_listview;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class Main2Activity extends AppCompatActivity {
    MediaPlayer mp = null;
    String musicPath = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        musicPath = intent.getStringExtra("path")+"/"+intent.getStringExtra("fileName");
        //Toast.makeText(Main2Activity.this, musicPath, Toast.LENGTH_LONG).show();

        TextView txtView = (TextView)findViewById(R.id.txtTitle);
        txtView.setText("현재 재생 하고 있는 파일 : "+intent.getStringExtra("fileName"));

        Button btnPlay = (Button)findViewById(R.id.btnPlay);
        Button btnStop = (Button)findViewById(R.id.btnStop);


        // PLAY 버튼
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 미디어 플레이어
                mp = new MediaPlayer();
                try {
                    mp.setDataSource(musicPath);
                    //버퍼링 해서 준비해주는 부분
                    mp.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mp.start();
            }
        });


        // STOP 버튼
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mp != null){
                    mp.stop();
                    // 내부, 메모리 있는 데이터 삭제
                    mp.release();
                    mp = null;
                }
            }
        });



    }
}

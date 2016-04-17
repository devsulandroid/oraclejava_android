package com.devsul.a05_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();

        String getIdData = intent.getStringExtra("myId");

        Toast.makeText(Main2Activity.this, "get id data : " + getIdData, Toast.LENGTH_LONG).show();

    }
}

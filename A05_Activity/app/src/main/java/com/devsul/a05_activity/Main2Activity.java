package com.devsul.a05_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();

        String getIdData = intent.getStringExtra("myId");

        Toast.makeText(Main2Activity.this, "get id data : " + getIdData, Toast.LENGTH_LONG).show();


        Button btn02 = (Button)findViewById(R.id.btn02);

        btn02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent01 = new Intent();
//                intent01.putExtra("myResult","Main 2 Result");
//                setResult(RESULT_OK, intent01);
//
//                // 자기 자신 종료
//                finish();
            }
        });
    }

    //back key 눌렀을때
    @Override
    public void onBackPressed() {
        Intent intent01 = new Intent();
        intent01.putExtra("myResult","Main 2 Result");
        setResult(RESULT_OK, intent01);

        super.onBackPressed();
    }
}

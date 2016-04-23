package com.devsul.a12_sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 디비가 생성 되어 있으면 디비 생성을 하지 않는다.
        // TESTSQLiteOpenHelper helper = new TESTSQLiteOpenHelper(this, "people", null, 1);
    }
}

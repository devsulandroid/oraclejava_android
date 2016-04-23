package com.devsul.a12_sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView)findViewById(R.id.textView);
        // 디비가 생성 되어 있으면 디비 생성을 하지 않는다.
        // TESTSQLiteOpenHelper helper = new TESTSQLiteOpenHelper(this, "people", null, 1);

        TESTSQLiteHandler dbHander = new TESTSQLiteHandler(this);
        dbHander.insert("DEVSUL1", 20, "서울");
        dbHander.insert("설의석", 30, "경기");

        dbHander.update("DEVSUL", 40);

        String res = dbHander.selectAll();

        textView.setText(res);



    }
}

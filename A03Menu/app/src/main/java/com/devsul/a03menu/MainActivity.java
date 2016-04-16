package com.devsul.a03menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // 옵션 메뉴 만들기 (옵션 메뉴가 생성 될때)
    // 1. xml 생성 menu_main.xml
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    // 옵션 메뉴를 선택 했을때
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //return super.onOptionsItemSelected(item);
        if(item.getItemId() == R.id.menu01){
            Toast.makeText(this, "SELECTED", Toast.LENGTH_LONG).show();
        }

        return true;
    }
}

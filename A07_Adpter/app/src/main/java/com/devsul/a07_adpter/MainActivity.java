package com.devsul.a07_adpter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String [] list = {"data 01", "data 02",
                      "data 03", "data 04",
                      "data 05", "data 06",
                      "data 07", "data 08",
                      "data 09", "data 10",
                      "data 11", "data 12"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView)findViewById(R.id.listView01);

        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, list);

        // 데이터 + 어엡터 + 리스트 뷰 연결
        listView.setAdapter(adapter);

        // 리스트의 아이템이 눌렸을때 진행되는 이벤트
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
}

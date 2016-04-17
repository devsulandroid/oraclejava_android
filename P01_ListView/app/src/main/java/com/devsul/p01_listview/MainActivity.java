package com.devsul.p01_listview;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1. 특정 폴더내 객체 읽어 오기
        String path = Environment.getExternalStorageDirectory()+"/Download";
        //Toast.makeText(MainActivity.this, path, Toast.LENGTH_LONG).show();
        File dir = new File(path);
        File[] files = dir.listFiles();

        //Toast.makeText(MainActivity.this, files[0].getName(), Toast.LENGTH_LONG).show();

        //2. 읽어온 데이터 배열 생성
        ArrayList<String> list = new ArrayList<String>();

        //Toast.makeText(MainActivity.this, files.length+"", Toast.LENGTH_LONG).show();
        for(int i=0; i<files.length; i++){
            //파일데이터만 추가
            if(files[i].isFile()) {
                if(files[i].getName().lastIndexOf(".mp3") > -1) {
                    list.add(files[i].getName());
                }
            }
        }

        String[] strArrays = list.toArray(new String[list.size()]);

        //3. 리스트 뷰 생성
        ListView listView = (ListView)findViewById(R.id.listView);

        //4. activity 표현을 위한 adapter 생성
        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, strArrays);

        //5. 데이터 + 어엡터 + 리스트 뷰 연결
        listView.setAdapter(adapter);
    }
}

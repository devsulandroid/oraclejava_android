package com.devsul.a14_json;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {


    String str = "[{'name':'user_A', 'age':10, 'tel':'010-0001-0101'},"+
                 "{'name':'user_B', 'age':20, 'tel':'020-0002-0202'},"+
                 "{'name':'user_B', 'age':30, 'tel':'030-0003-0303'}]";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView)findViewById(R.id.textView);
        String res = "";
        try {
            //JSONArray 읽기
            JSONArray array = new JSONArray(str);

            for(int i=0; i < array.length() ; i++){
                JSONObject object = array.getJSONObject(i);
                String name = object.getString("name");
                Integer age = object.getInt("age");
                String tel = object.getString("tel");

                res += "name : " + name + ", age : " + age + ", tel : " + tel + "\n";

                textView.setText(res);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

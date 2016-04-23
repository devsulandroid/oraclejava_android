package com.devsul.a11_sharedpreference;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 있으면 가져오고 없으면 Default 값을 사용
        SharedPreferences pref = getSharedPreferences("mySettings", MODE_PRIVATE);
        String name = pref.getString("name", "default");

        Toast.makeText(this, name, Toast.LENGTH_LONG).show();
    }

    //어플리케이션이 화면에서 모두 가려졌을때 (종료)
    @Override
    protected void onStop() {
        super.onStop();


        SharedPreferences pref = getSharedPreferences("mySettings", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        EditText editText = (EditText)findViewById(R.id.editText);
        String value = editText.getText().toString();

        editor.putString("name", value);
        /**
         *  여러개를 추가 할 수 있다.
         */

        editor.commit();
    }
}

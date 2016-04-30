package com.devsul.a52_fragment_2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBtnClick(View v){
        FragmentManager fm = getSupportFragmentManager();
        Fragment fr = null;

        switch (v.getId()){
            case R.id.btnAdd:
                if(fr == null){
                    fr = new BlankFragment();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.add(R.id.frame, fr, "counter");
                    ft.commit();
                }
                break;
            case R.id.btnRemove:
                break;
            case R.id.btnReplace:
                break;
            case R.id.btnHide:
                break;
        }
    }
}

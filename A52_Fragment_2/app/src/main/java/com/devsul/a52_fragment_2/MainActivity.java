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
        Fragment fr = fm.findFragmentById(R.id.frame);

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
                if(fr != null){
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.remove(fr);
                    ft.commit();
                }
                break;
            case R.id.btnReplace:
                if(fr != null){
                    FragmentTransaction ft = fm.beginTransaction();
                    if(fr.getTag().equals("counter")){
                        BlankFragment2 fr2 = new BlankFragment2();
                        ft.replace(R.id.frame, fr2, "text");
                    }else{
                        BlankFragment fr1 = new BlankFragment();
                        ft.replace(R.id.frame, fr1, "counter");
                    }

                    ft.commit();
                }
                break;
            case R.id.btnHide:
                if(fr != null){
                    FragmentTransaction ft = fm.beginTransaction();
                    if(fr.isHidden()){
                        ft.show(fr);
                    }else{
                        ft.hide(fr);
                    }
                    ft.commit();
                }
                break;
        }
    }
}

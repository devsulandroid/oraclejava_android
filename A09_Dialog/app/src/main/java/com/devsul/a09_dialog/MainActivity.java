package com.devsul.a09_dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int myId = 0;
    public void onShowDialog(View v){
        showDialog(myId);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if(id==myId){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Title");
            builder.setMessage("Message");
            builder.setCancelable(false);

            // 버튼 하나가 생성됨
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_LONG).show();
                }
            });

            // 아래를 추가하면 버튼 2개 짜리가 됨
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_LONG).show();
                }
            });

            return builder.create();

        }

        return null;
    }
}

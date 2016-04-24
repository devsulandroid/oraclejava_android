package com.devsul.a45_style;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView outTextView, inTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        outTextView = (TextView)findViewById(R.id.outTextView);
        inTextView = (TextView)findViewById(R.id.inTextView);

        View.OnClickListener numberListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button)v;
                String val = btn.getText().toString();
                String inText = inTextView.getText().toString();
                String outText = outTextView.getText().toString();

                if(inText.equals("0")){
                    inTextView.setText(val);
                }else{
                    inTextView.setText(outText + val);
                }
            }
        };

        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);
        btn1.setOnClickListener(numberListener);
        btn2.setOnClickListener(numberListener);
    }
}

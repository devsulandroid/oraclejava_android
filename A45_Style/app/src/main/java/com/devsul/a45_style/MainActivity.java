package com.devsul.a45_style;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView outTextView, inTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        outTextView = (TextView)findViewById(R.id.outTextView);
        inTextView = (TextView)findViewById(R.id.inTextView);

        final View.OnClickListener numberListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button)v;
                String val = btn.getText().toString();
                String inText = inTextView.getText().toString();


                if(inText.equals("0")){
                    inTextView.setText(val);
                }else{
                    inTextView.setText(inText + val);
                }
            }
        };

        TableLayout tableLayout = (TableLayout) findViewById(R.id.tblLayout);

        int number = 1;
        for(int i=2 ; i<tableLayout.getChildCount() -1 ; i++){
            TableRow row = (TableRow) tableLayout.getChildAt(i);

            for(int k=0 ; k < row.getChildCount() ; k++){
                Button btn = (Button) row.getChildAt(k);
                btn.setText(""+number);
                btn.setOnClickListener(numberListener);
                number++;
            }
        }

        TableRow bottomTblRow = (TableRow) tableLayout.getChildAt(tableLayout.getChildCount()-1);
        Button deleteBtn = (Button) bottomTblRow.getChildAt(0);
        deleteBtn.setText("Delete");
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inTextView.setText("0");
            }
        });


        Button btn0 = (Button) bottomTblRow.getChildAt(1);
        btn0.setText("0");
        btn0.setOnClickListener(numberListener);


        Button EnterBtn = (Button) bottomTblRow.getChildAt(2);
        EnterBtn.setText("Enter");
        EnterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inTextVal = inTextView.getText().toString();
                if(inTextVal.length() > 0){
                    outTextView.setText(inTextVal);
                    inTextView.setText("0");
                }
            }
        });

//        Button btn3 = (Button) findViewById(R.id.btn3);
//        btn3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String inTextVal = inTextView.getText().toString();
//                if(inTextVal.length() > 0){
//                    outTextView.setText(inTextVal);
//                    inTextView.setText("0");
//                }
//            }
//        });
    }
}

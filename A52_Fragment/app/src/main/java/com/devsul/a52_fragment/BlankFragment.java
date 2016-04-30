package com.devsul.a52_fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {


    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_blank, container, false);


        final TextView textViewCounter = (TextView) view.findViewById(R.id.textViewCounter);
        Button btnIncrease = (Button)view.findViewById(R.id.btnIncrease);

        btnIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //버튼클릭 이벤트
                String str = textViewCounter.getText().toString();
                int value = Integer.parseInt(str);
                value++;
                textViewCounter.setText(""+value);
            }
        });

        return view;
    }

}

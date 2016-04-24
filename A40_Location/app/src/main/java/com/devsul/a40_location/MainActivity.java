package com.devsul.a40_location;

import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 안드로이드 서비스를 사용할때 getSystemService 통해서 가져옴
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        TextView textView = (TextView)findViewById(R.id.textView);

        List <String> providers = locationManager.getAllProviders();

        //textView.setText(providers.toString());
        String str = "";
        for(int i=0 ; i<providers.size();i++){
            str += "provider : " + providers.get(i) + ", state : " + locationManager.isProviderEnabled(providers.get(i)) + "\n";
        }

        textView.setText(str);
    }
}

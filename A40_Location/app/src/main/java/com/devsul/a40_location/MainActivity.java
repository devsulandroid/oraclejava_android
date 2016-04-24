package com.devsul.a40_location;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Geocoder geocoder = new Geocoder(this, Locale.KOREA);

        // 안드로이드 서비스를 사용할때 getSystemService 통해서 가져옴
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        final TextView textView = (TextView) findViewById(R.id.textView);
        // providers 네트웍정보를 제공하는것
        List<String> providers = locationManager.getAllProviders();

        //textView.setText(providers.toString());
        String str = "";
        for (int i = 0; i < providers.size(); i++) {
            str += "provider : " + providers.get(i) + ", state : " + locationManager.isProviderEnabled(providers.get(i)) + "\n";
        }




        textView.setText(str);

        // 위치 정보 얻기
        LocationListener locationListener = new LocationListener() {
            //위치가 변경 되었을때
            @Override
            public void onLocationChanged(Location location) {
                String str = "lat : " + location.getLatitude() + " lon : " + location.getLongitude()
                        + " alt : " + location.getAltitude() + "\n";
                try {
                    List<Address> list = geocoder.getFromLocation(location.getLatitude(),location.getLongitude(), 1);

                    //str += location.getLatitude()+"/"+location.getLongitude();
                    Address address = list.get(0);
                    str += "address size : " + list.size() + "\n";
                    str += "address : " + address.toString()+ "\n";
                } catch (Exception e) {
                    e.printStackTrace();
                }


                textView.append(str);

            }


            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }


            @Override
            public void onProviderEnabled(String provider) {

            }


            @Override
            public void onProviderDisabled(String provider) {

            }
        };

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
        //locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
    }
}

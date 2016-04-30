package com.devsul.a51_floatwindow;

import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;

public class FloatingService extends Service {
    public FloatingService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    WindowManager wm;

    LinearLayout ll;


    @Override
    public void onCreate() {
        super.onCreate();

        wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        ll = new LinearLayout(this);

        LinearLayout.LayoutParams llParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT

        );

        ll.setBackgroundColor(Color.argb(55,255,0,0));
        ll.setLayoutParams(llParams);


        WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                400,160,
                WindowManager.LayoutParams.TYPE_PHONE,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT
        );

        params.x = 0;
        params.y = 0;

        params.gravity = Gravity.CENTER | Gravity.CENTER;

        wm.addView(ll, params);




    }
}

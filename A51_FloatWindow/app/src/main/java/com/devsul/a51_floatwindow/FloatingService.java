package com.devsul.a51_floatwindow;

import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
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
    WindowManager.LayoutParams params;
    LinearLayout ll;


    @Override
    public void onCreate() {
        super.onCreate();

        wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        ll = new LinearLayout(this);
        Button btnStop;

        LinearLayout.LayoutParams llParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT

        );

        ll.setBackgroundColor(Color.argb(55,255,0,0));
        ll.setLayoutParams(llParams);
        ll.setOnTouchListener(new View.OnTouchListener() {
            WindowManager.LayoutParams updateParams = params;

            int x,y;
            float touchedX, touchedY;
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        x = updateParams.x;
                        y = updateParams.y;

                        touchedX = event.getRawX();
                        touchedY = event.getRawY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        updateParams.x = x + (int)(event.getRawX() - touchedX);
                        updateParams.y = y + (int)(event.getRawY() - touchedY);
                        wm.updateViewLayout(ll, updateParams);
                        break;
                }
                return false;
            }
        });

        btnStop = new Button(this);
        ViewGroup.LayoutParams btnParams = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT

        );

        btnStop.setLayoutParams(btnParams);
        btnStop.setText("stop");

        ll.addView(btnStop);
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //화면 종료
                wm.removeView(ll);
                //서비스 종료
                stopSelf();
            }
        });

       params = new WindowManager.LayoutParams(
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

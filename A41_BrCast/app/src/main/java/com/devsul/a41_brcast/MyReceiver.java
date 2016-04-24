package com.devsul.a41_brcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {
    }

    // 문자 정보가 intent 통해 넘어온다
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        //throw new UnsupportedOperationException("Not yet implemented");

        SmsMessage[] smsMessages = null;
        Object[] objects = (Object[]) intent.getExtras().get("pdus");
        smsMessages = new SmsMessage[objects.length];

        String str = "";
        for(int i=0 ; i < smsMessages.length ; i++){
            smsMessages[i] = SmsMessage.createFromPdu((byte[])objects[i]) ;

            str += "SMS from : " + smsMessages[i].getOriginatingAddress();
            str += " :  + " + smsMessages[i].getMessageBody() + "\n";

        }

        Toast.makeText(context, str, Toast.LENGTH_LONG).show();

    }
}

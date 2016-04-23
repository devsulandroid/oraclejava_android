package com.devsul.a13_xml_parser1;

import android.os.AsyncTask;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.net.URL;

/**
 * Created by c on 2016-04-23.
 */
public class MyPullParser extends AsyncTask<String, Void, String> {

    TextView textView;

    public MyPullParser(TextView textView) {
        this.textView = textView;
    }

    @Override
    protected String doInBackground(String... params) {
        String res = "";
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser xpp = factory.newPullParser();

            xpp.setInput(new URL(params[0]).openStream() ,"utf-8");

            // 한줄씩 읽어 내려간다 ( pullparser)
            int eventType = xpp.getEventType();
            boolean bRead = false;

            while (eventType != XmlPullParser.END_DOCUMENT){
                switch (eventType){
                    case XmlPullParser.START_TAG:
                        String tag = xpp.getName();
                        if(tag.equals("hour") || tag.equals("day") || tag.equals("temp") || tag.equals("wfkor")){
                            bRead = true;
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        break;
                    case XmlPullParser.TEXT:
                        if(bRead){
                            res += xpp.getText() + " ";
                            bRead = false;
                        }
                        break;

                }


                eventType = xpp.next();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


        return res;
    }
}

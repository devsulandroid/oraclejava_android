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

        } catch (Exception e) {
            e.printStackTrace();
        }


        return res;
    }
}

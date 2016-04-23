package com.devsul.a13_xml_parser1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView)findViewById(R.id.textView);

        //Parser
        //MyDomparser myDomparser = new MyDomparser(textView);
        //myDomparser.execute("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1174061000");

        //PullParser
        MyPullParser myDomPullparser = new MyPullParser(textView);
        myDomPullparser.execute("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1174061000");

    }
}

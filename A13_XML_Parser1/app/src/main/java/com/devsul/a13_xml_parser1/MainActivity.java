package com.devsul.a13_xml_parser1;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class MainActivity extends AppCompatActivity {

    // Thread를 통해 인터넷에서 데이터를 가져오도록 해야한다다
    // Thread + Handler
    // 시작할때 업데이트할때 종료시 사용되는 파라미터 정의가 중요하다
    //
   class MyDomparser extends AsyncTask<String, Void, Document>{

        //WORK Thread에 해당
        @Override
        protected Document doInBackground(String... params) {
            URL url = null;
            Document document = null;
            try {
                url = new URL(params[0]);
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = dbf.newDocumentBuilder();
                document = builder.parse(url.openStream());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return document;
        }

        // UI Thread에 해당
        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        //doInBackground return 값 받는 영역
        @Override
        protected void onPostExecute(Document document) {
            super.onPostExecute(document);

            String res = "";
            NodeList nodeList = document.getElementsByTagName("data");

        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyDomparser myDomparser = new MyDomparser();
        myDomparser.execute("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1174061000");

    }
}

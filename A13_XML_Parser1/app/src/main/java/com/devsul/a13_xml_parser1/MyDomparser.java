package com.devsul.a13_xml_parser1;

import android.os.AsyncTask;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 *  Created by c on 2016-04-23.
 *  Thread를 통해 인터넷에서 데이터를 가져오도록 해야한다다
 *  Thread + Handler
 *  시작할때 업데이트할때 종료시 사용되는 파라미터 정의가 중요하다
 */
public class MyDomparser extends AsyncTask<String, Void, Document> {
    TextView textView;

    public MyDomparser(TextView textView) {
        this.textView = textView;
    }

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
        for(int i=0; i < nodeList.getLength(); i++){
            Element element = (Element) nodeList.item(i);
            String day = getNodeValue(element, "day");
            String hour = getNodeValue(element, "hour");
            String temp = getNodeValue(element, "temp");
            String wfKor = getNodeValue(element, "wfKor");

            res += "day : " + day + ", hour : " + hour + ", temp : " + temp + ", wfKor : " + wfKor + "\n";
        }
        textView.setText(res);
    }

    // return Element Value
    protected String getNodeValue(Element element, String nodeName){
        NodeList dayNodeList =  element.getElementsByTagName(nodeName);
        Element dayElement = (Element) dayNodeList.item(0);
        NodeList textNodeList = dayElement.getChildNodes();
        return textNodeList.item(0).getNodeValue();
    }
}
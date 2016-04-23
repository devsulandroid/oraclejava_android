package com.devsul.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView)findViewById(R.id.webView);

        // 웹뷰 셋팅 얻어와서 자바스크립스 사용 가능하게 설정
        WebSettings ws = webView.getSettings();
        ws.setJavaScriptEnabled(true);

        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://www.naver.com");

        //버튼 클릭 이벤트
        Button btnOk = (Button)findViewById(R.id.btnOk);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //버튼 클릭 이벤트
                EditText editText = (EditText)findViewById(R.id.editText);
                String getUrl = editText.getText().toString();
                webView.loadUrl(getUrl);
            }
        });
    }

    // back key 이벤트
    @Override
    public void onBackPressed(){
        if(webView.canGoBack()){
            webView.goBack();
        }else{
            finish();
        }
    }
}

package com.deanna.dhimanmatrimonial;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class WebView extends AppCompatActivity {

    //Web View
    private android.webkit.WebView web_View;
    public ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        web_View= findViewById(R.id.webview);

        WebSettings wb = web_View.getSettings();
        wb.setJavaScriptEnabled(true);
        web_View.clearCache(true);
        web_View.clearHistory();
        web_View.getSettings().setJavaScriptEnabled(true);
        web_View.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);

        web_View.loadUrl("http://pushdroidz.com/");

        web_View.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(android.webkit.WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);

            }

            @Override
            public void onPageFinished(android.webkit.WebView view, String url) {
                super.onPageFinished(view, url);
//                progressBar.setVisibility(View.GONE);
            }
        });

        WebSettings webSettings =web_View.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }
    @Override
    public void onBackPressed() {
        if (web_View.canGoBack()) {
            web_View.goBack();
        } else {
            super.onBackPressed();
        }
    }
}

package com.anew.user.class3pmnov14;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class WebViewActivity extends AppCompatActivity {
    ProgressBar progressBar,hprogress;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        progressBar=(ProgressBar) findViewById(R.id.progress);
        webView=(WebView) findViewById(R.id.webview);
        hprogress=findViewById(R.id.progressBar);
        webView.loadUrl("https://www.youtube.com/");
        webView.getSettings().setJavaScriptEnabled(true);

        webView.setWebViewClient(new WebViewClient()
        {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar.setVisibility(View.GONE);
            }
        });
        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                hprogress.setProgress(newProgress);
            }
        });

    }
}

package com.example.webview1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.webview1.databinding.ActivityMainBinding;

import java.net.URISyntaxException;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    String url = "https://www.google.com.tw/xhtml";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.WebView1.loadUrl(url);
        WebSettings webSettings = binding.WebView1.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setLoadWithOverviewMode(true);

        binding.WebView1.setWebViewClient(new WebViewClient() {

            String currentUrl;

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                currentUrl = url;
                if (url.startsWith("http") || url.startsWith("https")) {
                    return false;
                }
                if (url.startsWith("internet")) {
                    try {
                        Intent intent = Intent.parseUri(url, Intent.URI_INTENT_SCHEME);

                        String fallbackUrl = intent.getStringExtra("browser_fallback_url");
                        if (fallbackUrl != null) {
                            binding.WebView1.loadUrl(fallbackUrl);
                            return true;
                        }
                    } catch (URISyntaxException e) {

                    }
                }
                return true;
            }

        });
    }

    public void onBackPressed(){
        super.onBackPressed();
        binding.WebView1.goBack();
    }
}
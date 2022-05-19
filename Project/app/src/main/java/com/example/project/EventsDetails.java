package com.example.project;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;


public class EventsDetails extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")

    private String eventRecieved;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eventsdetails);
        WebView myWebView;
        myWebView = (WebView) findViewById(R.id.mapview);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new WebViewClient());
        //if(eventRecieved.equals("")) {
            myWebView.loadUrl("https://goo.gl/maps/tJDpd43LZeqDGUDw6");
        //}
    }

    protected void onResume() {
        super.onResume();

    }

    protected void onStart() {
        super.onStart();
    }

    protected void onRestart() {
        super.onRestart();

    }

    protected void onStop() {
        super.onStop();

    }

    protected void onPause() {
        super.onPause();

    }

    protected void onDestroy() {
        super.onDestroy();

    }
}


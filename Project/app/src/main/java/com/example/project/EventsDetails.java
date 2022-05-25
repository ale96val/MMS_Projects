package com.example.project;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

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
        Bundle extras = getIntent().getExtras();
        TextView title = findViewById(R.id.placeTitle);
        TextView description = findViewById(R.id.placeDescription);
        ImageView img1 = findViewById(R.id.eventDetailImage1);
        ImageView img2 = findViewById(R.id.eventDetailImage2);
        ImageView img3 = findViewById(R.id.eventDetailImage3);
        eventRecieved = extras.getString("Event");
        if(eventRecieved.contains("Opera")) {
            title.setText(eventRecieved.split(",")[0]);
            description.setText(eventRecieved);
            myWebView.loadUrl("https://goo.gl/maps/tJDpd43LZeqDGUDw6");
            img1.setImageResource(R.drawable.theater_icon);
            img2.setImageResource(R.drawable.theater_icon);
            img3.setImageResource(R.drawable.theater_icon);
        }else if(eventRecieved.contains("Warszawa")) {
            title.setText(eventRecieved.split(",")[0]);
            description.setText(eventRecieved);
            myWebView.loadUrl("https://goo.gl/maps/PteUbDEWyxy8xKgCA");
            img1.setImageResource(R.drawable.trip_icon);
            img2.setImageResource(R.drawable.trip_icon);
            img3.setImageResource(R.drawable.trip_icon);
        }else{
            title.setText(eventRecieved.split(",")[0]);
            description.setText(eventRecieved);
            myWebView.loadUrl("https://goo.gl/maps/GE2DFBBVhxx3RWLP8");
            img1.setImageResource(R.drawable.skyscrapper_foreground);
            img2.setImageResource(R.drawable.skyscrapper_foreground);
            img3.setImageResource(R.drawable.skyscrapper_foreground);
        }
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


package com.example.project;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;


public class RoutesDetails extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")

    private String routeRecieved;
    private TextToSpeech readtext;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.routesdetails);
        WebView myWebView;
        myWebView = findViewById(R.id.mapview);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new WebViewClient());
        Bundle extras = getIntent().getExtras();
        TextView title = findViewById(R.id.accommodationTitle2);
        TextView description = findViewById(R.id.accommodaitonDescription);
        ImageView img1 = findViewById(R.id.eventDetailImage1);
        ImageView img2 = findViewById(R.id.eventDetailImage2);
        ImageView img3 = findViewById(R.id.eventDetailImage3);
        RatingBar evaluation = findViewById(R.id.accommodationEvaluation);
        routeRecieved = extras.getString("Route");
        WebView webView=findViewById(R.id.videoView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient(){
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }
        });
        String frameVideo;
        if (routeRecieved.contains("Mo")) {
            title.setText(routeRecieved.split(",")[0]);
            description.setText(routeRecieved);
            myWebView.loadUrl("https://www.google.com/maps/d/embed?mid=1CIWPzm8PuHZ7lVs2s-9aZXVIQZw&hl=pl&ehbc=2E312F");
            img1.setImageResource(R.drawable.ic_baseline_wb_cloudy_24);
            img2.setImageResource(R.drawable.trip_icon);
            img3.setImageResource(R.drawable.theater_icon);
            evaluation.setRating(Float.parseFloat(routeRecieved.split(",")[1]));
            frameVideo = "<html><body><iframe width=\"340\" height=\"340\" src=\"https://www.youtube.com/embed/1B2pXaQmHsY?end=30;\" frameborder=\"0\" allowfullscreen></iframe></body></html>";
            webView.loadData(frameVideo, "text/html", "utf-8");
        }else if(routeRecieved.contains("tour")) {
            title.setText(routeRecieved.split(",")[0]);
            description.setText(routeRecieved);
            myWebView.loadUrl("https://www.google.com/maps/d/embed?mid=1QUOKTxeKyAm9iKtRKXz05R8yYoXwV6fo&hl=en_US&ehbc=2E312F");
            img1.setImageResource(R.drawable.skyscrapper_foreground);
            img2.setImageResource(R.drawable.house_foreground);
            img3.setImageResource(R.drawable.trip_icon);
            evaluation.setRating(Float.parseFloat(routeRecieved.split(",")[1]));
            frameVideo = "<html><body><iframe width=\"340\" height=\"340\" src=\"https://www.youtube.com/embed/cMUzOFVI5LI?end=30;\" frameborder=\"0\" allowfullscreen></iframe></body></html>";
            webView.loadData(frameVideo, "text/html", "utf-8");
        }else{
            title.setText(routeRecieved.split(",")[0]);
            description.setText(routeRecieved);
            myWebView.loadUrl("https://www.google.com/maps/d/embed?mid=1DskQdfaYxcuuxMP8nLUoHzkoT0I&hl=cs&ehbc=2E312F");
            img1.setImageResource(R.drawable.skyscrapper_foreground);
            img2.setImageResource(R.drawable.skyscrapper_foreground);
            img3.setImageResource(R.drawable.skyscrapper_foreground);
            evaluation.setRating(Float.parseFloat(routeRecieved.split(",")[1]));
            frameVideo = "<html><body><iframe width=\"340\" height=\"340\" src=\"https://www.youtube.com/embed/xluQv1X1I6Y?end=30;\" frameborder=\"0\" allowfullscreen></iframe></body></html>";
            webView.loadData(frameVideo, "text/html", "utf-8");
        }
    }
    private void speak(String text){
        readtext.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);
    }

    public void setReadtext(View view){
        readtext = new TextToSpeech(this, status -> {
            if (status == TextToSpeech.SUCCESS) {
                int result = readtext.setLanguage(Locale.US);
                if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    Log.e("TTS", "This Language is not supported");
                }
                speak(routeRecieved);

            } else {
                Log.e("TTS", "Initilization Failed!");
            }
        });
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
        if (readtext != null) {
            readtext.stop();
            readtext.shutdown();
        }
        super.onDestroy();

    }
}


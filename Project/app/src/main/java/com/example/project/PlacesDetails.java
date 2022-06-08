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


public class PlacesDetails extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")

    private String placeRecieved;
    private TextToSpeech readtext;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.placesdetails);
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
        placeRecieved = extras.getString("Place");
        WebView webView=findViewById(R.id.videoView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient(){
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }
        });
        String frameVideo;
        if (placeRecieved.contains("Rynek")) {
            title.setText(placeRecieved.split(",")[0]);
            description.setText(placeRecieved);
            myWebView.loadUrl("https://goo.gl/maps/aMvbGpsZSHLGhEEC9");
            img1.setImageResource(R.drawable.theater_icon);
            img2.setImageResource(R.drawable.house_foreground);
            img3.setImageResource(R.drawable.studenthouse_foreground);
            evaluation.setRating(Float.parseFloat(placeRecieved.split(",")[1]));
            frameVideo = "<html><body><iframe width=\"340\" height=\"340\" src=\"https://www.youtube.com/embed/xzIMSKN7a2c?end=30;\" frameborder=\"0\" allowfullscreen></iframe></body></html>";
            webView.loadData(frameVideo, "text/html", "utf-8");
        }else if(placeRecieved.contains("Zoo")) {
            title.setText(placeRecieved.split(",")[0]);
            description.setText(placeRecieved);
            myWebView.loadUrl("https://goo.gl/maps/VTLV2CNcGzndg3bQ6");
            img1.setImageResource(R.drawable.trip_icon);
            img2.setImageResource(R.drawable.ic_baseline_wb_cloudy_24);
            img3.setImageResource(R.drawable.trip_icon);
            evaluation.setRating(Float.parseFloat(placeRecieved.split(",")[1]));
            frameVideo = "<html><body><iframe width=\"340\" height=\"340\" src=\"https://www.youtube.com/embed/cMUzOFVI5LI?end=30;\" frameborder=\"0\" allowfullscreen></iframe></body></html>";
            webView.loadData(frameVideo, "text/html", "utf-8");
        }else if(placeRecieved.contains("Wroclaw")){
            title.setText(placeRecieved.split(",")[0]);
            description.setText(placeRecieved);
            myWebView.loadUrl("https://goo.gl/maps/Qe14drqFZfsS4HPt9");
            img1.setImageResource(R.drawable.skyscrapper_foreground);
            img2.setImageResource(R.drawable.house_foreground);
            img3.setImageResource(R.drawable.studenthouse_foreground);
            evaluation.setRating(Float.parseFloat(placeRecieved.split(",")[1]));
            frameVideo = "<html><body><iframe width=\"340\" height=\"340\" src=\"https://www.youtube.com/embed/Gc7_MeFnSaU?end=30;\" frameborder=\"0\" allowfullscreen></iframe></body></html>";
            webView.loadData(frameVideo, "text/html", "utf-8");
        }else if(placeRecieved.contains("Slodowa")){
            title.setText(placeRecieved.split(",")[0]);
            description.setText(placeRecieved);
            myWebView.loadUrl("https://g.page/slodowa?share");
            img1.setImageResource(R.drawable.ic_baseline_wb_cloudy_24);
            img2.setImageResource(R.drawable.skyscrapper_foreground);
            img3.setImageResource(R.drawable.studenthouse_foreground);
            evaluation.setRating(Float.parseFloat(placeRecieved.split(",")[1]));
        }else{
            title.setText(placeRecieved.split(",")[0]);
            description.setText(placeRecieved);
            myWebView.loadUrl("https://goo.gl/maps/PteUbDEWyxy8xKgCA");
            img1.setImageResource(R.drawable.skyscrapper_foreground);
            img2.setImageResource(R.drawable.trip_icon);
            img3.setImageResource(R.drawable.studenthouse_foreground);
            evaluation.setRating(Float.parseFloat(placeRecieved.split(",")[1]));
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
                speak(placeRecieved);

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


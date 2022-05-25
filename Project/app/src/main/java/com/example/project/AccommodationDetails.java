package com.example.project;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class AccommodationDetails extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")

    private String placeRecieved;

    public AccommodationDetails() {
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accommodationdetails);
        WebView myWebView;
        myWebView = (WebView) findViewById(R.id.mapview);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new WebViewClient());
        Bundle extras = getIntent().getExtras();
        TextView title = findViewById(R.id.accommodationTitle2);
        TextView description = findViewById(R.id.accommodaitonDescription);
        ImageView img1 = findViewById(R.id.eventDetailImage1);
        ImageView img2 = findViewById(R.id.eventDetailImage2);
        ImageView img3 = findViewById(R.id.eventDetailImage3);
        RatingBar evaluation = findViewById(R.id.accommodationEvaluation);
        placeRecieved = extras.getString("Accommodation");
        if(placeRecieved.contains("Warszawa")) {
            title.setText(placeRecieved.split(",")[0]);
            description.setText(placeRecieved);
            myWebView.loadUrl("https://goo.gl/maps/wbPy5dntVcn23YCw8");
            img1.setImageResource(R.drawable.theater_icon);
            img2.setImageResource(R.drawable.theater_icon);
            img3.setImageResource(R.drawable.theater_icon);
            evaluation.setRating(Float.parseFloat(placeRecieved.split(",")[1]));
        }else if(placeRecieved.contains("Appartament")) {
            title.setText(placeRecieved.split(",")[0]);
            description.setText(placeRecieved);
            myWebView.loadUrl("https://goo.gl/maps/eQTm28vYtQhxYfgJ6");
            img1.setImageResource(R.drawable.trip_icon);
            img2.setImageResource(R.drawable.trip_icon);
            img3.setImageResource(R.drawable.trip_icon);
            evaluation.setRating(Float.parseFloat(placeRecieved.split(",")[1]));
        }else if(placeRecieved.contains("Studenkie")){
            title.setText(placeRecieved.split(",")[0]);
            description.setText(placeRecieved);
            myWebView.loadUrl("https://goo.gl/maps/Aiq9q3Kxyw8Z8Zjn8");
            img1.setImageResource(R.drawable.skyscrapper_foreground);
            img2.setImageResource(R.drawable.skyscrapper_foreground);
            img3.setImageResource(R.drawable.skyscrapper_foreground);
            evaluation.setRating(Float.parseFloat(placeRecieved.split(",")[1]));
        }else if(placeRecieved.contains("EuroStars")){
            title.setText(placeRecieved.split(",")[0]);
            description.setText(placeRecieved);
            myWebView.loadUrl("https://goo.gl/maps/wJaLLLkheEQFroSX7");
            img1.setImageResource(R.drawable.skyscrapper_foreground);
            img2.setImageResource(R.drawable.skyscrapper_foreground);
            img3.setImageResource(R.drawable.skyscrapper_foreground);
            evaluation.setRating(Float.parseFloat(placeRecieved.split(",")[1]));
        }else{
            title.setText(placeRecieved.split(",")[0]);
            description.setText(placeRecieved);
            myWebView.loadUrl("https://goo.gl/maps/WzaiqiTZSfXVHWok6");
            img1.setImageResource(R.drawable.skyscrapper_foreground);
            img2.setImageResource(R.drawable.skyscrapper_foreground);
            img3.setImageResource(R.drawable.skyscrapper_foreground);
            evaluation.setRating(Float.parseFloat(placeRecieved.split(",")[1]));
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


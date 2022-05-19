package com.example.project;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    public void gotoEvents(View view) {
        Intent intent = new Intent(this, Events.class);
        startActivity(intent);
    }

    public void gotoPlaces(View view) {
        Intent intent = new Intent(this, Places.class);
        startActivity(intent);
    }

    public void gotoAccommodations(View view) {
        Intent intent = new Intent(this, Accommodations.class);
        startActivity(intent);
    }

    public void switchLanguage(View view) {
        Locale myLocale;
        Locale current = getResources().getConfiguration().locale;
        if(current.toString().equals("en_US") || current.toString().equals("en_us")){
            myLocale = new Locale("es");
        }else{
            myLocale = new Locale("en_US");
        }

        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, MainActivity.class);
        finish();
        startActivity(refresh);
    }
}


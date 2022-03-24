package com.example.mms_project1;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class AboutUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        Log.d("TAG", "The onCreate() event");
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("TAG", "The onStart() event");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TAG", "The onResume() event");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TAG", "The onPause() event");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("TAG", "The onStop() event");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TAG", "The onDestroy() event");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("TAG", "The onRestart() event");
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

}
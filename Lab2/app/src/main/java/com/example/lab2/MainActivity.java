package com.example.lab2;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

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

    public void addElement(View view) {
        Snackbar.make(view, "Here's a Snack", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
}
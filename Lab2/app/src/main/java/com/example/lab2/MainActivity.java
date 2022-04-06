package com.example.lab2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class MainActivity extends AppCompatActivity {
    Set<String> StringSet = new HashSet<String>();
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
        SharedPreferences sharedPref = getSharedPreferences("Task",Context.MODE_PRIVATE);
        String task = sharedPref.getString("Task", "default");
        if(task!="default"){
            StringSet.add(task);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.clear();
            editor.commit();
            SharedPreferences sharedPref2 = getSharedPreferences("Tasks",Context.MODE_PRIVATE);
            SharedPreferences.Editor editor2 = sharedPref2.edit();
            editor2.putStringSet("Tasks", StringSet);
            Log.d("TAG", StringSet.toString());
            editor2.commit();
        }
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
        Intent intent = new Intent(this, AddActivity.class);
        startActivity(intent);
    }
}
package com.example.lab2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class AddActivity extends AppCompatActivity {

    String TaskAdded = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_activity);
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

    public void add_task(View view) {
        EditText Name = findViewById(R.id.TaskNameText);
        String NameText = Name.getText().toString();
        EditText Description = findViewById(R.id.task_description_text);
        String DescriptionText = Description.getText().toString();
        RadioGroup TaskType = findViewById(R.id.select_task);
        int TaskType2 = TaskType.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(TaskType2);
        String TaskTypeText = radioButton.getText().toString();
        EditText TaskDate= findViewById(R.id.task_date);
        String TaskDateText = TaskDate.getText().toString();
        @SuppressLint("UseSwitchCompatOrMaterialCode") Switch Status = findViewById(R.id.Status_text);
        boolean StatusText = Status.isChecked();
        TaskAdded = NameText + ", " + DescriptionText + ", " + TaskTypeText + ", " + TaskDateText + ", " + StatusText;
        SharedPreferences sharedPref = getSharedPreferences("Task", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("Task", TaskAdded);
        editor.commit();
        finish();
    }
}
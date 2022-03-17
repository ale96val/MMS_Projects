package com.example.mms_project1;

import android.os.Bundle;
import android.sax.EndElementListener;
import android.text.Editable;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("TAG", "The onCreate() event");
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

    public void CountClick(View view) {
        EditText editText1=findViewById(R.id.editTextNumber);
        EditText editText2=findViewById(R.id.editTextNumber2);
        if (editText1.getInputType() != InputType.TYPE_CLASS_NUMBER){
            Log.d("TAG", "The text is not a number");
            return;
        }
        if (editText2.getInputType() != InputType.TYPE_CLASS_NUMBER){
            Log.d("TAG", "The text is not a number");
            return;
        }
        if (editText1.getText().toString().matches("")){
            Log.d("TAG", "The text is not a number");
            return;
        }
        if (editText2.getText().toString().matches("")){
            Log.d("TAG", "The text is not a number");
            return;
        }
        Log.d("TAG", editText1.getText().toString());
        Log.d("TAG", "OK");
        float editText1value = Integer.parseInt(editText1.getText().toString());
        float editText2value = Integer.parseInt(editText2.getText().toString());
        if (editText1value != 0 && editText2value != 0) {
            float result = (editText1value / (editText2value/100 * editText2value));
            TextView BMI = findViewById(R.id.BMI);
            BMI.setText(String.valueOf(result));
        }

    }
}
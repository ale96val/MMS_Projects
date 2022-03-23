package com.example.mms_project1;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import org.w3c.dom.Text;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);
        Log.d("TAG", "The onCreate() event");
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        TextView BMI = findViewById(R.id.BMI);
        TextView Status = findViewById(R.id.Status);
        Float result = null;
        BMI.setText(String.valueOf(result));
            if (result <= 18.5){
                Status.setText("Underweight");
                Status.setTextColor(Color.BLUE);
            }else if(18.5 < result && result <= 24.9){
                Status.setText("Normal Weight");
                Status.setTextColor(Color.GREEN);
            }else{
                Status.setText("Overweight");
                Status.setTextColor(Color.YELLOW);
            }
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

}




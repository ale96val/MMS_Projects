package com.example.mms_project1;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Details extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);
        Log.d("TAG", "The onCreate() event");
        Bundle extras = getIntent().getExtras();
        float result = 0;
        if (extras != null) {
            result = Float.parseFloat(extras.getString("key"));
        }
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        TextView BMI = findViewById(R.id.BMI);
        TextView Status = findViewById(R.id.Status);
        TextView Details = findViewById(R.id.details);
        Details.setTextSize(24);
        BMI.setText(String.valueOf(result));
            if (result <= 18.5){
                Status.setText("Underweight");
                Status.setTextColor(Color.BLUE);
                Details.setText("Being underweight could be a sign you're not eating enough or you may be ill. If you're underweight, a GP can help.");
            }else if(18.5 < result && result <= 24.9){
                Status.setText("Normal Weight");
                Status.setTextColor(Color.GREEN);
                Details.setText("Keep up the good work! For tips on maintaining a healthy weight, check out the food and diet and fitness sections.");
            }else{
                Status.setText("Overweight");
                Status.setTextColor(Color.YELLOW);
                Details.setText("The best way to lose weight if you're overweight is through a combination of diet and exercise.");
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




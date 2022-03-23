package com.example.mms_project1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    @SuppressLint("SetTextI18n")
    public void CountClick1(View view) {
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
            float result = (editText1value / (editText2value/100 * editText2value/100));
            TextView BMI = findViewById(R.id.BMI);
            BMI.setText(String.valueOf(result));
            TextView Status = findViewById(R.id.Status);
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

    }

    @SuppressLint({"ResourceAsColor", "SetTextI18n"})
    public void CountClick2(View view) {
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
            float result = (editText1value / (editText2value * editText2value)) * 703;
            TextView BMI = findViewById(R.id.BMI);
            TextView Status = findViewById(R.id.Status);
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

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        EditText editText1=findViewById(R.id.editTextNumber);
        EditText editText2=findViewById(R.id.editTextNumber2);
        Button count = findViewById(R.id.Count_Button);
        TextView mode = findViewById(R.id.Mode);
        switch (item.getItemId()) {
            case R.id.toKg:
                mode.setText("Mode: European");
                editText1.setHint("Mass (Kg)");
                editText2.setHint("Height (Cm)");
                count.setOnClickListener(this::CountClick1);
                return true;
            case R.id.toLs:
                mode.setText("Mode: UK");
                editText1.setHint("Mass (Ls)");
                editText2.setHint("Height (In)");
                count.setOnClickListener(this::CountClick2);
                return true;

            case R.id.AboutUs:
                Intent intent = new Intent(this, AboutUs.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void SeeDetails(View view) {
        Intent intent = new Intent(this, Details.class);
        startActivity(intent);
    }
}
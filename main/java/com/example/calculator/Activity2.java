package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
    int count;
    int secondCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        Intent intent = getIntent();
        count = intent.getIntExtra("count",count);
        secondCount = intent.getIntExtra("secondCount", secondCount);
        TextView counterView = findViewById(R.id.txt_counter);
        if (secondCount<0){
            counterView.setText(count + " + " +"("+ secondCount + ")" + " = " + (count+secondCount));
        }
        else{
            counterView.setText(count + " + " + secondCount + " = " + (count+secondCount));
        }
    }
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        TextView mainView = findViewById(R.id.txt_counter);
        outState.putString("mainText", String.valueOf(mainView.getText()));
    }
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null && savedInstanceState.containsKey("mainText")) {
           count = savedInstanceState.getInt("Count");
           secondCount = savedInstanceState.getInt("secondCount");
        }
    }
}
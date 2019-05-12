package com.apporiotaxi.techbangla.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        Intent mIntent = getIntent();
        int intValue = mIntent.getIntExtra("score", 0);
        TextView t=(TextView)findViewById(R.id.textView);

        switch (intValue)
        {
            case 0: t.setText("You answered correctly on " + intValue +"/"+"10" +" questions");
                break;
            case 1: t.setText("You answered correctly on " + intValue +"/"+"10" +" questions");
                break;
            case 2: t.setText("You answered correctly on " + intValue +"/"+"10" +" questions");
                break;
            case 3: t.setText("You answered correctly on " + intValue +"/"+"10" +" questions");
                break;
            case 4:t.setText("You answered correctly on " + intValue +"/"+"10" +" questions");
                break;
            case 5:t.setText("You answered correctly on " + intValue +"/"+"10" +" questions");
                break;
            case 6: t.setText("You answered correctly on " + intValue +"/"+"10" +" questions");
                break;
            case 7: t.setText("You answered correctly on " + intValue +"/"+"10" +" questions");
                break;
            case 8: t.setText("You answered correctly on " + intValue +"/"+"10" +" questions");
                break;
            case 9: t.setText("You answered correctly on " + intValue +"/"+"10" +" questions");
                break;
            case 10:t.setText("You answered correctly on " + intValue +"/"+"10" +" questions");
                break;
        }
    }
}

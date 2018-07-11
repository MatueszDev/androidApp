package com.nokia.soccer.soccerapp;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    public static final String KEY = "keyForResult";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null){
            restoreResultText(savedInstanceState.getString(KEY));
        }
        initiliazeListeners();
    }

    private void restoreResultText(String result) {
        TextView resultView = findViewById(R.id.result);
        resultView.setText(result);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        TextView resultView = findViewById(R.id.result);
        outState.putString(KEY, resultView.getText().toString());
    }

    private void initiliazeListeners() {

        Button calculateView = findViewById(R.id.calculate_btn);
        calculateView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result = calculate();
                display(result);
            }
        });
        Button downloadBtn = findViewById(R.id.download_btn);
        downloadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    new DownloadTask(MainActivity.this).execute();
            }
        });
    }

    private void display(int result) {
        TextView resultView = findViewById(R.id.result);
        resultView.setText(Integer.toString(result));
    }

    private int calculate() {
        EditText viewById = findViewById(R.id.input);
        return FairPlayPointsCalucator.calculatePoints(viewById.getText().toString());
    }
}

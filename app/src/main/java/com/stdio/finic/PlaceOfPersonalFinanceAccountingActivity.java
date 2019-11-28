package com.stdio.finic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Toast;

public class PlaceOfPersonalFinanceAccountingActivity extends AppCompatActivity {

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme_ToolBar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_of_personal_finance_accounting);

        progressBar = findViewById(R.id.progressId);
        progressBar.setProgress(70);

        RadioButton redRadioButton = findViewById(R.id.radioButton1);
        redRadioButton.setOnClickListener(radioButtonClickListener);

        RadioButton greenRadioButton = findViewById(R.id.radioButton2);
        greenRadioButton.setOnClickListener(radioButtonClickListener);

        RadioButton blueRadioButton = findViewById(R.id.radioButton3);
        blueRadioButton.setOnClickListener(radioButtonClickListener);
    }

    View.OnClickListener radioButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RadioButton rb = (RadioButton)v;
            Toast.makeText(PlaceOfPersonalFinanceAccountingActivity.this, rb.getText(), Toast.LENGTH_SHORT).show();
        }
    };
}

package com.stdio.finic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Toast;

public class ReasonForNotAccountingForPersonaFinancesActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    int id = 0;
    String answer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reason_for_not_accounting_for_persona_finances);

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
            id = rb.getId();
            answer = "\n\nПочему вы не ведете учет личных финансов? - " + rb.getText();
        }
    };

    public void onClick(View view) {
        MainActivity.message += answer;
        startActivity(new Intent(this, FinancialAccountingIncentiveActivity.class));
    }
}

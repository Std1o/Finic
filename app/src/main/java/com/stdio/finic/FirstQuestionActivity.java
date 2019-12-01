package com.stdio.finic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Toast;

public class FirstQuestionActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    int id = 0;
    String answer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_question);
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
            answer = "Ведете ли вы учет личных финансов? - " + rb.getText();
        }
    };

    public void onClick(View view) {
        if (id == R.id.radioButton1 || id == R.id.radioButton2) {
            MainActivity.message += answer;
            startActivity(new Intent(FirstQuestionActivity.this, PlaceOfPersonalFinanceAccountingActivity.class));
            finish();
        }
        else if (id == R.id.radioButton3){
            MainActivity.message += answer;
            startActivity(new Intent(this, ReasonForNotAccountingForPersonaFinancesActivity.class));
        }
        else {
            Toast.makeText(this, getResources().getString(R.string.err_no_selected), Toast.LENGTH_SHORT).show();
        }
    }
}

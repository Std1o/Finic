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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme_ToolBar);
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
            Toast.makeText(FirstQuestionActivity.this, rb.getText(), Toast.LENGTH_SHORT).show();
        }
    };

    public void onClick(View view) {
        if (id == R.id.radioButton1 || id == R.id.radioButton2) {
            startActivity(new Intent(FirstQuestionActivity.this, PlaceOfPersonalFinanceAccountingActivity.class));
        }
        else if (id == R.id.radioButton3){
            startActivity(new Intent(this, ReasonForNotAccountingForPersonaFinancesActivity.class));
        }
        else {
            Toast.makeText(this, getResources().getString(R.string.err_no_selected), Toast.LENGTH_SHORT).show();
        }
    }
}

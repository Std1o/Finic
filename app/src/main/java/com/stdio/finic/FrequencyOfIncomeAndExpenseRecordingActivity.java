package com.stdio.finic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class FrequencyOfIncomeAndExpenseRecordingActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    int id = 0;
    String answer = "";
    TextView tvMoney;
    SharedPreferences prefs;
    boolean nextIsAllowed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frequency_of_income_and_expense_recording);

        tvMoney = findViewById(R.id.tvMoney);
        prefs = getSharedPreferences("moneyPref", MODE_PRIVATE);
        tvMoney.setText(prefs.getInt("moneyCount", 0) + "");

        progressBar = findViewById(R.id.progressId);
        progressBar.setProgress(48);

        RadioButton redRadioButton = findViewById(R.id.radioButton1);
        redRadioButton.setOnClickListener(radioButtonClickListener);

        RadioButton greenRadioButton = findViewById(R.id.radioButton2);
        greenRadioButton.setOnClickListener(radioButtonClickListener);

        RadioButton blueRadioButton = findViewById(R.id.radioButton3);
        blueRadioButton.setOnClickListener(radioButtonClickListener);

        RadioButton fourth = findViewById(R.id.radioButton4);
        fourth.setOnClickListener(radioButtonClickListener);
    }

    View.OnClickListener radioButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RadioButton rb = (RadioButton)v;
            id = rb.getId();
            answer = "\n\nКак часто вы вносите доходы/расходы в учет? - " + rb.getText();
            nextIsAllowed = true;
        }
    };

    public void onClick(View view) {
        if (nextIsAllowed) {
            MainActivity.message += answer;
            SharedPreferences.Editor editor = prefs.edit();
            editor.putInt("moneyCount", 450);
            editor.apply();
            startActivity(new Intent(FrequencyOfIncomeAndExpenseRecordingActivity.this, NecessaryFunctionalActivity.class));
            finish();
        }
        else {
            Toast.makeText(this, getResources().getString(R.string.err_no_selected), Toast.LENGTH_SHORT).show();
        }
    }
}

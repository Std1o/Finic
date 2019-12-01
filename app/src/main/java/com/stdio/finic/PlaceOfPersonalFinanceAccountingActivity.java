package com.stdio.finic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.CheckBox;
import android.widget.Toast;

public class PlaceOfPersonalFinanceAccountingActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_of_personal_finance_accounting);

        progressBar = findViewById(R.id.progressId);
        progressBar.setProgress(70);

        CheckBox redCheckBox = findViewById(R.id.checkBox1);
        redCheckBox.setOnClickListener(CheckBoxClickListener);

        CheckBox greenCheckBox = findViewById(R.id.checkBox2);
        greenCheckBox.setOnClickListener(CheckBoxClickListener);

        CheckBox blueCheckBox = findViewById(R.id.checkBox3);
        blueCheckBox.setOnClickListener(CheckBoxClickListener);

        CheckBox fourthCheckBox = findViewById(R.id.checkBox4);
        fourthCheckBox.setOnClickListener(CheckBoxClickListener);
    }

    View.OnClickListener CheckBoxClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            CheckBox rb = (CheckBox)v;
            Toast.makeText(PlaceOfPersonalFinanceAccountingActivity.this, rb.getText(), Toast.LENGTH_SHORT).show();
        }
    };

    public void onClick(View view) {
        startActivity(new Intent(PlaceOfPersonalFinanceAccountingActivity.this, FrequencyOfIncomeAndExpenseRecordingActivity.class));

    }
}

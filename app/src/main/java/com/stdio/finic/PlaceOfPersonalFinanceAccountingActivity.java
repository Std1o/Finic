package com.stdio.finic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PlaceOfPersonalFinanceAccountingActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    int id = 0;
    boolean isFirstClick = true;
    ArrayList<String> list = new ArrayList<>();
    TextView tvMoney;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_of_personal_finance_accounting);

        tvMoney = findViewById(R.id.tvMoney);
        prefs = getSharedPreferences("moneyPref", MODE_PRIVATE);
        tvMoney.setText(prefs.getInt("moneyCount", 0) + "");

        progressBar = findViewById(R.id.progressId);
        progressBar.setProgress(32);

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
            if (isFirstClick) {
                MainActivity.message += "\n\nГде вы ведете учете личных финансов? - ";
            }
            isFirstClick = false;
            if (rb.isChecked()) {
                if (!list.contains(rb.getText().toString())) {
                    list.add(rb.getText().toString());
                }
            }
            else {
                list.remove(rb.getText().toString());
            }
        }
    };

    public void onClick(View view) {
        for (String s : list) {
            MainActivity.message += s + ", ";
        }
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("moneyCount", prefs.getInt("moneyCount", 0) + 150);
        editor.apply();
        startActivity(new Intent(PlaceOfPersonalFinanceAccountingActivity.this, FrequencyOfIncomeAndExpenseRecordingActivity.class));
        finish();
    }
}

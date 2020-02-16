package com.stdio.finic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class YesActivity4 extends AppCompatActivity {

    boolean isFirstClick = true;
    ArrayList<String> list = new ArrayList<>();
    EditText etAdvice;
    TextView tvMoney;
    SharedPreferences prefs;
    private ProgressBar progressBar;
    boolean nextIsAllowed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences languagePref = getSharedPreferences("languagePref", MODE_PRIVATE);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        android.content.res.Configuration conf = res.getConfiguration();
        conf.setLocale(new Locale(MainActivity.getLanguageFromPosition(languagePref
                .getInt("language", MainActivity.getSpinnerPosition(Locale.getDefault().getCountry())))));
        res.updateConfiguration(conf, dm);
        setContentView(R.layout.activity_yes4);

        progressBar = findViewById(R.id.progressId);
        progressBar.setProgress(64);

        tvMoney = findViewById(R.id.tvMoney);
        prefs = getSharedPreferences("moneyPref", MODE_PRIVATE);
        tvMoney.setText(prefs.getInt("moneyCount", 0) + "");

        SharedPreferences currentPagePref = getSharedPreferences("currentPagePref", MODE_PRIVATE);
        SharedPreferences.Editor editor = currentPagePref.edit();
        editor.putString("currentPage", getClass().getSimpleName());
        editor.apply();


        CheckBox redCheckBox = findViewById(R.id.checkBox1);
        redCheckBox.setOnClickListener(CheckBoxClickListener);

        CheckBox greenCheckBox = findViewById(R.id.checkBox2);
        greenCheckBox.setOnClickListener(CheckBoxClickListener);

        CheckBox blueCheckBox = findViewById(R.id.checkBox3);
        blueCheckBox.setOnClickListener(CheckBoxClickListener);

        CheckBox fourthCheckBox = findViewById(R.id.checkBox4);
        fourthCheckBox.setOnClickListener(CheckBoxClickListener);

        CheckBox fifthCheckBox = findViewById(R.id.checkBox5);
        fifthCheckBox.setOnClickListener(CheckBoxClickListener);

        CheckBox sixthCheckBox = findViewById(R.id.checkBox6);
        sixthCheckBox.setOnClickListener(CheckBoxClickListener);

        etAdvice = findViewById(R.id.etAdvice);

    }

    View.OnClickListener CheckBoxClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            CheckBox rb = (CheckBox)v;
            if (isFirstClick) {
                MainActivity.message += "\n\nОтметьте, какими функциями должно обладать идеальное приложение для учета финансов, чтобы вы им пользовались - ";
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
            if (!list.isEmpty()) {
                nextIsAllowed = true;
            }
            else {
                nextIsAllowed = false;
            }
        }
    };

    public void onClick(View view) {
        if (nextIsAllowed || !etAdvice.getText().toString().isEmpty()) {
            for (String s : list) {
                MainActivity.message += s + ", ";
            }
            if (!etAdvice.getText().toString().isEmpty()) {
                if (isFirstClick) {
                    MainActivity.message += "\n\nОтметьте, какими функциями должно обладать идеальное приложение для учета финансов, чтобы вы им пользовались - ";
                }
                MainActivity.message += "\nДругое - " + etAdvice.getText().toString();
            }
            SharedPreferences.Editor editor = prefs.edit();
            editor.putInt("moneyCount", prefs.getInt("moneyCount", 0) + 150);
            editor.apply();
            startActivity(new Intent(this, YesActivity5.class));
            finish();
        }
        else {
            Toast.makeText(this, getResources().getString(R.string.err_no_selected), Toast.LENGTH_SHORT).show();
        }
    }
}

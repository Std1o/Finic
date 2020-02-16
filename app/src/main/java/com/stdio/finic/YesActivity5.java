package com.stdio.finic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class YesActivity5 extends AppCompatActivity {

    EditText etAdvice;
    TextView tvMoney;
    SharedPreferences prefs;
    private ProgressBar progressBar;

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
        setContentView(R.layout.activity_yes5);
        etAdvice = findViewById(R.id.etAdvice);

        SharedPreferences currentPagePref = getSharedPreferences("currentPagePref", MODE_PRIVATE);
        SharedPreferences.Editor editor = currentPagePref.edit();
        editor.putString("currentPage", getClass().getSimpleName());
        editor.apply();

        progressBar = findViewById(R.id.progressId);
        progressBar.setProgress(80);

        tvMoney = findViewById(R.id.tvMoney);
        prefs = getSharedPreferences("moneyPref", MODE_PRIVATE);
        tvMoney.setText(prefs.getInt("moneyCount", 0) + "");
    }

    public void onClick(View view) {
        if (!etAdvice.getText().toString().isEmpty()) {
            MainActivity.message += "\n\nЧего вам не хватает в текущем способе учета личных финансов? - " + etAdvice.getText().toString();
            SharedPreferences.Editor editor = prefs.edit();
            editor.putInt("moneyCount", prefs.getInt("moneyCount", 0) + 200);
            editor.apply();
            startActivity(new Intent(this, YesActivity6.class));
            finish();
        }
        else {
            Toast.makeText(this, getResources().getString(R.string.empty_field), Toast.LENGTH_SHORT).show();
        }
    }
}

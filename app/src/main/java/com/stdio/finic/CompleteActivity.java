package com.stdio.finic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class CompleteActivity extends AppCompatActivity {

    TextView tvMoney;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete);

        tvMoney = findViewById(R.id.tvMoney);
        SharedPreferences prefs = getSharedPreferences("moneyPref", MODE_PRIVATE);
        tvMoney.setText(prefs.getInt("moneyCount", 0) + "");

        SharedPreferences isCompletedPref = getSharedPreferences("isCompletedPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = isCompletedPref.edit();
        editor.putBoolean("isCompleted", true);
        editor.apply();
    }
}

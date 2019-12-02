package com.stdio.finic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ImproveWayPersonalFinanceAccountActivity extends AppCompatActivity {

    EditText etAdvice;
    TextView tvMoney;
    SharedPreferences prefs;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_improve_way_personal_finance_account);
        etAdvice = findViewById(R.id.etAdvice);

        progressBar = findViewById(R.id.progressId);
        progressBar.setProgress(80);

        tvMoney = findViewById(R.id.tvMoney);
        prefs = getSharedPreferences("moneyPref", MODE_PRIVATE);
        tvMoney.setText(prefs.getInt("moneyCount", 0) + "");
    }

    public void onClick(View view) {
        if (!etAdvice.getText().toString().isEmpty()) {
            MainActivity.message += "\n\nЧего вам не хватает в текущем способе учета личных финансов? - " + etAdvice.getText().toString();
        }
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("moneyCount", prefs.getInt("moneyCount", 0) + 200);
        editor.apply();
        startActivity(new Intent(this, ReasonForAccountingForPersonaFinancesActivity.class));
        finish();
    }
}

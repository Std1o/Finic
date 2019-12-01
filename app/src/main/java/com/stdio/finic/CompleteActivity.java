package com.stdio.finic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class CompleteActivity extends AppCompatActivity {

    TextView tvMoney, tvCompleteBody2;

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

        tvCompleteBody2 = findViewById(R.id.tvCompleteBody2);
        String text = "<font color=#FFFFFF>\n" + getResources().getString(R.string.complete2)
                + "</font> <font color=#FFE300>" + getResources().getString(R.string.vip) + "</font>"
                + "</font> <font color=#FFFFFF>" + getResources().getString(R.string.in_our_app)+ "</font>"
                + "</font> <font color=#FFFFFF>" + getResources().getString(R.string.complete2_2)+ "</font>"
                + "</font> <font color=#FFE300> " + getResources().getString(R.string.thousand)+ "!</font>";
        tvCompleteBody2.setText(Html.fromHtml(text));
    }
}

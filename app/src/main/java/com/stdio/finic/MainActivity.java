package com.stdio.finic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static String message = "";
    TextView tvMoney, tvStartBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        SharedPreferences isCompletedPref = getSharedPreferences("isCompletedPref", MODE_PRIVATE);
        if (isCompletedPref.getBoolean("isCompleted", false)) {
            startActivity(new Intent(this, CompleteActivity.class));
            finish();
        }
        else {
            setContentView(R.layout.activity_main);
            tvMoney = findViewById(R.id.tvMoney);
            SharedPreferences prefs = getSharedPreferences("moneyPref", MODE_PRIVATE);
            tvMoney.setText(prefs.getInt("moneyCount", 0) + "");
            tvStartBody = findViewById(R.id.tvStartBody);
            String text = "<font color=#FFFFFF>\n" + getResources().getString(R.string.name)
                    + "</font> <font color=#FFE300>" + getResources().getString(R.string.finik)
                    + "</font>"
                    + "</font> <font color=#FFFFFF>" + getResources().getString(R.string.startFirstPart)+ "</font>"
                    + "</font> <font color=#FFE300>" + getResources().getString(R.string.thousand)+ "</font>"
                    + "</font> <font color=#FFFFFF>" + getResources().getString(R.string.in_our_app)+ "</font>";
            tvStartBody.setText(Html.fromHtml(text));
        }
    }

    public void onClick(View view) {
        startActivity(new Intent(this, FirstQuestionActivity.class));
        finish();
    }
}

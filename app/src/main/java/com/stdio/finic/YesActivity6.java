package com.stdio.finic;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.stdio.finic.gmailHelper.GMailSender;

import java.util.Locale;

public class YesActivity6 extends AppCompatActivity {

    EditText editText;
    String recipient = "martiality.me@yandex.ru";
    String senderMail = "finic.app@gmail.com";
    String senderPassword = "yourpassword";
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
        setContentView(R.layout.activity_yes6);

        progressBar = findViewById(R.id.progressId);
        progressBar.setProgress(95);

        SharedPreferences currentPagePref = getSharedPreferences("currentPagePref", MODE_PRIVATE);
        SharedPreferences.Editor editor = currentPagePref.edit();
        editor.putString("currentPage", getClass().getSimpleName());
        editor.apply();

        tvMoney = findViewById(R.id.tvMoney);
        prefs = getSharedPreferences("moneyPref", MODE_PRIVATE);
        tvMoney.setText(prefs.getInt("moneyCount", 0) + "");

        etAdvice = findViewById(R.id.etAdvice);
    }

    public void onClick(View view) {
        if (!etAdvice.getText().toString().isEmpty()) {
            MainActivity.message += "\n\nПочему вы ведете учет личных финансов? - " + etAdvice.getText().toString();
            sendMessage();
        }
        else {
            Toast.makeText(this, getResources().getString(R.string.empty_field), Toast.LENGTH_SHORT).show();
        }
    }

    private void sendMessage() {
        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setTitle("Sending Email");
        dialog.setMessage("Please wait...");
        dialog.setCancelable(false);
        dialog.show();
        Thread sender = new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    GMailSender sender = new GMailSender(senderMail, senderPassword);
                    sender.sendMail(getResources().getString(R.string.app_name), MainActivity.message,
                            senderMail,
                            recipient);
                    dialog.dismiss();
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putInt("moneyCount", prefs.getInt("moneyCount", 0) + 200);
                    editor.apply();
                    startActivity(new Intent(YesActivity6.this, CompleteActivity.class));
                    finish();
                } catch (Exception e) {
                    Log.e("mylog", "Error: " + e.getMessage());
                }
            }
        });
        sender.start();
    }
}

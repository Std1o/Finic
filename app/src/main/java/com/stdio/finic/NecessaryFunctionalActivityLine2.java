package com.stdio.finic;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.stdio.finic.gmailHelper.GMailSender;

import java.util.ArrayList;

public class NecessaryFunctionalActivityLine2 extends AppCompatActivity {

    ArrayList<String> list = new ArrayList<>();
    EditText etAdvice;
    boolean isFirstClick = true;
    String recipient = "martiality.me@yandex.ru";
    String senderMail = "finic.app@gmail.com";
    String senderPassword = "yourpassword";
    TextView tvMoney;
    SharedPreferences prefs;
    private ProgressBar progressBar;
    boolean nextIsAllowed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_necessary_functional_line2);

        progressBar = findViewById(R.id.progressId);
        progressBar.setProgress(90);

        tvMoney = findViewById(R.id.tvMoney);
        prefs = getSharedPreferences("moneyPref", MODE_PRIVATE);
        tvMoney.setText(prefs.getInt("moneyCount", 0) + "");

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
            if (isFirstClick) {
                MainActivity.message += "\n\nОтметьте, какими функциями должно обладать идеальное приложение для учета финансов, чтобы вы им пользовались - ";
            }
            MainActivity.message += "\nДругое - " + etAdvice.getText().toString();
            sendMessage();
        }
        else {
            Toast.makeText(this, getResources().getString(R.string.err_no_selected), Toast.LENGTH_SHORT).show();
        }
    }

    private void sendMessage() {
        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setTitle("Отправка данных");
        dialog.setMessage("Пожалуйста, подождите...");
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
                    editor.putInt("moneyCount", 1000);
                    editor.apply();
                    startActivity(new Intent(NecessaryFunctionalActivityLine2.this, CompleteActivity.class));
                    finish();
                } catch (Exception e) {
                    Log.e("mylog", "Error: " + e.getMessage());
                }
            }
        });
        sender.start();
    }
}

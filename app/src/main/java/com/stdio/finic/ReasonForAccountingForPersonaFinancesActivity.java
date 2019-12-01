package com.stdio.finic;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.stdio.finic.gmailHelper.GMailSender;

public class ReasonForAccountingForPersonaFinancesActivity extends AppCompatActivity {

    EditText editText;
    String recipient = "kwork-stdio@mail.ru";
    String senderMail = "finic.app@gmail.com";
    String senderPassword = "yourpassword";
    EditText etAdvice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reason_for_accounting_for_persona_finances);
        etAdvice = findViewById(R.id.etAdvice);
    }

    public void onClick(View view) {
        if (!etAdvice.getText().toString().isEmpty()) {
            MainActivity.message += "\n\nПочему вы ведете учет личных финансов? - " + etAdvice.getText().toString();
        }
        sendMessage();
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
                    startActivity(new Intent(ReasonForAccountingForPersonaFinancesActivity.this, CompleteActivity.class));
                    finish();
                } catch (Exception e) {
                    Log.e("mylog", "Error: " + e.getMessage());
                }
            }
        });
        sender.start();
    }
}

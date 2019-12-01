package com.stdio.finic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ImproveWayPersonalFinanceAccountActivity extends AppCompatActivity {

    EditText etAdvice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_improve_way_personal_finance_account);
        etAdvice = findViewById(R.id.etAdvice);
    }

    public void onClick(View view) {
        if (!etAdvice.getText().toString().isEmpty()) {
            MainActivity.message += "\n\nЧего вам не хватает в текущем способе учета личных финансов? - " + etAdvice.getText().toString();
        }
        startActivity(new Intent(this, ReasonForAccountingForPersonaFinancesActivity.class));
    }
}

package com.stdio.finic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ImproveWayPersonalFinanceAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_improve_way_personal_finance_account);
    }

    public void onClick(View view) {
        startActivity(new Intent(this, ReasonForAccountingForPersonaFinancesActivity.class));

    }
}

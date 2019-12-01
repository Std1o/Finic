package com.stdio.finic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FinancialAccountingIncentiveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_financial_accounting_incentive);
    }

    public void onClick(View view) {
        startActivity(new Intent(this, NecessaryFunctionalActivityLine2.class));

    }
}

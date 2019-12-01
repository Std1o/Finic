package com.stdio.finic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import java.util.ArrayList;

public class FinancialAccountingIncentiveActivity extends AppCompatActivity {

    ArrayList<String> list = new ArrayList<>();
    String question = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_financial_accounting_incentive);

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
    }

    View.OnClickListener CheckBoxClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            CheckBox rb = (CheckBox)v;
            question = "\n\nЧто вас сподвигло бы к учету личных финансов? - ";
            if (rb.isChecked()) {
                if (!list.contains(rb.getText().toString())) {
                    list.add(rb.getText().toString());
                }
            }
            else {
                list.remove(rb.getText().toString());
            }
        }
    };

    public void onClick(View view) {
        MainActivity.message += question;
        for (String s : list) {
            MainActivity.message += s + ", ";
        }
        startActivity(new Intent(this, NecessaryFunctionalActivityLine2.class));
    }
}

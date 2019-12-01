package com.stdio.finic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.ArrayList;

public class NecessaryFunctionalActivity extends AppCompatActivity {

    boolean isFirstClick = true;
    ArrayList<String> list = new ArrayList<>();
    EditText etAdvice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_necessary_functional);
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
        }
    };

    public void onClick(View view) {
        for (String s : list) {
            MainActivity.message += s + ", ";
        }
        if (!etAdvice.getText().toString().isEmpty()) {
            MainActivity.message += "\nДругое - " + etAdvice.getText().toString();
        }
        startActivity(new Intent(this, ImproveWayPersonalFinanceAccountActivity.class));
        finish();

    }
}

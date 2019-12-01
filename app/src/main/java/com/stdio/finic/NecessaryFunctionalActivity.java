package com.stdio.finic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class NecessaryFunctionalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_necessary_functional);
    }

    public void onClick(View view) {
        startActivity(new Intent(this, ImproveWayPersonalFinanceAccountActivity.class));

    }
}

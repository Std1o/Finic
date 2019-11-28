package com.stdio.finic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;

public class FirstQuestionActivity extends AppCompatActivity {

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme_ToolBar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_question);
        progressBar = findViewById(R.id.progressId);
        progressBar.setProgress(50);
    }
}

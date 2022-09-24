package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class SpeakActivity extends AppCompatActivity {
    private Button backToMainActivityFromSpeakActivityBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speak);

        backToMainActivityFromSpeakActivityBtn = findViewById(R.id.backBtn);
        backToMainActivityFromSpeakActivityBtn.setOnClickListener(v -> {
            finish();
        });
    }
}
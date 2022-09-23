package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button changeBackgroundBtn;
    private Button textToSpeechBtn;
    private Button apiVersionButton;
    private Button serialNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        changeBackgroundBtn = findViewById(R.id.changeBackgroundBtn);
        Random rnd = new Random();

        changeBackgroundBtn.setOnClickListener(v -> {
            int colour = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            changeBackgroundBtn.setBackgroundColor(colour);
            Toast.makeText(MainActivity.this, "New Test", Toast.LENGTH_LONG).show();
        });
    }
}
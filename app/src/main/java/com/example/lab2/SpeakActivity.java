package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class SpeakActivity extends AppCompatActivity {
    private TextView userEnteredTextField;
    private TextToSpeech ttobj;
    private Button backToMainActivityFromSpeakActivityBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speak);

        backToMainActivityFromSpeakActivityBtn = findViewById(R.id.backBtn);
        userEnteredTextField = findViewById(R.id.enterTextField);

        backToMainActivityFromSpeakActivityBtn.setOnClickListener(v -> finish());

        ttobj = new TextToSpeech(getApplicationContext(), status -> {
            if (status != TextToSpeech.ERROR) {
                String textToSay = userEnteredTextField.getText().toString();
                ttobj.setLanguage(Locale.CANADA_FRENCH);
                ttobj.speak(textToSay, TextToSpeech.QUEUE_ADD, null, "Enter text here field");
            }
        });

    }
}
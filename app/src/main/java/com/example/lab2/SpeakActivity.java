package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class SpeakActivity extends AppCompatActivity {
    private EditText userEnteredTextField;
    private TextToSpeech ttobj;
    private Button backToMainActivityFromSpeakActivityBtn;
    private Button speakEnteredTextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speak);

        backToMainActivityFromSpeakActivityBtn = findViewById(R.id.backBtn);
        userEnteredTextField = findViewById(R.id.enterTextField);

        backToMainActivityFromSpeakActivityBtn.setOnClickListener(v -> finish());

        speakEnteredTextBtn = findViewById(R.id.speakBtn);
        speakEnteredTextBtn.setOnClickListener(v -> ttobj = new TextToSpeech(getApplicationContext(), status -> {
            if (status != TextToSpeech.ERROR) {
                ttobj.setLanguage(Locale.CANADA_FRENCH);
                String textToSay = userEnteredTextField.getText().toString();
                ttobj.speak(textToSay, TextToSpeech.QUEUE_ADD, null, "Enter text here field");
            }
        }));
    }
}
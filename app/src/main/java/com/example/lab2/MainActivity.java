package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ConstraintLayout mainLayout;
        mainLayout = findViewById(R.id.mainLayout);
        Button changeBackgroundBtn = findViewById(R.id.changeBackgroundBtn);
        Button textToSpeechBtn = findViewById(R.id.textToSpeechBtn);

        Random rnd = new Random();
        changeBackgroundBtn.setOnClickListener(v -> {
            int colour = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            mainLayout.setBackgroundColor(colour);
            Toast.makeText(MainActivity.this, "New Test", Toast.LENGTH_LONG).show();
        });

        textToSpeechBtn.setOnClickListener(v -> {
            Intent intent = new Intent(this, SpeakActivity.class);
            startActivity(intent);


        });

        Button apiVersionButton = findViewById(R.id.apiVersionBtn);
        apiVersionButton.setOnClickListener(v -> {
            String manufacturer = android.os.Build.MANUFACTURER;
            String model = android.os.Build.MODEL;
            int version = android.os.Build.VERSION.SDK_INT;
            String versionRelease = android.os.Build.VERSION.RELEASE;
            String messageText = " manufacturer " + manufacturer
                    + " \n model " + model
                    + " \n version " + version
                    + " \n versionRelease " + versionRelease;

           Toast toast = Toast.makeText(MainActivity.this, messageText, Toast.LENGTH_LONG);
           TextView apiView = toast.getView().findViewById(android.R.id.message);
           apiView.setTextColor(Color.RED);
           toast.show();
        });

        Button serialNumberButton = findViewById(R.id.serialNumberBtn);
        serialNumberButton.setOnClickListener(v -> {
            String deviceId = Settings.System.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_TEXT, deviceId);
            intent.setType("text/plain");

            Intent shareIntent = Intent.createChooser(intent, null);

            startActivity(shareIntent);
        });


    }

}
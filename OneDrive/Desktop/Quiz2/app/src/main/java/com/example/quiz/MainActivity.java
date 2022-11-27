package com.example.quiz;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity"    ;
    Button Start;
    Vibrator vibes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        Log.d(TAG, "onCreate: Startup Page.");
        Start = (Button) findViewById(R.id.strtbtn);
        vibes = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Quiz will Start!");
                if (Build.VERSION.SDK_INT >= 26) {
                    vibes.vibrate(VibrationEffect.createOneShot(250, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    vibes.vibrate(250);
                }
                ToastMessage();
                Intent intent = new Intent(MainActivity.this,quizsecond.class);
                startActivity(intent);
                finish();

            }
        });
    }
    private void ToastMessage() {
        Toast.makeText(MainActivity.this, "Quiz will start now!", Toast.LENGTH_SHORT).show();
    }
}

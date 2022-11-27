package com.example.quiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static java.lang.Integer.parseInt;

public class Score_Page extends AppCompatActivity {
    Button replay;
    Button exit;
    Vibrator viber;
    public SharedPreferences scores;
    public SharedPreferences.Editor scoreedit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scorepage);
        getSupportActionBar().hide();
        viber = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        Intent incintent = getIntent();
        String inScore = incintent.getStringExtra("Score");
        TextView finscore = (TextView) findViewById(R.id.Scoreview);
        TextView highscore = (TextView) findViewById(R.id.highscoreview);
        finscore.setText(inScore);
        replay = (Button) findViewById(R.id.Replay);
        exit = (Button) findViewById(R.id.back);

        scores = PreferenceManager.getDefaultSharedPreferences(this);
        scoreedit = scores.edit();
        if (scores.contains("High Score")) {
            if (parseInt(inScore) > scores.getInt("High Score",0)) {
                scoreedit.putInt("High Score",parseInt(inScore));
                scoreedit.commit();
            }
        } else {
            scoreedit.putInt("High Score",parseInt(inScore));
            scoreedit.commit();
        }
        highscore.setText(String.valueOf(scores.getInt("High Score",0)));
        replay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= 26) {
                    viber.vibrate(VibrationEffect.createOneShot(250, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    viber.vibrate(250);
                }
                Intent restart = new Intent(Score_Page.this, quizsecond.class);
                startActivity(restart);
                finish();
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= 26) {
                    viber.vibrate(VibrationEffect.createOneShot(250, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    viber.vibrate(250);
                }
                Intent back = new Intent(Score_Page.this, MainActivity.class);
                startActivity(back);
                finish();
            }
        });


    }


}

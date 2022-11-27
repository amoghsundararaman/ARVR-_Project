package com.example.quiz;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

import static java.lang.Integer.parseInt;

public class quizsecond extends AppCompatActivity {
    private static final String TAG = "quizsecond";
    public int currscore = 0;
    public static int con = 1;
    public int corrday = 0;
    public List<String> ranDate = new ArrayList<String>();
    public List<String> choices = new ArrayList<String>();
    public List<String> days = new ArrayList<String>();
    View view;
    private TextView quedate;
    private TextView Score ;
    private Button option1 ;
    private Button option2 ;
    private Button option3 ;
    private Button option4 ;
    private TextView timer;
    private CountDownTimer counter;
    private long timeleft = 60000;
    private boolean timerun;
    Vibrator vibey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quizsecondpage);
        getSupportActionBar().hide();
        vibey = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        view = this.getWindow().getDecorView();
        quedate = findViewById(R.id.QueDate);
        Score = (TextView) findViewById(R.id.Scoreval);
        option1 = (Button) findViewById(R.id.option1);
        option2 = (Button) findViewById(R.id.option2);
        option3 = (Button) findViewById(R.id.option3);
        option4 = (Button) findViewById(R.id.option4);
        timer = findViewById(R.id.timer);
        startstop();
        days.add("Sunday");
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("Friday");
        days.add("Saturday");

        ranDate = generateRandomDate();
        quedate.setText(ranDate.get(1));
        Score.setText("Score = " + String.valueOf(currscore));
        corrday = parseInt(ranDate.get(0)) - 1;

        choices = Opcreator(ranDate, days);
        Opsetter(choices, option1, option2, option3, option4);

                option1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d(TAG, "onClick: Option Selected!");
                        if (Build.VERSION.SDK_INT >= 26) {
                            vibey.vibrate(VibrationEffect.createOneShot(250, VibrationEffect.DEFAULT_AMPLITUDE));
                        } else {
                            vibey.vibrate(250);
                        }
                        String btnText = option1.getText().toString();
                        if (btnText.equals(days.get(corrday)) ) {
                            Correct();
                            currscore+=1;
                            startTimer();
                            timeleft += 6000;
                            updateTimer();
                            startTimer();
                            replacetext(quedate, Score);
                            corrday = parseInt(ranDate.get(0)) - 1;
                            choices = Opcreator(ranDate, days);
                            Opsetter(choices, option1, option2, option3, option4);

                        }
                        else {
                            Wrong();
                            stopTimer();
                            if (timeleft >= 10000) {
                                timeleft -= 10000;
                            } else {
                                Intent end = new Intent(quizsecond.this,Score_Page.class);
                                end.putExtra("Score",String.valueOf(currscore));
                                startActivity(end);
                                finish();
                            }
                            updateTimer();
                            startTimer();
                            replacetext(quedate, Score);
                            corrday = parseInt(ranDate.get(0)) - 1;
                            choices = Opcreator(ranDate, days);
                            Opsetter(choices, option1, option2, option3, option4);
                        }
                    }
                });
                option2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (Build.VERSION.SDK_INT >= 26) {
                            vibey.vibrate(VibrationEffect.createOneShot(250, VibrationEffect.DEFAULT_AMPLITUDE));
                        } else {
                            vibey.vibrate(250);
                        }
                        String btnText = option2.getText().toString();
                        if (btnText.equals(days.get(corrday)) ) {
                            Correct();
                            stopTimer();
                            currscore+=1;
                            timeleft += 6000;
                            updateTimer();
                            startTimer();
                            replacetext(quedate, Score);
                            corrday = parseInt(ranDate.get(0)) - 1;
                            choices = Opcreator(ranDate, days);
                            Opsetter(choices, option1, option2, option3, option4);
                        }
                        else {
                            Wrong();
                            stopTimer();
                            if (timeleft >= 10000) {
                                timeleft -= 10000;
                            } else {
                                Intent end = new Intent(quizsecond.this,Score_Page.class);
                                end.putExtra("Score",String.valueOf(currscore));
                                startActivity(end);
                                finish();
                            }
                            updateTimer();
                            startTimer();
                            replacetext(quedate, Score);
                            corrday = parseInt(ranDate.get(0)) - 1;
                            choices = Opcreator(ranDate, days);
                            Opsetter(choices, option1, option2, option3, option4);

                        }
                    }
                });
                option3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (Build.VERSION.SDK_INT >= 26) {
                            vibey.vibrate(VibrationEffect.createOneShot(250, VibrationEffect.DEFAULT_AMPLITUDE));
                        } else {
                            vibey.vibrate(250);
                        }
                        String btnText = option3.getText().toString();
                        if (btnText.equals(days.get(corrday)) ) {
                            Correct();
                            currscore+=1;
                            stopTimer();
                            timeleft += 6000;
                            updateTimer();
                            startTimer();
                            replacetext(quedate, Score);
                            corrday = parseInt(ranDate.get(0)) - 1;
                            choices = Opcreator(ranDate, days);
                            Opsetter(choices, option1, option2, option3, option4);
                        }
                        else {
                            Wrong();
                            stopTimer();
                            if (timeleft >= 10000) {
                                timeleft -= 10000;
                            } else {
                                Intent end = new Intent(quizsecond.this,Score_Page.class);
                                end.putExtra("Score",String.valueOf(currscore));
                                startActivity(end);
                                finish();
                            }
                            updateTimer();
                            startTimer();
                            replacetext(quedate, Score);
                            corrday = parseInt(ranDate.get(0)) - 1;
                            choices = Opcreator(ranDate, days);
                            Opsetter(choices, option1, option2, option3, option4);
                        }
                    }
                });
                option4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (Build.VERSION.SDK_INT >= 26) {
                            vibey.vibrate(VibrationEffect.createOneShot(250, VibrationEffect.DEFAULT_AMPLITUDE));
                        } else {
                            vibey.vibrate(250);
                        }
                        String btnText = option4.getText().toString();
                        if ( btnText.equals(days.get(corrday) )) {
                            Correct();
                            stopTimer();
                            currscore+=1;
                            timeleft += 6000;
                            updateTimer();
                            startTimer();
                            replacetext(quedate, Score);
                            corrday = parseInt(ranDate.get(0)) - 1;
                            choices = Opcreator(ranDate, days);
                            Opsetter(choices, option1, option2, option3, option4);
                        }
                        else {
                            Wrong();
                            stopTimer();
                            if (timeleft >= 10000) {
                                timeleft -= 10000;
                            } else {
                                Intent end = new Intent(quizsecond.this,Score_Page.class);
                                end.putExtra("Score",String.valueOf(currscore));
                                startActivity(end);
                                finish();
                            }
                            updateTimer();
                            startTimer();
                            replacetext(quedate, Score);
                            corrday = parseInt(ranDate.get(0)) - 1;
                            choices = Opcreator(ranDate, days);
                            Opsetter(choices, option1, option2, option3, option4);
                        }
                    }
                });
            }

    public List<String> generateRandomDate() {
        List<String> randate = new ArrayList<String>();
        GregorianCalendar gc = new GregorianCalendar();
        int year = randBetween(2021,2021);
        gc.set(GregorianCalendar.YEAR,year);
        int dayofYear = randBetween(1,gc.getActualMaximum(GregorianCalendar.DAY_OF_YEAR));
        gc.set(GregorianCalendar.DAY_OF_YEAR,dayofYear);
        int month = gc.get(GregorianCalendar.MONTH) + 1;
        String randay = String.valueOf(gc.get(GregorianCalendar.DAY_OF_WEEK));
        randate.add(randay);
        randate.add(gc.get(GregorianCalendar.DAY_OF_MONTH) + " - " + month + " - " + gc.get(GregorianCalendar.YEAR));
        return randate;
    }
    private static int randBetween(int start, int end) {
               return start + (int) Math.round(Math.random() * (end - start));
    }
    private static int rerandomize(int daynum,List<Integer> check) {
              while (check.contains(daynum)) {
                  daynum = randBetween(0, 6);
              };
              return daynum;
    }
    private void Correct() {
        Toast.makeText(quizsecond.this, "Correct!", Toast.LENGTH_SHORT).show();
    }
    private void Wrong() {
        Toast.makeText(quizsecond.this, "Wrong!", Toast.LENGTH_SHORT).show();
    }
    private void replacetext (TextView t1, TextView t2) {
        ranDate = generateRandomDate();
        t1.setText(ranDate.get(1));
        t2.setText("Score = " + String.valueOf(currscore));

    }
    private List<String> Opcreator (List<String> passdate, List<String> passweek) {
        int corrday = parseInt(passdate.get(0)) - 1;
        List<String> finalops = new ArrayList<String>();
        List<Integer> checklist = new ArrayList<Integer>();
        finalops.add(passweek.get(corrday));
        int daychoice1 = randBetween(0,6);
        checklist.add(corrday);
        daychoice1 = rerandomize(daychoice1,checklist);
        finalops.add(passweek.get(daychoice1));

        int daychoice2 = randBetween(0,6);
        checklist.add(daychoice1);
        daychoice2 = rerandomize(daychoice2,checklist);
        finalops.add(passweek.get(daychoice2));

        int daychoice3 = randBetween(0,6);
        checklist.add(daychoice2);
        daychoice3 = rerandomize(daychoice3,checklist);
        finalops.add(passweek.get(daychoice3));
        return finalops;
    }
    private void Opsetter (List<String> setdates, Button b1,Button b2, Button b3, Button b4) {
        Collections.shuffle(setdates);
        b1.setText(setdates.get(0));
        b2.setText(setdates.get(1));
        b3.setText(setdates.get(2));
        b4.setText(setdates.get(3));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("quedate",quedate.getText().toString());
        outState.putString("Score",Score.getText().toString());
        outState.putString("option1",option1.getText().toString());
        outState.putString("option2",option2.getText().toString());
        outState.putString("option3",option3.getText().toString());
        outState.putString("option4",option4.getText().toString());
        outState.putInt("currscore",currscore);
        outState.putInt("corrday",corrday);
        outState.putString("Timecount",timer.getText().toString());
        outState.putBoolean("timerun",timerun);
        outState.putInt("timeleft", (int) timeleft);
        super.onSaveInstanceState(outState);
        stopTimer();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        currscore = savedInstanceState.getInt("currscore");
        corrday = savedInstanceState.getInt("corrday");
        quedate.setText(savedInstanceState.getString("quedate"));;
        Score.setText(savedInstanceState.getString("Score"));
        option1.setText(savedInstanceState.getString("option1"));;
        option2.setText(savedInstanceState.getString("option2"));;
        option3.setText(savedInstanceState.getString("option3"));;
        option4.setText(savedInstanceState.getString("option4"));;
        timer.setText(savedInstanceState.getString("Timecount"));
        timerun = savedInstanceState.getBoolean("timerun");
        timeleft = savedInstanceState.getInt("timeleft");
        startTimer();
    }

    private void startstop () {
        if (timerun) {
            stopTimer();
        } else {
            startTimer();
        }
    }

    public void stopTimer() {
          counter.cancel();
          timerun = false;
    }

    public void startTimer() {
          counter = new CountDownTimer(timeleft,1000) {
              @Override
              public void onTick(long millisUntilFinished) {
                    timeleft = millisUntilFinished;
                    updateTimer();
              }

              @Override
              public void onFinish() {
                  Intent end = new Intent(quizsecond.this,Score_Page.class);
                  end.putExtra("Score",String.valueOf(currscore));
                  startActivity(end);
                  finish();
              }
          }.start();
          timerun = true;
    }

    public void updateTimer() {
        int minutes = (int) timeleft/60000;
        int seconds = (int) (timeleft % 60000)/1000;
        String timetext;
        timetext = "" + minutes;
        timetext += ":";
        if (seconds < 10) {
            timetext += "0";
        }
        timetext += seconds;
        timer.setText(timetext);

    }
}

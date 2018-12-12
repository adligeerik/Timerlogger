package com.example.erikv.timerlogger;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class StartActivity extends AppCompatActivity {

    Chronometer simpleChronometer;
    TextView timerdisplay;
    Button startbutton;
    public int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        timerdisplay = (TextView)findViewById(R.id.textView);
        startbutton = (Button)findViewById(R.id.startbutton);
        simpleChronometer = (Chronometer) findViewById(R.id.counter); // initiate a chronometer

        //startbutton.setOnClickListener(this);
    }



    /** Called when the user taps the Start activity button */
    public void startTiming(View view) {
        String msg = "test";
        timerdisplay.setText(msg);
        new CountDownTimer(30000, 1000){
            public void onTick(long millisUntilFinished){
                timerdisplay.setText(String.valueOf(counter));
                counter++;
            }
            public  void onFinish(){
                timerdisplay.setText("FINISH!!");
            }
        }.start();
    }

}

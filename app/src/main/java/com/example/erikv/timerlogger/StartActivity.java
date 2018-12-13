package com.example.erikv.timerlogger;

import android.content.Intent;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import static android.provider.AlarmClock.EXTRA_MESSAGE;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class StartActivity extends AppCompatActivity {

    Chronometer simpleChronometer;
    TextView timerdisplay;
    Button startbutton;
    Date currentTime;
    String starttime;

    boolean iscounting = FALSE;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        initparams();
    }

    private void initparams(){
        timerdisplay = (TextView)findViewById(R.id.textView);
        startbutton = (Button)findViewById(R.id.startbutton);
        simpleChronometer = (Chronometer) findViewById(R.id.counter); // initiate a chronometer
        //simpleChronometer.setFormat("Time Running - %s");
        simpleChronometer.stop();
    }


    /** Called when the user taps the Start activity button */
    public void startTiming(View view) {
        if (!iscounting){
            currentTime = Calendar.getInstance().getTime();
            simpleChronometer.setBase(SystemClock.elapsedRealtime());
            simpleChronometer.start();
            starttime = String.valueOf(currentTime).split(" ")[3];
            //long timestamp = Long.valueOf(Calendar.getInstance().getTime()) / 1000;
            timerdisplay.setText(String.valueOf(System.currentTimeMillis() / 1000L));
            startbutton.setText("STOP ACTIVITY");
            iscounting = TRUE;
        }
        else if(iscounting){
            Intent intent = new Intent(this, AddNewActivity.class);
            intent.putExtra(starttime,0);
            startActivity(intent);

            simpleChronometer.stop();
            startbutton.setText("START ACTIVITY");
            timerdisplay.setText("Start time");
            iscounting = FALSE;
        }
    }

}

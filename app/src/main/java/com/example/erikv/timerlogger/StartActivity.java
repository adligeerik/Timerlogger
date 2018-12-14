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

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static android.provider.AlarmClock.EXTRA_MESSAGE;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class StartActivity extends AppCompatActivity {

    Chronometer simpleChronometer;
    TextView timerdisplay;
    Button startbutton;
    Button createutton;
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
        createutton = (Button)findViewById(R.id.createactivitybutton);

        simpleChronometer = (Chronometer) findViewById(R.id.counter); // initiate a chronometer
        simpleChronometer.stop();
    }

    /** Called when the user taps the create new activity button */
    public void createNewCategory(View view) {
        Intent intentcreate = new Intent(this, CreateNewCategoryActivity.class);
        startActivity(intentcreate);
    }

    /** Called when the user taps the Start activity button */
    public void startTiming(View view) {
        if (!iscounting){
            currentTime = Calendar.getInstance().getTime();
            simpleChronometer.setBase(SystemClock.elapsedRealtime());
            simpleChronometer.start();
            starttime = String.valueOf(currentTime).split(" ")[3];
            //long timestamp = Long.valueOf(Calendar.getInstance().getTime()) / 1000;

            String dateformat = DateFormat.getDateInstance().format(currentTime);
            //DateFormat format = new SimpleDateFormat(dateformat, Locale.ENGLISH);

            /**
            try {
                cal.setTime(format.parse(starttime));
            } catch (ParseException e) {
                e.printStackTrace();
            }
             */
            timerdisplay.setText(starttime);
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

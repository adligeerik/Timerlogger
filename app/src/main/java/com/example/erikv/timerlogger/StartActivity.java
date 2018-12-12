package com.example.erikv.timerlogger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class StartActivity extends AppCompatActivity {

    TextView timerdisplay;
    Button startbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        timerdisplay = (TextView)findViewById(R.id.textView);
        startbutton = (Button)findViewById(R.id.startbutton);
        //startbutton.setOnClickListener(this);
    }



    /** Called when the user taps the Start activity button */
    public void startTiming(View view) {
        //Intent intent = new Intent(this, DisplayMessageActivity.class);
        //TextView textview = (TextView)findViewById(R.id.textView);
        String msg = "test";
        timerdisplay.setText(msg);
        //intent.putExtra(EXTRA_MESSAGE, message);
        //startActivity(intent);
    }

}

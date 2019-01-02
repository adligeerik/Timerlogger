package com.example.erikv.timerlogger;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class CreateNewCategoryActivity extends AppCompatActivity {

    private static final String TAG = "bufferreader";
    String filename = "categories";
    FileOutputStream outputStream;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_category);
    }


    public void addCategory(View view){


        EditText editText = (EditText) findViewById(R.id.categoryName);

        String fileContents = editText.getText().toString();

        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(fileContents.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        StringBuilder text = new StringBuilder();
        String line;

        try {
            text.append("line5");
            BufferedReader bufferedreader = new BufferedReader(new FileReader(filename));
            text.append("line4");
            while ((line = bufferedreader.readLine()) != null) {
                //text.append(line);
                //text.append('\n');
                text.append("line");
            }
            text.append("line2");

            bufferedreader.close();

        } catch (IOException e){

            Log.d(TAG, "onClick", e);
        }
        text.append("line3");
        TextView textView = findViewById(R.id.textviewtest);
        textView.setText(text.toString());

    }
}

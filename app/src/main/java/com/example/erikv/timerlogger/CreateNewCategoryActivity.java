package com.example.erikv.timerlogger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.FileNotFoundException;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class CreateNewCategoryActivity extends AppCompatActivity {

    String fileName = "categories";
    Boolean isFile = FALSE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_category);
    }


    public void addCategory(View view){

        if (!isFile){
            try {
                openFileInput(fileName);
                isFile = TRUE;
            } catch (FileNotFoundException e) {
                
            }
        }

    }
}

package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class Checkbox extends AppCompatActivity {

    CheckBox read, play, write, cook;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbox);
        read = (CheckBox) findViewById(R.id.checkBox5);
        write = (CheckBox) findViewById(R.id.checkBox6);
        play = (CheckBox) findViewById(R.id.checkBox7);
        cook = (CheckBox) findViewById(R.id.checkBox8);
        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String res = "Selected Hobbies are";
                if (read.isChecked()){
                    res += "\nReading";
                }
                if (write.isChecked()){
                    res += "\nWriting";
                }
                if (play.isChecked()){
                    res += "\nPlaying";
                }
                if (cook.isChecked()){
                    res += "\nCooking";
                }
                Toast.makeText(getApplicationContext(),res,Toast.LENGTH_SHORT).show();
            }
        });

    }

}
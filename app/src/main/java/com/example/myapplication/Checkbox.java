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
        submit = (Button) findViewById(R.id.button);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String res = "Selected Hobbies are";
                if (read.isChecked()) {
                    res += "\nReading";
                }
                if (write.isChecked()) {
                    res += "\nWriting";
                }
                if (play.isChecked()) {
                    res += "\nPlaying";
                }
                if (cook.isChecked()) {
                    res += "\nCooking";
                }
                Toast.makeText(getApplicationContext(), res, Toast.LENGTH_SHORT).show();
            }

        });


    }

    public void click(View view) {
        boolean check = ((CheckBox) view).isChecked();
        String str = " ";
        switch (view.getId()){
            case R.id.checkBox5:
                str = check?"Reading is Selected":"Reading is Deselected";
                break;
            case R.id.checkBox6:
                str = check?"Writing is Selected":"Writing is Deselected";
                break;
            case R.id.checkBox7:
                str = check?"Playing is Selected":"Playing is Deselected";
                break;
            case R.id.checkBox8:
                str = check?"Cooking is Selected":"Cooking is Deselected";
                break;
        }
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
    }
}
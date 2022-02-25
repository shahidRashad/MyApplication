package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class Temp extends AppCompatActivity {


    CheckBox and, py;
    String str = " ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);
        and = (CheckBox) findViewById(R.id.Android);
        py = (CheckBox) findViewById(R.id.Python);
        Button b = (Button) findViewById(R.id.button2);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String r = "selected courses are";
                if (and.isChecked()){
                    r += "\nAndroid";
                }
                if (py.isChecked()){
                    r += "\nPython";
                }
                Toast.makeText(getApplicationContext(), r, Toast.LENGTH_SHORT).show();
            }

        });

    }

    public void test(View view) {
        boolean che = ((CheckBox) view).isChecked();
        String str = che? "Python selected":"Python Deselected";
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
    }

    public void check(View view) {
        boolean che = ((CheckBox) view).isChecked();
        String str = che? "Android selected":"Android Deselected";
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
    }
}
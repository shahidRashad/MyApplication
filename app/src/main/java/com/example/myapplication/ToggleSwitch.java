package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

public class ToggleSwitch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle_switch);

        Switch s1 = (Switch) findViewById(R.id.switch1);
        Switch s2 = (Switch) findViewById(R.id.switch2);
        Button button = (Button) findViewById(R.id.get);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str1, str2;
                if (s1.isChecked()){
                    str1 = s1.getTextOn().toString();
                }
                else{
                    str1 = s1.getTextOff().toString();
                }
                if (s2.isChecked()){
                    str2 = s2.getTextOn().toString();
                }
                else{
                    str2 = s2.getTextOff().toString();
                }
                Toast.makeText(getApplicationContext(), "Bluetooth "+str1+"\nWiFi "+str2, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
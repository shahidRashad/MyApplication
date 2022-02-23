package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RadioCheck extends AppCompatActivity implements View.OnClickListener {

    RadioGroup rg;
    RadioButton r1;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_check);
        rg = (RadioGroup) findViewById(R.id.radioGroup);
        Button b1 = (Button) findViewById(R.id.course);
        b1.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        r1 = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
        String res = r1.getText().toString();
        Toast.makeText(getApplicationContext(),res,Toast.LENGTH_SHORT).show();
    }
}
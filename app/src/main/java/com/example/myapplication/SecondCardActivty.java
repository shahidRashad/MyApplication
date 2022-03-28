package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class SecondCardActivty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_card);

        ImageView selectedimg = (ImageView) findViewById(R.id.selimg);
        Intent intent = getIntent();
        selectedimg.setImageResource(intent.getIntExtra("image",0));
    }
}
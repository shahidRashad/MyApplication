package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class CustomList extends AppCompatActivity {

    String fruit[] = {"Mango","Orange","Apple","Grapes","Pineapple"};
    int fruitimg[] = {R.drawable.mango,R.drawable.orange,R.drawable.apple,R.drawable.grape,R.drawable.ananas};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);

        ListView fruits = (ListView) findViewById(R.id.fruits);

        CustomAdapt cadapt = new CustomAdapt(getApplicationContext(),fruit,fruitimg);
        fruits.setAdapter(cadapt);

    }
}